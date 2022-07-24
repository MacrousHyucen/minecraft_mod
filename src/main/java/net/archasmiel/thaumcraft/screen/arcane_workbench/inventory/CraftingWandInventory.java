package net.archasmiel.thaumcraft.screen.arcane_workbench.inventory;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.collection.DefaultedList;

import java.util.Iterator;

public class CraftingWandInventory implements Inventory {
    private final DefaultedList<ItemStack> stacks;
    private final ScreenHandler handler;

    public CraftingWandInventory(ScreenHandler handler) {
        this.handler = handler;
        this.stacks = DefaultedList.ofSize(1, ItemStack.EMPTY);
    }

    public int size() {
        return this.stacks.size();
    }

    public boolean isEmpty() {
        Iterator<ItemStack> var1 = this.stacks.iterator();

        ItemStack itemStack;
        if (!var1.hasNext()) {
            return true;
        }

        itemStack = var1.next();
        while (itemStack.isEmpty()) {
            if (!var1.hasNext()) {
                return true;
            }

            itemStack = var1.next();
        }

        return false;
    }

    public ItemStack getStack(int slot) {
        return slot >= this.size() ? ItemStack.EMPTY : this.stacks.get(slot);
    }

    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.stacks, slot);
    }

    public ItemStack removeStack(int slot, int amount) {
        ItemStack itemStack = Inventories.splitStack(this.stacks, slot, amount);
        if (!itemStack.isEmpty()) {
            this.handler.onContentChanged(this);
        }

        return itemStack;
    }

    public void setStack(int slot, ItemStack stack) {
        this.stacks.set(slot, stack);
        this.handler.onContentChanged(this);
    }

    public void markDirty() {
    }

    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    public void clear() {
        this.stacks.clear();
    }

    public void provideRecipeInputs(RecipeMatcher finder) {
        for (ItemStack itemStack : this.stacks) {
            finder.addUnenchantedInput(itemStack);
        }
    }

}
