package net.archasmiel.thaumcraft.block;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.block.advanced.blocks.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.advanced.blocks.DeconstructionTable;
import net.archasmiel.thaumcraft.block.advanced.blocks.Table;
import net.archasmiel.thaumcraft.block.basic.ThaumcraftBlock;
import net.archasmiel.thaumcraft.block.basic.blocks.BasicRotatableBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Blocks {

    public static final ThaumcraftBlock TABLE = new BasicRotatableBlock(
            new Table(
                FabricBlockSettings
                .of(Material.WOOD)
                .strength(2.5F)
                .sounds(BlockSoundGroup.WOOD)
            ),
            "table"
    );

    public static final ThaumcraftBlock ARCANE_WORKBENCH = new BasicRotatableBlock(
            new ArcaneWorkbench(
                FabricBlockSettings
                .of(Material.WOOD)
                .strength(2.5F)
                .sounds(BlockSoundGroup.WOOD)
            ),
            "arcane_workbench"
    );

    public static final ThaumcraftBlock DECONSTRUCTION_TABLE = new BasicRotatableBlock(
            new DeconstructionTable(
                FabricBlockSettings
                .of(Material.WOOD)
                .strength(2.5F)
                .sounds(BlockSoundGroup.WOOD)
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
