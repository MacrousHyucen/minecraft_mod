package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Recipes {

    public static RecipeSerializer<ThaumcraftShapedRecipe> thaumcraftShapedRecipeSerializer;

    public static void register() {
        thaumcraftShapedRecipeSerializer = Registry.register(
            Registry.RECIPE_SERIALIZER,
            new Identifier(Thaumcraft.MOD_ID, ThaumcraftShapedRecipe.Serializer.ID),
            ThaumcraftShapedRecipe.Serializer.INSTANCE
        );

    }

}
