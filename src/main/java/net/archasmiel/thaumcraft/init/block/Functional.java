package net.archasmiel.thaumcraft.init.block;

import net.archasmiel.thaumcraft.block.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.DeconstructionTable;
import net.archasmiel.thaumcraft.block.Table;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Functional {

    public static final Block ARCANE_WORKBENCH = Register.registerBlock(
            "arcane_workbench",
            new ArcaneWorkbench(
                    FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(2.0f).requiresTool().nonOpaque()
            )
    );

    public static final Block DECONSTRUCTION_TABLE = Register.registerBlock(
            "deconstruction_table",
            new DeconstructionTable(
                    FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(2.0f).requiresTool().nonOpaque()
            )
    );

    public static final Block TABLE = Register.registerBlock(
            "table",
            new Table(
                    FabricBlockSettings.copy(Blocks.OAK_PLANKS).strength(2.0f).requiresTool().nonOpaque()
            )
    );



    public static void register() {}

}
