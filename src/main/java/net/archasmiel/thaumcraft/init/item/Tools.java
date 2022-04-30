package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Tools {

    public static final Item THAUMIUM_SWORD = Register.registerItem(
            "thaumium_sword",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item THAUMIUM_PICKAXE = Register.registerItem(
            "thaumium_pickaxe",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item THAUMIUM_AXE = Register.registerItem(
            "thaumium_axe",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item THAUMIUM_SHOVEL = Register.registerItem(
            "thaumium_shovel",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static final Item THAUMIUM_HOE = Register.registerItem(
            "thaumium_hoe",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );

    public static void register() {}

}
