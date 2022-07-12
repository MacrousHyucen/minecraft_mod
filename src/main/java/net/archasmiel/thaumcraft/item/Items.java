package net.archasmiel.thaumcraft.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.basic.BasicItem;
import net.archasmiel.thaumcraft.item.basic.ShardItem;
import net.archasmiel.thaumcraft.item.basic.ThaumcraftItem;
import net.archasmiel.thaumcraft.item.basic.ThaumonomiconItem;
import net.archasmiel.thaumcraft.item.tool.*;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Scepter;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Staff;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Wand;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;
import net.archasmiel.thaumcraft.materials.ToolMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;


public class Items {

    public static FabricItemSettings NOTAB_STANDARD_SETTINGS = new FabricItemSettings();
    public static FabricItemSettings NOTAB_ONE_ITEM_SETTINGS = new FabricItemSettings().maxCount(1);

    public static FabricItemSettings STANDARD_SETTINGS = new FabricItemSettings().group(Thaumcraft.MOD_GROUP_GENERAL);
    public static FabricItemSettings ONE_ITEM_SETTINGS = new FabricItemSettings().group(Thaumcraft.MOD_GROUP_GENERAL).maxCount(1);



    // books
    public static ThaumcraftItem THAUMONOMICON;
    public static ThaumcraftItem THAUMONOMICON_CHEAT;
    public static ThaumcraftItem CRIMSON_RITES;



    // caps
    public static ThaumcraftItem CAP_COPPER;
    public static ThaumcraftItem CAP_SILVER_INERT;
    public static ThaumcraftItem CAP_SILVER;
    public static ThaumcraftItem CAP_IRON;
    public static ThaumcraftItem CAP_GOLD;
    public static ThaumcraftItem CAP_THAUMIUM_INERT;
    public static ThaumcraftItem CAP_THAUMIUM;
    public static ThaumcraftItem CAP_VOID_INERT;
    public static ThaumcraftItem CAP_VOID;


    
    // rods
    public static ThaumcraftItem STAFF_ROD_BLAZE;
    public static ThaumcraftItem STAFF_ROD_BONE;
    public static ThaumcraftItem STAFF_ROD_GREATWOOD;
    public static ThaumcraftItem STAFF_ROD_ICE;
    public static ThaumcraftItem STAFF_ROD_OBSIDIAN;
    public static ThaumcraftItem STAFF_ROD_QUARTZ;
    public static ThaumcraftItem STAFF_ROD_REED;
    public static ThaumcraftItem STAFF_ROD_SILVERWOOD;
    public static ThaumcraftItem STAFF_ROD_PRIMAL;

    public static ThaumcraftItem WAND_ROD_BLAZE;
    public static ThaumcraftItem WAND_ROD_BONE;
    public static ThaumcraftItem WAND_ROD_GREATWOOD;
    public static ThaumcraftItem WAND_ROD_ICE;
    public static ThaumcraftItem WAND_ROD_OBSIDIAN;
    public static ThaumcraftItem WAND_ROD_QUARTZ;
    public static ThaumcraftItem WAND_ROD_REED;
    public static ThaumcraftItem WAND_ROD_SILVERWOOD;

    
    
    // materials
    public static ThaumcraftItem NITOR;
    public static ThaumcraftItem ALUMENTUM;
    public static ThaumcraftItem TALLOW;
    public static ThaumcraftItem FILTER;

    public static ThaumcraftItem PRIMAL_CHARM;
    public static ThaumcraftItem SALIS_MUNDUS;
    
    public static ThaumcraftItem CLOTH;
    public static ThaumcraftItem KNOWLEDGE_FRAGMENT;
    public static ThaumcraftItem MIRROR_GLASS;
    
    public static ThaumcraftItem TAINT_SLIME;
    public static ThaumcraftItem TAINT_TENDRIL;
    
    public static ThaumcraftItem AIR_SHARD;
    public static ThaumcraftItem FIRE_SHARD;
    public static ThaumcraftItem WATER_SHARD;
    public static ThaumcraftItem EARTH_SHARD;
    public static ThaumcraftItem ORDER_SHARD;
    public static ThaumcraftItem ENTROPY_SHARD;
    public static ThaumcraftItem BALANCED_SHARD;
    
    public static ThaumcraftItem AMBER;
    public static ThaumcraftItem VOID_SEED;
    public static ThaumcraftItem THAUMIUM_INGOT;
    public static ThaumcraftItem THAUMIUM_NUGGET;
    public static ThaumcraftItem VOID_METAL_INGOT;
    public static ThaumcraftItem VOID_METAL_NUGGET;
    public static ThaumcraftItem QUICKSILVER;
    public static ThaumcraftItem QUICKSILVER_DROP;

    
    
    // miscellaneous
    public static ThaumcraftItem INKWELL;
    public static ThaumcraftItem LABEL;
    public static ThaumcraftItem BOTTLE_TAINT;
    public static ThaumcraftItem COIN;



    // tools
    public static ThaumcraftSwordItem THAUMIUM_SWORD;
    public static ThaumcraftPickaxeItem THAUMIUM_PICKAXE;
    public static ThaumcraftAxeItem THAUMIUM_AXE;
    public static ThaumcraftShovelItem THAUMIUM_SHOVEL;
    public static ThaumcraftHoeItem THAUMIUM_HOE;

    public static ThaumcraftSwordItem VOIDMETAL_SWORD;
    public static ThaumcraftPickaxeItem VOIDMETAL_PICKAXE;
    public static ThaumcraftAxeItem VOIDMETAL_AXE;
    public static ThaumcraftShovelItem VOIDMETAL_SHOVEL;
    public static ThaumcraftHoeItem VOIDMETAL_HOE;








    public static void loadBooks() {
        THAUMONOMICON = new ThaumonomiconItem(ONE_ITEM_SETTINGS, "thaumonomicon");
        THAUMONOMICON_CHEAT = new BasicItem(ONE_ITEM_SETTINGS, "thaumonomicon_cheat");
        CRIMSON_RITES = new BasicItem(ONE_ITEM_SETTINGS, "crimson_rites");
    }

    public static void loadMaterials() {
        NITOR = new BasicItem(STANDARD_SETTINGS, "nitor");
        ALUMENTUM = new BasicItem(STANDARD_SETTINGS, "alumentum");
        TALLOW = new BasicItem(STANDARD_SETTINGS, "tallow");
        FILTER = new BasicItem(STANDARD_SETTINGS, "filter");


        PRIMAL_CHARM = new BasicItem(ONE_ITEM_SETTINGS, "primal_charm");
        SALIS_MUNDUS = new BasicItem(STANDARD_SETTINGS, "salis_mundus");


        CLOTH = new BasicItem(STANDARD_SETTINGS, "cloth");
        KNOWLEDGE_FRAGMENT = new BasicItem(STANDARD_SETTINGS, "knowledge_fragment");
        MIRROR_GLASS = new BasicItem(STANDARD_SETTINGS, "mirror_glass");


        TAINT_SLIME = new BasicItem(STANDARD_SETTINGS, "taint_slime");
        TAINT_TENDRIL = new BasicItem(STANDARD_SETTINGS, "taint_tendril");


        AIR_SHARD = new ShardItem(STANDARD_SETTINGS, "shard_air", 0xffff7e);
        FIRE_SHARD = new ShardItem(STANDARD_SETTINGS, "shard_fire", 0xff3c01);
        WATER_SHARD = new ShardItem(STANDARD_SETTINGS, "shard_water", 0x0090ff);
        EARTH_SHARD = new ShardItem(STANDARD_SETTINGS, "shard_earth", 0x00a000);
        ORDER_SHARD = new ShardItem(STANDARD_SETTINGS, "shard_order", 0xeeccff);
        ENTROPY_SHARD = new ShardItem(STANDARD_SETTINGS, "shard_entropy", 0x555577);
        BALANCED_SHARD = new BasicItem(STANDARD_SETTINGS, "shard_balanced");


        AMBER = new BasicItem(STANDARD_SETTINGS, "amber");
        VOID_SEED = new BasicItem(STANDARD_SETTINGS, "void_seed");

        THAUMIUM_INGOT = new BasicItem(STANDARD_SETTINGS, "ingot_thaumium");
        THAUMIUM_NUGGET = new BasicItem(STANDARD_SETTINGS, "nugget_thaumium");
        VOID_METAL_INGOT = new BasicItem(STANDARD_SETTINGS, "ingot_void_metal");
        VOID_METAL_NUGGET = new BasicItem(STANDARD_SETTINGS, "nugget_void_metal");
        QUICKSILVER = new BasicItem(STANDARD_SETTINGS, "ingot_quicksilver");
        QUICKSILVER_DROP = new BasicItem(STANDARD_SETTINGS, "nugget_quicksilver");
    }

    public static void loadMiscellaneous() {
        INKWELL = new BasicItem(ONE_ITEM_SETTINGS, "inkwell");
        LABEL = new BasicItem(STANDARD_SETTINGS, "label");
        BOTTLE_TAINT = new BasicItem(STANDARD_SETTINGS, "bottle_taint");
        COIN = new BasicItem(STANDARD_SETTINGS, "coin");
    }

    public static void loadCaps() {
        CAP_COPPER = new BasicItem(STANDARD_SETTINGS, "cap_copper");
        CAP_SILVER_INERT = new BasicItem(STANDARD_SETTINGS, "cap_silver_inert");
        CAP_SILVER = new BasicItem(STANDARD_SETTINGS, "cap_silver");
        CAP_IRON = new BasicItem(STANDARD_SETTINGS, "cap_iron");
        CAP_GOLD = new BasicItem(STANDARD_SETTINGS, "cap_gold");
        CAP_THAUMIUM_INERT = new BasicItem(STANDARD_SETTINGS, "cap_thaumium_inert");
        CAP_THAUMIUM = new BasicItem(STANDARD_SETTINGS, "cap_thaumium");
        CAP_VOID_INERT = new BasicItem(STANDARD_SETTINGS, "cap_void_inert");
        CAP_VOID = new BasicItem(STANDARD_SETTINGS, "cap_void");
    }

    public static void loadRods() {
        WAND_ROD_GREATWOOD = new BasicItem(STANDARD_SETTINGS, "wand_rod_greatwood");
        WAND_ROD_SILVERWOOD = new BasicItem(STANDARD_SETTINGS, "wand_rod_silverwood");
        WAND_ROD_REED = new BasicItem(STANDARD_SETTINGS, "wand_rod_reed");
        WAND_ROD_BLAZE = new BasicItem(STANDARD_SETTINGS, "wand_rod_blaze");
        WAND_ROD_ICE = new BasicItem(STANDARD_SETTINGS, "wand_rod_ice");
        WAND_ROD_OBSIDIAN = new BasicItem(STANDARD_SETTINGS, "wand_rod_obsidian");
        WAND_ROD_QUARTZ = new BasicItem(STANDARD_SETTINGS, "wand_rod_quartz");
        WAND_ROD_BONE = new BasicItem(STANDARD_SETTINGS, "wand_rod_bone");

        STAFF_ROD_GREATWOOD = new BasicItem(STANDARD_SETTINGS, "staff_rod_greatwood");
        STAFF_ROD_SILVERWOOD = new BasicItem(STANDARD_SETTINGS, "staff_rod_silverwood");
        STAFF_ROD_REED = new BasicItem(STANDARD_SETTINGS, "staff_rod_reed");
        STAFF_ROD_BLAZE = new BasicItem(STANDARD_SETTINGS, "staff_rod_blaze");
        STAFF_ROD_ICE = new BasicItem(STANDARD_SETTINGS, "staff_rod_ice");
        STAFF_ROD_OBSIDIAN = new BasicItem(STANDARD_SETTINGS, "staff_rod_obsidian");
        STAFF_ROD_QUARTZ = new BasicItem(STANDARD_SETTINGS, "staff_rod_quartz");
        STAFF_ROD_BONE = new BasicItem(STANDARD_SETTINGS, "staff_rod_bone");
        STAFF_ROD_PRIMAL = new BasicItem(STANDARD_SETTINGS, "staff_rod_primal");
    }

    public static void loadTools() {
        THAUMIUM_SWORD = new ThaumcraftSwordItem(ToolMaterials.THAUMIUMIUM, 3, -2.4F, ONE_ITEM_SETTINGS, "thaumium_sword");
        THAUMIUM_PICKAXE = new ThaumcraftPickaxeItem(ToolMaterials.THAUMIUMIUM, 1, -2.8F, ONE_ITEM_SETTINGS, "thaumium_pickaxe");
        THAUMIUM_AXE = new ThaumcraftAxeItem(ToolMaterials.THAUMIUMIUM, 5.0F, -3.0F, ONE_ITEM_SETTINGS, "thaumium_axe");
        THAUMIUM_SHOVEL = new ThaumcraftShovelItem(ToolMaterials.THAUMIUMIUM, 1.5F, -3.0F, ONE_ITEM_SETTINGS, "thaumium_shovel");
        THAUMIUM_HOE = new ThaumcraftHoeItem(ToolMaterials.THAUMIUMIUM, -3, 0.0F, ONE_ITEM_SETTINGS, "thaumium_hoe");

        VOIDMETAL_SWORD = new ThaumcraftSwordItem(ToolMaterials.VOID, 3, -2.4F, ONE_ITEM_SETTINGS, "voidmetal_sword");
        VOIDMETAL_PICKAXE = new ThaumcraftPickaxeItem(ToolMaterials.VOID, 1, -2.8F, ONE_ITEM_SETTINGS, "voidmetal_pickaxe");
        VOIDMETAL_AXE = new ThaumcraftAxeItem(ToolMaterials.VOID, 5.0F, -3.0F, ONE_ITEM_SETTINGS, "voidmetal_axe");
        VOIDMETAL_SHOVEL = new ThaumcraftShovelItem(ToolMaterials.VOID, 1.5F, -3.0F, ONE_ITEM_SETTINGS, "voidmetal_shovel");
        VOIDMETAL_HOE = new ThaumcraftHoeItem(ToolMaterials.VOID, -3, 0.0F, ONE_ITEM_SETTINGS, "voidmetal_hoe");
    }

    public static void loadFullWands() {

        // generates full capacity wands via appendStacksMethod
        // also registers wands in system
        for (RodMaterials rod: RodMaterials.values()){
            if (!rod.isPrimal())
            for (CapMaterials cap: CapMaterials.values()){
                new Wand(NOTAB_ONE_ITEM_SETTINGS, rod, cap);
            }
        }

        for (RodMaterials rod: RodMaterials.values()){
            if (!rod.isPrimal())
            for (CapMaterials cap: CapMaterials.values()){
                new Scepter(NOTAB_ONE_ITEM_SETTINGS, rod, cap);
            }
        }

        for (RodMaterials rod: RodMaterials.values()){
            // there is no wooden staff core
            if (!rod.isStick())
            for (CapMaterials cap: CapMaterials.values()){
                new Staff(NOTAB_ONE_ITEM_SETTINGS, rod, cap);
            }
        }
    }








    public static void register() {
        loadBooks();
        loadMaterials();
        loadMiscellaneous();

        loadCaps();
        loadRods();

        loadTools();
        loadFullWands();

        Thaumcraft.LOGGER.info("Loaded items");
    }
}
