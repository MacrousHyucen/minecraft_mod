package net.archasmiel.thaumcraft.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerType;


public class ThaumonomiconGui extends SyncedGuiDescription {

    public ThaumonomiconGui(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory);
    }

}
