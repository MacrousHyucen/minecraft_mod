package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.ThaumcraftMaterials;
import net.archasmiel.thaumcraft.init.tools.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ToolItem;
import net.minecraft.item.Item;

public class Tools {



    public static ToolItem THAUMIUM_SWORD_TOOL = new ThaumcraftSword(
            ThaumcraftMaterials.THAUMIUMIUM,
             3,
            -2.4F,
            new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );

    public static ToolItem THAUMIUM_PICKAXE_TOOL = new ThaumcraftPickaxe(
            ThaumcraftMaterials.THAUMIUMIUM,
             1,
            -2.8F,
            new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );

    public static ToolItem THAUMIUM_AXE_TOOL = new ThaumcraftAxe(
            ThaumcraftMaterials.THAUMIUMIUM,
             5.0F,
            -3.0F,
            new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );

    public static ToolItem THAUMIUM_SHOVEL_TOOL = new ThaumcraftShovel(
            ThaumcraftMaterials.THAUMIUMIUM,
             1.5F,
            -3.0F,
            new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );

    public static ToolItem THAUMIUM_HOE_TOOL = new ThaumcraftHoe(
            ThaumcraftMaterials.THAUMIUMIUM,
            -3,
             0.0F,
            new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );

    public static final Item THAUMIUM_SWORD = Register.registerItem(
            "thaumium_sword",
            THAUMIUM_SWORD_TOOL
    );

    public static final Item THAUMIUM_PICKAXE = Register.registerItem(
            "thaumium_pickaxe",
            THAUMIUM_PICKAXE_TOOL
    );

    public static final Item THAUMIUM_AXE = Register.registerItem(
            "thaumium_axe",
            THAUMIUM_AXE_TOOL
    );

    public static final Item THAUMIUM_SHOVEL = Register.registerItem(
            "thaumium_shovel",
            THAUMIUM_SHOVEL_TOOL
    );

    public static final Item THAUMIUM_HOE = Register.registerItem(
            "thaumium_hoe",
            THAUMIUM_HOE_TOOL
    );

    public static void register() {}

}
