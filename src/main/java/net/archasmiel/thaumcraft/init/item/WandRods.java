package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class WandRods {

    public static final Item WAND_ROD_BLAZE = Register.registerItem(
            "wand_rod_blaze",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item WAND_ROD_BONE = Register.registerItem(
            "wand_rod_bone",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item WAND_ROD_GREATWOOD = Register.registerItem(
            "wand_rod_greatwood",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item WAND_ROD_ICE = Register.registerItem(
            "wand_rod_ice",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item WAND_ROD_OBSIDIAN = Register.registerItem(
            "wand_rod_obsidian",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item WAND_ROD_QUARTZ = Register.registerItem(
            "wand_rod_quartz",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item WAND_ROD_REED = Register.registerItem(
            "wand_rod_reed",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item WAND_ROD_SILVERWOOD = Register.registerItem(
            "wand_rod_silverwood",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );




    public static void register() {}
}
