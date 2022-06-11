package net.archasmiel.thaumcraft.init.block;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.block.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.DeconstructionTable;
import net.archasmiel.thaumcraft.block.Table;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.register.Rotatable;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;

public class Functional {

    public static final Block TABLE = Rotatable.register(
            "table",
            new Table(
                    FabricBlockSettings
                    .copyOf(Blocks.CRAFTING_TABLE)
                    .nonOpaque()
            )
    );

    public static final Block ARCANE_WORKBENCH = Rotatable.register(
            "arcane_workbench",
            new ArcaneWorkbench(
                    FabricBlockSettings
                    .copyOf(Blocks.CRAFTING_TABLE)
                    .nonOpaque()
            )
    );

    public static final Block DECONSTRUCTION_TABLE = Rotatable.register(
            "deconstruction_table",
            new DeconstructionTable(
                    FabricBlockSettings
                    .copyOf(Blocks.CRAFTING_TABLE)
                    .nonOpaque()
            )
    );


    public static final Block TESTBLOCK = Register.registerBlock(
            "testblock",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f))
    );





















    public static void register() {
        Thaumcraft.LOGGER.info("Loading functional blocks");
    }

}
