package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Recipes {

    private Recipes() {

    }

    public static RecipeType<VisCraftingRecipe> VIS_RECIPE_TYPE;
    public static RecipeSerializer<VisShapedRecipe> VIS_SHAPED_RECIPE_SERIALIZER;
    public static RecipeSerializer<VisShapelessRecipe> VIS_SHAPELESS_RECIPE_SERIALIZER;


    public static void register() {
        VIS_RECIPE_TYPE = registerType("vis_crafting");

        VIS_SHAPED_RECIPE_SERIALIZER = registerSerializer("vis_shaped", new VisShapedRecipe.Serializer());
        VIS_SHAPELESS_RECIPE_SERIALIZER = registerSerializer("vis_shapeless", new VisShapelessRecipe.Serializer());
    }





    static <T extends Recipe<?>, S extends RecipeSerializer<T>> S registerSerializer(String id, S serializer) {
        return Registry.register(
            Registry.RECIPE_SERIALIZER,
            new Identifier(Thaumcraft.MOD_ID, id),
            serializer
        );
    }

    static <T extends Recipe<?>> RecipeType<T> registerType(String id) {
        return Registry.register(
            Registry.RECIPE_TYPE,
            new Identifier(Thaumcraft.MOD_ID, id),
            new RecipeType<T>() {
                @Override
                public String toString() {
                    return id;
                }
            }
        );
    }

}
