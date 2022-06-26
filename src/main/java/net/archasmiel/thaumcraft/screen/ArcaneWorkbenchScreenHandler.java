package net.archasmiel.thaumcraft.screen;

import net.archasmiel.thaumcraft.block.entity.ArcaneWorkbenchBlockEntity;
import net.archasmiel.thaumcraft.screen.slot.ResultSlot;
import net.archasmiel.thaumcraft.screen.slot.WandSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class ArcaneWorkbenchScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public ArcaneWorkbenchScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(ArcaneWorkbenchBlockEntity.GUI_SIZE));
    }

    public ArcaneWorkbenchScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ThaumcraftScreenHandlers.ARCANE_WORKBENCH_SCREEN_HANDLER, syncId);
        checkSize(inventory, ArcaneWorkbenchBlockEntity.GUI_SIZE);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        // craft slots
        for (int i = 0 ; i < 3 ; i++)
            for (int j = 0 ; j < 3 ; j++)
                this.addSlot(new Slot(inventory, i*3 + j, 40 + j*24, 40 + i*24));


        // output slot
        this.addSlot(new ResultSlot(inventory, 9, 160, 64));

        // wand slot
        this.addSlot(new WandSlot(inventory, 10, 160, 25));


    }





    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);

        System.out.println(invSlot + ", " + slot.getStack().getItem().getName());

        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, 9 + i*9 + l, 16 + 18*l, 151 + 18*i));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 16 + 18*i, 209));
        }
    }
}
