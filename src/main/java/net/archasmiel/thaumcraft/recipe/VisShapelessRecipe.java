package net.archasmiel.thaumcraft.recipe;

import com.google.common.collect.Maps;
import com.google.gson.*;
import net.archasmiel.thaumcraft.blockentity.inventory.ImplementedInventory;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Objects;

public record VisShapelessRecipe(Identifier id,
                                 DefaultedList<Ingredient> input,
                                 Map<String, Float> vis,
                                 ItemStack output) implements Recipe<ImplementedInventory> {

    @Override
    public boolean matches(ImplementedInventory inventory, World world) {
        if (world.isClient) return false;

        if (!checkVis(inventory)) return false;

        RecipeMatcher recipeMatcher = new RecipeMatcher();
        int i = 0;

        for(int j = 0; j < 9; ++j) {
            ItemStack itemStack = inventory.getStack(j);
            if (!itemStack.isEmpty()) {
                ++i;
                recipeMatcher.addInput(itemStack, 1);
            }
        }

        return i == this.input.size() && recipeMatcher.match(this, null);
    }

    @Override
    public ItemStack craft(ImplementedInventory inventory) {
        return this.getOutput().copy();
    }

    public void visCraft(ImplementedInventory inventory) {
        ItemStack wand = inventory.getStack(9);
        WandAbstract currentWand = (WandAbstract) wand.getItem();

        NbtCompound wandVisData = wand.getNbt();
        if (wandVisData != null) {
            for (Map.Entry<String, Float> entry: vis.entrySet()) {
                String key = entry.getKey();
                wandVisData.putFloat(key, wandVisData.getFloat(key) - entry.getValue() * currentWand.getDiscount());
            }
        }
    }

    public boolean checkVis(ImplementedInventory inventory) {
        ItemStack wand = inventory.getStack(9);
        if (wand == ItemStack.EMPTY) return false;
        if (!(wand.getItem() instanceof WandAbstract wandCurrent)) return false;

        NbtCompound wandVisData;
        if ((wandVisData = wand.getNbt()) != null) {
            for (Map.Entry<String, Float> entry: vis.entrySet()) {
                if ((entry.getValue() * wandCurrent.getDiscount()) > wandVisData.getFloat(entry.getKey())){
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

    public Map<String, Float> getRecipeVis() {
        return vis;
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








    static Map<String, Float> readVis(JsonObject json) {
        Map<String, Float> vis = Maps.newHashMap();

        for (Map.Entry<String, JsonElement> stringJsonElementEntry : json.entrySet()) {
            String key = stringJsonElementEntry.getKey();
            float value = stringJsonElementEntry.getValue().getAsFloat();
            if (Objects.equals(key, "aer") || Objects.equals(key, "ignis") || Objects.equals(key, "aqua") ||
                    Objects.equals(key, "terra") || Objects.equals(key, "ordo") || Objects.equals(key, "perditio")){
                if (value > 0) vis.put(key, value);
            } else {
                throw new JsonSyntaxException("Vis name doesn't belong to {'aer', 'ignis', 'aqua', 'terra', 'ordo', 'perditio'}");
            }
        }

        return vis;
    }





    public static class Type implements RecipeType<VisShapelessRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "vis_shapeless";

    }

    public static class Serializer implements RecipeSerializer<VisShapelessRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "vis_shapeless";

        private static DefaultedList<Ingredient> getIngredients(JsonArray json) {
            DefaultedList<Ingredient> defaultedList = DefaultedList.of();

            for(int i = 0; i < json.size(); ++i) {
                Ingredient ingredient = Ingredient.fromJson(json.get(i));
                if (!ingredient.isEmpty()) {
                    defaultedList.add(ingredient);
                }
            }

            return defaultedList;
        }

        @Override
        public VisShapelessRecipe read(Identifier id, JsonObject json) {
            DefaultedList<Ingredient> input = getIngredients(JsonHelper.getArray(json, "ingredients"));
            Map<String, Float> vis = readVis(JsonHelper.getObject(json, "vis"));
            if (input.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            } else if (input.size() > 9) {
                throw new JsonParseException("Too many ingredients for shapeless recipe");
            } else {
                ItemStack output = VisShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
                return new VisShapelessRecipe(id, input, vis, output);
            }
        }

        @Override
        public VisShapelessRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readVarInt(), Ingredient.EMPTY);
            for (int k = 0; k < inputs.size(); k++) {
                inputs.set(k, Ingredient.fromPacket(buf));
            }

            Map<String, Float> vis = Maps.newHashMap();
            int visSize = buf.readVarInt();
            for (int k = 0; k < visSize; k++) {
                // must be in separate lines; server can't handle if not making new variable
                String key = buf.readString();
                Float value = buf.readFloat();
                vis.put(key, value);
            }

            ItemStack output = buf.readItemStack();
            return new VisShapelessRecipe(id, inputs, vis, output);
        }

        @Override
        public void write(PacketByteBuf buf, VisShapelessRecipe recipe) {
            buf.writeVarInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }

            buf.writeVarInt(recipe.getRecipeVis().size());
            for (Map.Entry<String, Float> entry: recipe.getRecipeVis().entrySet()) {
                buf.writeString(entry.getKey());
                buf.writeFloat(entry.getValue());
            }

            buf.writeItemStack(recipe.output);
        }
    }
}
