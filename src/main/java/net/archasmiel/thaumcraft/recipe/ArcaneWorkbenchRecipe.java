package net.archasmiel.thaumcraft.recipe;

import com.google.common.collect.Maps;
import com.google.gson.*;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Map;

public record ArcaneWorkbenchRecipe(Identifier id,
                                    DefaultedList<Ingredient> inputs,
                                    ItemStack output) implements Recipe<SimpleInventory> {


    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        for (int i = 0; i < 9; i++) {
            if (!inputs.get(i).test(inventory.getStack(i))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
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
        return Type.INSTANCE;
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
            String string = JsonHelper.asString(pattern.get(i), "pattern[" + i + "]");
            if (string.length() != 3) {
                throw new JsonSyntaxException("Invalid pattern: incorrect pattern size - correct is 3x3");
            }

            strings[i] = string;
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


    public static class Type implements RecipeType<ArcaneWorkbenchRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "arcane_workbench";
    }


    public static class Serializer implements RecipeSerializer<ArcaneWorkbenchRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "arcane_workbench";


        @Override
        public ArcaneWorkbenchRecipe read(Identifier id, JsonObject json) {

            Map<String, Ingredient> keys = readSymbols(JsonHelper.getObject(json, "keys"));
            String[] pattern = readPattern(JsonHelper.getArray(json, "pattern"));
            DefaultedList<Ingredient> inputs = readIngredients(pattern, keys);
            ItemStack output = outputFromJson(JsonHelper.getObject(json, "result"));

            return new ArcaneWorkbenchRecipe(id, inputs, output);
        }

        @Override
        public ArcaneWorkbenchRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }

            ItemStack output = buf.readItemStack();
            return new ArcaneWorkbenchRecipe(id, inputs, output);
        }

        @Override
        public void write(PacketByteBuf buf, ArcaneWorkbenchRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }

}
