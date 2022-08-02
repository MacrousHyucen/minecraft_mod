package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.blockentity.inventory.ImplementedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;

import java.util.Map;

public interface VisCraftingRecipe extends Recipe<ImplementedInventory> {
    default RecipeType<?> getType() {
        return Recipes.VIS_RECIPE_TYPE;
    }

    void visCraft(ItemStack wand);
    Map<String, Float> getRecipeVis();
    boolean checkVis(ItemStack stack);
}
