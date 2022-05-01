package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.ThaumcraftMaterial;
import net.archasmiel.thaumcraft.init.tools.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ToolItem;
import net.minecraft.item.Item;

public class Tools {


    // Registering tools stats
    public static ToolItem THAUMIUM_SWORD_TOOL = new ThaumcraftSword(
            ThaumcraftMaterial.THAUMIUMIUM, 3, -2.4F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );
    public static ToolItem THAUMIUM_PICKAXE_TOOL = new ThaumcraftPickaxe(
            ThaumcraftMaterial.THAUMIUMIUM, 1, -2.8F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );
    public static ToolItem THAUMIUM_AXE_TOOL = new ThaumcraftAxe(
            ThaumcraftMaterial.THAUMIUMIUM, 5.0F, -3.0F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );
    public static ToolItem THAUMIUM_SHOVEL_TOOL = new ThaumcraftShovel(
            ThaumcraftMaterial.THAUMIUMIUM, 1.5F, -3.0F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );
    public static ToolItem THAUMIUM_HOE_TOOL = new ThaumcraftHoe(
            ThaumcraftMaterial.THAUMIUMIUM, -3, 0.0F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );

    public static ToolItem VOIDMETAL_SWORD_TOOL = new ThaumcraftSword(
            ThaumcraftMaterial.VOID, 3, -2.4F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );
    public static ToolItem VOIDMETAL_PICKAXE_TOOL = new ThaumcraftPickaxe(
            ThaumcraftMaterial.VOID, 1, -2.8F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );
    public static ToolItem VOIDMETAL_AXE_TOOL = new ThaumcraftAxe(
            ThaumcraftMaterial.VOID, 5.0F, -3.0F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );
    public static ToolItem VOIDMETAL_SHOVEL_TOOL = new ThaumcraftShovel(
            ThaumcraftMaterial.VOID, 1.5F, -3.0F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );
    public static ToolItem VOIDMETAL_HOE_TOOL = new ThaumcraftHoe(
            ThaumcraftMaterial.VOID, -3, 0.0F, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)
    );



    // Creating actual items
    public static final Item THAUMIUM_SWORD = Register.registerItem(
            "thaumium_sword", THAUMIUM_SWORD_TOOL
    );
    public static final Item THAUMIUM_PICKAXE = Register.registerItem(
            "thaumium_pickaxe", THAUMIUM_PICKAXE_TOOL
    );
    public static final Item THAUMIUM_AXE = Register.registerItem(
            "thaumium_axe", THAUMIUM_AXE_TOOL
    );
    public static final Item THAUMIUM_SHOVEL = Register.registerItem(
            "thaumium_shovel", THAUMIUM_SHOVEL_TOOL
    );
    public static final Item THAUMIUM_HOE = Register.registerItem(
            "thaumium_hoe", THAUMIUM_HOE_TOOL
    );

    public static final Item VOIDMETAL_SWORD = Register.registerItem(
            "voidmetal_sword", VOIDMETAL_SWORD_TOOL
    );
    public static final Item VOIDMETAL_PICKAXE = Register.registerItem(
            "voidmetal_pickaxe", VOIDMETAL_PICKAXE_TOOL
    );
    public static final Item VOIDMETAL_AXE = Register.registerItem(
            "voidmetal_axe", VOIDMETAL_AXE_TOOL
    );
    public static final Item VOIDMETAL_SHOVEL = Register.registerItem(
            "voidmetal_shovel", VOIDMETAL_SHOVEL_TOOL
    );
    public static final Item VOIDMETAL_HOE = Register.registerItem(
            "voidmetal_hoe", VOIDMETAL_HOE_TOOL
    );

    public static void register() {
        Thaumcraft.LOGGER.info("Loading tools");
    }

}
