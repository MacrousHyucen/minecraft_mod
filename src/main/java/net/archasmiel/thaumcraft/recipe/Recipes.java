package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Recipes {

    public static RecipeSerializer<VisShapedRecipe> thaumcraftShapedRecipeSerializer;

    public static void register() {
        thaumcraftShapedRecipeSerializer = Registry.register(
            Registry.RECIPE_SERIALIZER,
            new Identifier(Thaumcraft.MOD_ID, VisShapedRecipe.Serializer.ID),
            VisShapedRecipe.Serializer.INSTANCE
        );

    }

}
