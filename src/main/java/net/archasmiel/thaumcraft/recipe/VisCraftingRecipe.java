package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.blockentity.inventory.ImplementedInventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;

public interface VisCraftingRecipe extends Recipe<ImplementedInventory> {
    default RecipeType<?> getType() {
        return Recipes.VIS_RECIPE_TYPE;
    }

    void visCraft(ImplementedInventory inv);
}
