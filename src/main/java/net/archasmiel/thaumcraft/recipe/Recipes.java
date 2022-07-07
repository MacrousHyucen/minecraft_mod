package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Recipes {


    private static void registerRecipes() {
        RecipeSerializer<ThaumcraftShapedRecipe> thaumcraftShapedRecipeSerializer = register(
            new Identifier(Thaumcraft.MOD_ID, "shaped"),
            new ThaumcraftShapedRecipe.Serializer()
        );

//        RecipeType<CraftingRecipe> thaumcraftShapedRecipe = Registry.register(
//            Registry.RECIPE_TYPE,
//            new Identifier(Thaumcraft.MOD_ID, ThaumcraftShapedRecipe.Type.ID),
//            RecipeType.CRAFTING
//        );
    }

    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(Identifier id, S serializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, id, serializer);
    }

    public static void register() {
        registerRecipes();
    }

}
