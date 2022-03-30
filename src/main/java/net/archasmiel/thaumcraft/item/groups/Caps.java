package net.archasmiel.thaumcraft.item.groups;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static net.archasmiel.thaumcraft.init.Group.caps;

public class Caps {

    public static final Item CAP_COPPER = Register.registerItem(
            caps, "cap_copper",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_GOLD = Register.registerItem(
            caps, "cap_gold",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_IRON = Register.registerItem(
            caps, "cap_iron",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_SILVER_INERT = Register.registerItem(
            caps, "cap_silver_inert",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_SILVER = Register.registerItem(
            caps, "cap_silver",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_THAUMIUM_INERT = Register.registerItem(
            caps, "cap_thaumium_inert",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_THAUMIUM = Register.registerItem(
            caps, "cap_thaumium",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_VOID_INERT = Register.registerItem(
            caps, "cap_void_inert",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item CAP_VOID = Register.registerItem(
            caps, "cap_void",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static void register() {}

}
