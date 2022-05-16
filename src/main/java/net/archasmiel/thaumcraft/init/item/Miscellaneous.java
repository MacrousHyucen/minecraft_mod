package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.register.Material;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Miscellaneous {



    public static final Item INKWELL = Material.register(
            "inkwell",
            1
    );

    public static final Item LABEL = Material.register(
            "label"
    );

    public static final Item BOTTLE_TAINT = Material.register(
            "bottle_taint"
    );

    public static final Item COIN = Material.register(
            "coin"
    );

    public static void register() {
        Thaumcraft.LOGGER.info("Loading misc");
    }

}
