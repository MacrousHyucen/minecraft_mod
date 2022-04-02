package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class StaffRods {

    public static final Item STAFF_ROD_BLAZE = Register.registerItem(
            "staff_rod_blaze",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item STAFF_ROD_BONE = Register.registerItem(
            "staff_rod_bone",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item STAFF_ROD_GREATWOOD = Register.registerItem(
            "staff_rod_greatwood",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item STAFF_ROD_ICE = Register.registerItem(
            "staff_rod_ice",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item STAFF_ROD_OBSIDIAN = Register.registerItem(
            "staff_rod_obsidian",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item STAFF_ROD_QUARTZ = Register.registerItem(
            "staff_rod_quartz",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item STAFF_ROD_REED = Register.registerItem(
            "staff_rod_reed",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item STAFF_ROD_SILVERWOOD = Register.registerItem(
            "staff_rod_silverwood",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    /* SPECIAL STAFF ROD */
    public static final Item STAFF_ROD_PRIMAL = Register.registerItem(
            "staff_rod_primal",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static void register() {}

}
