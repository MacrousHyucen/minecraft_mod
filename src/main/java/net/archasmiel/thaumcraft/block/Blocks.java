package net.archasmiel.thaumcraft.block;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.block.advanced.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.advanced.DeconstructionTable;
import net.archasmiel.thaumcraft.block.advanced.Table;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Blocks {


    private static final FabricBlockSettings WOODEN_BLOCK_SETTINGS = FabricBlockSettings.of(Material.WOOD).strength(2.5F).sounds(BlockSoundGroup.WOOD);

    public static Block TABLE;
    public static Block ARCANE_WORKBENCH;
    public static Block DECONSTRUCTION_TABLE;



    private static void loadBlocks() {
        TABLE = new Table(WOODEN_BLOCK_SETTINGS, "table").block();
        ARCANE_WORKBENCH = new ArcaneWorkbench(WOODEN_BLOCK_SETTINGS, "arcane_workbench").block();
        DECONSTRUCTION_TABLE = new DeconstructionTable(WOODEN_BLOCK_SETTINGS, "deconstruction_table").block();
    }

    public static void register() {
        loadBlocks();
        Thaumcraft.LOGGER.info("Loaded blocks");
    }


}
