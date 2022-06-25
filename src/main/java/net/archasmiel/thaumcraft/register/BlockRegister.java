package net.archasmiel.thaumcraft.register;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.block.advanced.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.advanced.DeconstructionTable;
import net.archasmiel.thaumcraft.block.advanced.Table;
import net.archasmiel.thaumcraft.block.basic.ThaumcraftBlock;
import net.archasmiel.thaumcraft.block.basic.blocks.BasicRotatableBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;

public class BlockRegister {

    public static final ThaumcraftBlock TABLE = new BasicRotatableBlock(
            new Table(
                FabricBlockSettings
                .copyOf(Blocks.CRAFTING_TABLE)
                .nonOpaque()
            ),
            "table"
    );



    public static final ThaumcraftBlock ARCANE_WORKBENCH = new BasicRotatableBlock(
            new ArcaneWorkbench(
                FabricBlockSettings
                .copyOf(Blocks.CRAFTING_TABLE)
                .nonOpaque()
            ),
            "arcane_workbench"
    );

    public static final ThaumcraftBlock DECONSTRUCTION_TABLE = new BasicRotatableBlock(
            new DeconstructionTable(
                FabricBlockSettings
                .copyOf(Blocks.CRAFTING_TABLE)
                .nonOpaque()
            ),
            "deconstruction_table"
    );



    private static void loadBasicBlocks() {
        TABLE.load();
    }

    private static void loadCraftingBlocks() {
        ARCANE_WORKBENCH.load();
    }

    private static void loadAuxBlocks() {
        DECONSTRUCTION_TABLE.load();
    }

    public static void register() {

        loadBasicBlocks();
        loadCraftingBlocks();
        loadAuxBlocks();

        Thaumcraft.LOGGER.info("Loading functional blocks");
    }


}
