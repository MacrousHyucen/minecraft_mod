package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.register.Material;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Caps {

    public static final Item CAP_COPPER = Material.register(
            "cap_copper"
    );

    public static final Item CAP_GOLD = Material.register(
            "cap_gold"
    );

    public static final Item CAP_IRON = Material.register(
            "cap_iron"
    );

    public static final Item CAP_SILVER_INERT = Material.register(
            "cap_silver_inert"
    );

    public static final Item CAP_SILVER = Material.register(
            "cap_silver"
    );

    public static final Item CAP_THAUMIUM_INERT = Material.register(
            "cap_thaumium_inert"
    );

    public static final Item CAP_THAUMIUM = Material.register(
            "cap_thaumium"
    );

    public static final Item CAP_VOID_INERT = Material.register(
            "cap_void_inert"
    );

    public static final Item CAP_VOID = Material.register(
            "cap_void"
    );

    public static void register() {
        Thaumcraft.LOGGER.info("Loading caps");
    }

}
