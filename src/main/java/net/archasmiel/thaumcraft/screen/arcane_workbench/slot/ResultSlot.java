package net.archasmiel.thaumcraft.screen.arcane_workbench.slot;

import net.archasmiel.thaumcraft.blockentity.inventory.ImplementedInventory;
import net.archasmiel.thaumcraft.recipe.VisCraftingRecipe;
import net.archasmiel.thaumcraft.screen.arcane_workbench.inventory.CraftingWandInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.RecipeUnlocker;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;
import java.util.Optional;

import static net.archasmiel.thaumcraft.recipe.Recipes.VIS_RECIPE_TYPE;


public class ResultSlot extends Slot {

    private final CraftingInventory input;
    private final CraftingWandInventory wand;
    private final PlayerEntity player;
    private int amount;

    public ResultSlot(PlayerEntity player, CraftingInventory input, CraftingWandInventory wand, Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
        this.player = player;
        this.input = input;
        this.wand = wand;
    }

    public boolean canInsert(ItemStack stack) {
        return false;
    }

    public ItemStack takeStack(int amount) {
        if (this.hasStack()) {
            this.amount += Math.min(amount, this.getStack().getCount());
        }

        return super.takeStack(amount);
    }

    protected void onCrafted(ItemStack stack, int amount) {
        this.amount += amount;
        this.onCrafted(stack);
    }

    protected void onTake(int amount) {
        this.amount += amount;
    }

    protected void onCrafted(ItemStack stack) {
        if (this.amount > 0) {
            stack.onCraft(this.player.world, this.player, this.amount);
        }

        if (this.inventory instanceof RecipeUnlocker) {
            ((RecipeUnlocker)this.inventory).unlockLastRecipe(this.player);
        }

        this.amount = 0;
    }

    public void onTakeItem(PlayerEntity player, ItemStack stack) {
        this.onCrafted(stack);

        DefaultedList<ItemStack> defaultedList = checkRecipes(player.world.getRecipeManager());

        for(int i = 0; i < defaultedList.size(); ++i) {
            ItemStack itemStack = this.input.getStack(i);
            ItemStack itemStack2 = defaultedList.get(i);
            if (!itemStack.isEmpty()) {
                this.input.removeStack(i, 1);
                itemStack = this.input.getStack(i);
            }

            if (!itemStack2.isEmpty()) {
                if (itemStack.isEmpty()) {
                    this.input.setStack(i, itemStack2);
                } else if (ItemStack.areItemsEqualIgnoreDamage(itemStack, itemStack2) && ItemStack.areNbtEqual(itemStack, itemStack2)) {
                    itemStack2.increment(itemStack.getCount());
                    this.input.setStack(i, itemStack2);
                } else if (!this.player.getInventory().insertStack(itemStack2)) {
                    this.player.dropItem(itemStack2, false);
                }
            }
        }

    }

    private ImplementedInventory getVisInventory() {
        DefaultedList<ItemStack> inv = DefaultedList.ofSize(10, ItemStack.EMPTY);
        for (int i = 0 ; i < 9 ; i++)
            inv.set(i, input.getStack(i));
        return () -> inv;
    }

    private DefaultedList<ItemStack> checkRecipes(RecipeManager manager) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(9, ItemStack.EMPTY);
        ImplementedInventory inventory = getVisInventory();

        Optional<CraftingRecipe> optional = manager.getFirstMatch(RecipeType.CRAFTING, this.input, player.world);
        Optional<VisCraftingRecipe> optionalVis = manager.getFirstMatch(VIS_RECIPE_TYPE, inventory, player.world);

        if (optional.isPresent()){
            defaultedList = manager.getRemainingStacks(RecipeType.CRAFTING, this.input, player.world);
        }
        else
        if (optionalVis.isPresent() && optionalVis.get().checkVis(wand.getStack(0))) {
            DefaultedList<ItemStack> defaultedVisList = manager.getRemainingStacks(VIS_RECIPE_TYPE, inventory, player.world);

            for (int i = 0 ; i < 9 ; i++)
                defaultedList.set(i, defaultedVisList.get(i));

            optionalVis.get().visCraft(wand.getStack(0));
        }

        return defaultedList;
    }

}
