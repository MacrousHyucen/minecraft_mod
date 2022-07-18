package net.archasmiel.thaumcraft.recipe;

import com.google.common.collect.Maps;
import com.google.gson.*;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.Pair;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Map;

public record ThaumcraftShapedRecipe(Identifier id,
                                     DefaultedList<Ingredient> input,
                                     ItemStack output,
                                     Pair<Integer, Integer> recipeSizes) implements CraftingRecipe {

    @Override
    public ItemStack craft(CraftingInventory craftingInventory) {
        return this.getOutput().copy();
    }

    @Override
    public boolean matches(CraftingInventory craftingInventory, World world) {
        for(int i = 0; i <= craftingInventory.getWidth() - recipeSizes.getLeft(); ++i) {
            for(int j = 0; j <= craftingInventory.getHeight() - recipeSizes.getRight(); ++j) {
                if (this.matchesPattern(craftingInventory, i, j, true)) {
                    return true;
                }

                if (this.matchesPattern(craftingInventory, i, j, false)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean matchesPattern(CraftingInventory inv, int offsetX, int offsetY, boolean flipped) {
        for(int i = 0; i < inv.getWidth(); ++i) {
            for(int j = 0; j < inv.getHeight(); ++j) {
                int k = i - offsetX;
                int l = j - offsetY;
                Ingredient ingredient = Ingredient.EMPTY;
                if (k >= 0 && l >= 0 && k < recipeSizes.getLeft() && l < recipeSizes.getRight()) {
                    if (flipped) {
                        ingredient = this.input.get(recipeSizes.getLeft() - k - 1 + l * recipeSizes.getLeft());
                    } else {
                        ingredient = this.input.get(k + l * recipeSizes.getLeft());
                    }
                }

                if (!ingredient.test(inv.getStack(i + j * inv.getWidth()))) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    public Pair<Integer, Integer> getRecipeSizes() {
        return recipeSizes;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }






    // get keys from json object
    static Map<String, Ingredient> readSymbols(JsonObject json) {
        Map<String, Ingredient> map = Maps.newHashMap();

        for (Map.Entry<String, JsonElement> stringJsonElementEntry : json.entrySet()) {
            if (stringJsonElementEntry.getKey().length() != 1) {
                throw new JsonSyntaxException("Invalid key entry: '" + stringJsonElementEntry.getKey() + "' is an invalid symbol (must be 1 character only).");
            }

            if (" ".equals(stringJsonElementEntry.getKey())) {
                throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
            }

            map.put(stringJsonElementEntry.getKey(), Ingredient.fromJson(stringJsonElementEntry.getValue()));
        }

        map.put(" ", Ingredient.EMPTY);
        return map;
    }

    // get registry item from json object
    public static Item getItem(JsonObject json) {
        String string = JsonHelper.getString(json, "item");
        Item item = Registry.ITEM.getOrEmpty(
                new Identifier(string)
        ).orElseThrow(
                () -> new JsonSyntaxException("Unknown item '" + string + "'")
        );
        if (item == Items.AIR) {
            throw new JsonSyntaxException("Invalid item: " + string);
        } else {
            return item;
        }
    }

    // get output from json
    public static ItemStack outputFromJson(JsonObject json) {
        Item item = getItem(json);
        if (json.has("data")) {
            throw new JsonParseException("Disallowed data tag found");
        } else {
            int i = JsonHelper.getInt(json, "count", 1);
            if (i < 1) {
                throw new JsonSyntaxException("Invalid output count: " + i);
            } else {
                return new ItemStack(item, i);
            }
        }
    }

    // read pattern from json
    static String[] readPattern(JsonArray pattern) {
        String[] strings = new String[pattern.size()];

        for (int i = 0; i < strings.length; ++i) {
            strings[i] = JsonHelper.asString(pattern.get(i), "pattern[" + i + "]");
        }

        return strings;
    }

    // get ingredient list from pattern and keys
    static DefaultedList<Ingredient> readIngredients(String[] pattern, Map<String, Ingredient> keys) {
        DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(9, Ingredient.EMPTY);
        String itemSymbol;

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length(); j++) {

                itemSymbol = pattern[i].substring(j, j + 1);
                if (keys.containsKey(itemSymbol)) {
                    ingredients.set(i * 3 + j, keys.get(itemSymbol));
                } else {
                    throw new JsonSyntaxException("Key " + itemSymbol + " not exist in recipe keys");
                }
            }
        }

        return ingredients;
    }

    static Pair<Integer, Integer> getRecipeSizes(String[] pattern) {
        Pair<Integer, Integer> sizes = new Pair<>(0, 0);

        sizes.setRight(pattern.length);
        if (pattern.length > 0)
            sizes.setLeft(pattern[0].length());
        else
            throw new JsonSyntaxException("Recipe size is 0");


        if (sizes.getLeft() == 0 && sizes.getRight() == 0) {
            throw new JsonSyntaxException("Recipe size is 0");
        }
        return sizes;
    }





    public static class Serializer implements RecipeSerializer<ThaumcraftShapedRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "arcane_shaped";


        @Override
        public ThaumcraftShapedRecipe read(Identifier id, JsonObject json) {

            Map<String, Ingredient> keys = readSymbols(JsonHelper.getObject(json, "key"));
            String[] pattern = readPattern(JsonHelper.getArray(json, "pattern"));
            Pair<Integer, Integer> recipeSizes = getRecipeSizes(pattern);
            DefaultedList<Ingredient> inputs = readIngredients(pattern, keys);
            ItemStack output = outputFromJson(JsonHelper.getObject(json, "result"));

            return new ThaumcraftShapedRecipe(id, inputs, output, recipeSizes);
        }

        @Override
        public ThaumcraftShapedRecipe read(Identifier id, PacketByteBuf buf) {
            Pair<Integer, Integer> recSizes = new Pair<>(buf.readVarInt(), buf.readVarInt());
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readVarInt(), Ingredient.EMPTY);

            for (int k = 0; k < inputs.size(); k++) {
                inputs.set(k, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new ThaumcraftShapedRecipe(id, inputs, output, recSizes);
        }

        @Override
        public void write(PacketByteBuf buf, ThaumcraftShapedRecipe recipe) {
            buf.writeVarInt(recipe.getRecipeSizes().getLeft());
            buf.writeVarInt(recipe.getRecipeSizes().getRight());

            buf.writeVarInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.output);
        }
    }

}
