package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.lib.register.Material;
import net.minecraft.item.Item;

public class Books {

    public static final Item THAUMONOMICON = Material.register(
            "thaumonomicon", 1
    );

    public static final Item THAUMONOMICON_CHEAT = Material.register(
            "thaumonomicon_cheat", 1
    );

    public static final Item CRIMSON_RITES = Material.register(
            "crimson_rites", 1
    );



    public static void register() {
        Thaumcraft.LOGGER.info("Loading books");
    }


}
