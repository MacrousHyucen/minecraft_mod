package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.lib.register.Material;
import net.minecraft.item.Item;

public class WandRods {

    public static final Item WAND_ROD_BLAZE = Material.register(
            "wand_rod_blaze",
            1
    );

    public static final Item WAND_ROD_BONE = Material.register(
            "wand_rod_bone",
            1
    );

    public static final Item WAND_ROD_GREATWOOD = Material.register(
            "wand_rod_greatwood",
            1
    );

    public static final Item WAND_ROD_ICE = Material.register(
            "wand_rod_ice",
            1
    );

    public static final Item WAND_ROD_OBSIDIAN = Material.register(
            "wand_rod_obsidian",
            1
    );

    public static final Item WAND_ROD_QUARTZ = Material.register(
            "wand_rod_quartz",
            1
    );

    public static final Item WAND_ROD_REED = Material.register(
            "wand_rod_reed",
            1
    );

    public static final Item WAND_ROD_SILVERWOOD = Material.register(
            "wand_rod_silverwood",
            1
    );




    public static void register() {
        Thaumcraft.LOGGER.info("Loading wand rods");
    }
}
