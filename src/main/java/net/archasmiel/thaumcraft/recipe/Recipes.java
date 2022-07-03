package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Recipes {


    private static void registerRecipes() {
        Registry.register(
                Registry.RECIPE_SERIALIZER,
                new Identifier(Thaumcraft.MOD_ID, ThaumcraftShapedRecipe.Serializer.ID),
                ThaumcraftShapedRecipe.Serializer.INSTANCE
        );
        Registry.register(
                Registry.RECIPE_TYPE,
                new Identifier(Thaumcraft.MOD_ID, ThaumcraftShapedRecipe.Type.ID),
                ThaumcraftShapedRecipe.Type.INSTANCE
        );
    }

    public static void register() {
        registerRecipes();
    }

}
