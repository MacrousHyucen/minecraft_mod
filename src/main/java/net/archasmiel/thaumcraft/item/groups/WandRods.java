package net.archasmiel.thaumcraft.item.groups;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static net.archasmiel.thaumcraft.init.Group.rods;

public class WandRods {

    public static final Item WAND_ROD_BLAZE = Register.registerItem(
            rods, "wand_rod_blaze",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item WAND_ROD_BONE = Register.registerItem(
            rods, "wand_rod_bone",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item WAND_ROD_GREATWOOD = Register.registerItem(
            rods, "wand_rod_greatwood",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item WAND_ROD_ICE = Register.registerItem(
            rods, "wand_rod_ice",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item WAND_ROD_OBSIDIAN = Register.registerItem(
            rods, "wand_rod_obsidian",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item WAND_ROD_QUARTZ = Register.registerItem(
            rods, "wand_rod_quartz",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item WAND_ROD_REED = Register.registerItem(
            rods, "wand_rod_reed",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item WAND_ROD_SILVERWOOD = Register.registerItem(
            rods, "wand_rod_silverwood",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );




    public static void register() {}
}
