package net.archasmiel.thaumcraft.init.block;

import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class Functional {

    public static final Block ARCANE_WORKBENCH = Register.registerBlock(
            "arcane_workbench",
            new Block(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)
                    .strength(1.0f))
    );

    public static final Block DECONSTRUCTION_TABLE = Register.registerBlock(
            "deconstruction_table",
            new Block(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)
                    .strength(1.0f))
    );

    public static final Block TABLE = Register.registerBlock(
            "table",
            new Block(FabricBlockSettings.copyOf(Blocks.CRAFTING_TABLE)
                    .strength(1.0f))
    );



    public static void register() {}

}
