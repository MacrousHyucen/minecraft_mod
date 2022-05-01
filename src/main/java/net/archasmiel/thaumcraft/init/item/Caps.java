package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Caps {

    public static final Item CAP_COPPER = Register.registerItem(
            "cap_copper",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_GOLD = Register.registerItem(
            "cap_gold",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_IRON = Register.registerItem(
            "cap_iron",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_SILVER_INERT = Register.registerItem(
            "cap_silver_inert",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_SILVER = Register.registerItem(
            "cap_silver",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_THAUMIUM_INERT = Register.registerItem(
            "cap_thaumium_inert",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_THAUMIUM = Register.registerItem(
            "cap_thaumium",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_VOID_INERT = Register.registerItem(
            "cap_void_inert",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_VOID = Register.registerItem(
            "cap_void",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static void register() {
        Thaumcraft.LOGGER.info("Loading caps");
    }

}
