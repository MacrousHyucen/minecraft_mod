package net.archasmiel.thaumcraft.init.block;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.block.ArcaneWorkbench;
import net.archasmiel.thaumcraft.block.DeconstructionTable;
import net.archasmiel.thaumcraft.block.Table;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.BlockDataGen;
import net.archasmiel.thaumcraft.lib.ItemDataGen;
import net.archasmiel.thaumcraft.lib.register.Rotatable;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
















    public static void register() {
        Thaumcraft.LOGGER.info("Loading functional blocks");
    }

}
