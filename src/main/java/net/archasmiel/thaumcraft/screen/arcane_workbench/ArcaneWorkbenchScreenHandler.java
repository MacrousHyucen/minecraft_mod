package net.archasmiel.thaumcraft.screen.arcane_workbench;

import net.archasmiel.thaumcraft.entity.arcane_workbench.ArcaneWorkbenchBlockEntity;
import net.archasmiel.thaumcraft.screen.ScreenHandlers;
import net.archasmiel.thaumcraft.screen.arcane_workbench.slot.ResultSlot;
import net.archasmiel.thaumcraft.screen.arcane_workbench.slot.WandSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;

public class ArcaneWorkbenchScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public ArcaneWorkbenchScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(ArcaneWorkbenchBlockEntity.GUI_SIZE));
    }

    public ArcaneWorkbenchScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ScreenHandlers.ARCANE_WORKBENCH_SCREEN_HANDLER, syncId);
        checkSize(inventory, ArcaneWorkbenchBlockEntity.GUI_SIZE);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        addGuiSlots();
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }







    @Override
    public void onSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player) {
        // checking if we're clicking slot 9 (output slot)
        if (slotIndex == 9 && !inventory.getStack(9).isEmpty()){
            // if we have QUICK_MOVE player gets 1 item immediately,
            // and we must give all possible items to player CAN BE crafted except one
            if (actionType == SlotActionType.QUICK_MOVE){
                // invisible PICKUP action

                // size of items player can craft
                int maxCraft = getMaximumCraftSize();

                // if we have items to craft > 0 we can give player
                if (maxCraft > 0) {
                    player.getInventory().insertStack(new ItemStack(inventory.getStack(9).getItem(), maxCraft-1));

                    for (int i = 0 ; i < 9 ; i++){
                        inventory.removeStack(i, maxCraft);
                    }
                }
            }

            if (actionType == SlotActionType.PICKUP) {
                for (int i = 0; i < 9; i++) {
                    inventory.removeStack(i, 1);
                }
            }
        }

        super.onSlotClick(slotIndex, button, actionType, player);
    }

    // maximum crafting size on-shift
    private int getMaximumCraftSize() {
        int j = 100000000;
        if (inventory.getStack(9).isEmpty())
            j = 0;
        else
            for (int i = 0 ; i < 9 ; i++){
                // finds a maximum count of items player can craft pressing shift+lmb
                if (inventory.getStack(i).getCount() > 0) {
                    if (j > inventory.getStack(i).getCount()) {
                        j = inventory.getStack(i).getCount();
                    }
                }

                // restriction to item max count
                j = Math.min(inventory.getStack(9).getItem().getMaxCount(), j);
            }

        return j;
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

        if (slot.hasStack()) {
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

    private void addGuiSlots() {
        // craft slots
        for (int i = 0 ; i < 3 ; i++)
            for (int j = 0 ; j < 3 ; j++)
                this.addSlot(new Slot(inventory, i*3 + j, 40 + j*24, 40 + i*24));


        // output slot
        this.addSlot(new ResultSlot(inventory, 9, 160, 64));

        // wand slot
        this.addSlot(new WandSlot(inventory, 10, 160, 25));
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
