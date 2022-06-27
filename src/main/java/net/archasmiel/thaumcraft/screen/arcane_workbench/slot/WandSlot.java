package net.archasmiel.thaumcraft.screen.arcane_workbench.slot;

import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class WandSlot extends Slot {

    public WandSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.getItem() instanceof VisCraft;
    }


}
