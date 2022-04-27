package net.archasmiel.thaumcraft.init.block;

import net.archasmiel.thaumcraft.block.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.DeconstructionTable;
import net.archasmiel.thaumcraft.block.Table;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class Functional {

    public static final Block TABLE = Register.registerBlock(
            "table",
            new Table(
                    FabricBlockSettings
                            .copyOf(Blocks.CRAFTING_TABLE)
                            //of(Material.WOOD)
                            //.sounds(BlockSoundGroup.WOOD)
                            //.requiresTool()
                            //.strength(2.0f)
                            .nonOpaque()
            )
    );

    public static final Block ARCANE_WORKBENCH = Register.registerBlock(
            "arcane_workbench",
            new ArcaneWorkbench(
                    FabricBlockSettings
                    .copyOf(Blocks.CRAFTING_TABLE)
                    //of(Material.WOOD)
                    //.sounds(BlockSoundGroup.WOOD)
                    //.requiresTool()
                    //.strength(2.0f)
                    .nonOpaque()
            )
    );

    public static final Block DECONSTRUCTION_TABLE = Register.registerBlock(
            "deconstruction_table",
            new DeconstructionTable(
                    FabricBlockSettings
                    .copyOf(Blocks.CRAFTING_TABLE)
                    //of(Material.WOOD)
                    //.sounds(BlockSoundGroup.WOOD)
                    //.requiresTool()
                    //.strength(2.0f)
                    .nonOpaque()
            )
    );





    public static void register() {}

}
