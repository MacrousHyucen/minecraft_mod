package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class Recipes {

    public static RecipeSerializer<VisShapedRecipe> VIS_SHAPED_RECIPE_SERIALIZER;
    public static RecipeType<VisShapedRecipe> VIS_SHAPED_RECIPE_TYPE;

    public static RecipeSerializer<VisShapelessRecipe> VIS_SHAPELESS_RECIPE_SERIALIZER;
    public static RecipeType<VisShapelessRecipe> VIS_SHAPELESS_RECIPE_TYPE;

    public static void register() {

        VIS_SHAPED_RECIPE_SERIALIZER = Registry.register(
            Registry.RECIPE_SERIALIZER,
            new Identifier(Thaumcraft.MOD_ID, VisShapedRecipe.Serializer.ID),
            VisShapedRecipe.Serializer.INSTANCE
        );

        VIS_SHAPED_RECIPE_TYPE = Registry.register(
                Registry.RECIPE_TYPE,
                new Identifier(Thaumcraft.MOD_ID, VisShapedRecipe.Type.ID),
                VisShapedRecipe.Type.INSTANCE
        );



        VIS_SHAPELESS_RECIPE_SERIALIZER = Registry.register(
                Registry.RECIPE_SERIALIZER,
                new Identifier(Thaumcraft.MOD_ID, VisShapelessRecipe.Serializer.ID),
                VisShapelessRecipe.Serializer.INSTANCE
        );

        VIS_SHAPELESS_RECIPE_TYPE = Registry.register(
                Registry.RECIPE_TYPE,
                new Identifier(Thaumcraft.MOD_ID, VisShapelessRecipe.Type.ID),
                VisShapelessRecipe.Type.INSTANCE
        );

    }

}
