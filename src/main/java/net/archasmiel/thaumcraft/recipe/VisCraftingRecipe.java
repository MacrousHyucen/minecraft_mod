package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.blockentity.inventory.ImplementedInventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.world.World;

import java.util.Map;

public interface VisCraftingRecipe extends Recipe<ImplementedInventory> {
    default RecipeType<?> getType() {
        return Recipes.VIS_RECIPE_TYPE;
    }

    void visCraft(ImplementedInventory inv);
    Map<String, Float> getRecipeVis();
    boolean matchesItems(ImplementedInventory inventory, World world);
}
