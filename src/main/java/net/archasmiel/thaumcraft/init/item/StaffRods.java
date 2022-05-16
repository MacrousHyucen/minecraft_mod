package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.register.Material;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class StaffRods {

    public static final Item STAFF_ROD_BLAZE = Material.register(
            "staff_rod_blaze",
            1
    );

    public static final Item STAFF_ROD_BONE = Material.register(
            "staff_rod_bone",
            1
    );

    public static final Item STAFF_ROD_GREATWOOD = Material.register(
            "staff_rod_greatwood",
            1
    );

    public static final Item STAFF_ROD_ICE = Material.register(
            "staff_rod_ice",
            1
    );

    public static final Item STAFF_ROD_OBSIDIAN = Material.register(
            "staff_rod_obsidian",
            1
    );

    public static final Item STAFF_ROD_QUARTZ = Material.register(
            "staff_rod_quartz",
            1
    );

    public static final Item STAFF_ROD_REED = Material.register(
            "staff_rod_reed",
            1
    );

    public static final Item STAFF_ROD_SILVERWOOD = Material.register(
            "staff_rod_silverwood",
            1
    );

    /* SPECIAL STAFF ROD */
    public static final Item STAFF_ROD_PRIMAL = Material.register(
            "staff_rod_primal",
            1
    );

    public static void register() {
        Thaumcraft.LOGGER.info("Loading staff rods");
    }

}
