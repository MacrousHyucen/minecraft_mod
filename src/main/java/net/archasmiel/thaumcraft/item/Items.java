package net.archasmiel.thaumcraft.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.basic.*;
import net.archasmiel.thaumcraft.item.basic.items.BasicItem;
import net.archasmiel.thaumcraft.item.basic.items.ShardItem;
import net.archasmiel.thaumcraft.item.basic.items.ToolItem;
import net.archasmiel.thaumcraft.item.basic.items.WandItem;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;
import net.archasmiel.thaumcraft.materials.ToolMaterials;
import net.archasmiel.thaumcraft.item.books.ThaumonomiconItem;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Wand;
import net.archasmiel.thaumcraft.tool.types.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;


public class Items {

    private static final FabricItemSettings STANDARD_SETTINGS = new FabricItemSettings().group(Thaumcraft.MOD_GROUP);
    private static final FabricItemSettings ONE_ITEM_SETTINGS = STANDARD_SETTINGS.maxCount(1);



    // books
    public static final ThaumcraftItem THAUMONOMICON = new BasicItem(
            new ThaumonomiconItem(ONE_ITEM_SETTINGS),
            "thaumonomicon"
    );

    public static final ThaumcraftItem THAUMONOMICON_CHEAT = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "thaumonomicon_cheat"
    );

    public static final ThaumcraftItem CRIMSON_RITES = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "crimson_rites"
    );





    // caps
    public static final ThaumcraftItem CAP_COPPER = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_copper"
    );
    public static final ThaumcraftItem CAP_SILVER_INERT = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_silver_inert"
    );
    public static final ThaumcraftItem CAP_SILVER = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_silver"
    );
    public static final ThaumcraftItem CAP_IRON = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_iron"
    );
    public static final ThaumcraftItem CAP_GOLD = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_gold"
    );
    public static final ThaumcraftItem CAP_THAUMIUM_INERT = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_thaumium_inert"
    );
    public static final ThaumcraftItem CAP_THAUMIUM = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_thaumium"
    );
    public static final ThaumcraftItem CAP_VOID_INERT = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_void_inert"
    );
    public static final ThaumcraftItem CAP_VOID = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cap_void"
    );




    

    // materials
    public static final ThaumcraftItem NITOR = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "nitor"
    );
    public static final ThaumcraftItem ALUMENTUM = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "alumentum"
    );
    public static final ThaumcraftItem TALLOW = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "tallow"
    );
    public static final ThaumcraftItem FILTER = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "filter"
    );


    public static final ThaumcraftItem PRIMAL_CHARM = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "primal_charm"
    );
    public static final ThaumcraftItem SALIS_MUNDUS = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "salis_mundus"
    );


    public static final ThaumcraftItem CLOTH = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "cloth"
    );
    public static final ThaumcraftItem KNOWLEDGE_FRAGMENT = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "knowledge_fragment"
    );
    public static final ThaumcraftItem MIRROR_GLASS = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "mirror_glass"
    );


    public static final ThaumcraftItem TAINT_SLIME = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "taint_slime"
    );
    public static final ThaumcraftItem TAINT_TENDRIL = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "taint_tendril"
    );


    public static final ThaumcraftItem AIR_SHARD = new ShardItem(
            new Item(STANDARD_SETTINGS),
            "shard_air", 0xffff7e
    );
    public static final ThaumcraftItem FIRE_SHARD = new ShardItem(
            new Item(STANDARD_SETTINGS),
            "shard_fire", 0xff3c01
    );
    public static final ThaumcraftItem WATER_SHARD = new ShardItem(
            new Item(STANDARD_SETTINGS),
            "shard_water", 0x0090ff
    );
    public static final ThaumcraftItem EARTH_SHARD = new ShardItem(
            new Item(STANDARD_SETTINGS),
            "shard_earth", 0x00a000
    );
    public static final ThaumcraftItem ORDER_SHARD = new ShardItem(
            new Item(STANDARD_SETTINGS),
            "shard_order", 0xeeccff
    );
    public static final ThaumcraftItem ENTROPY_SHARD = new ShardItem(
            new Item(STANDARD_SETTINGS),
            "shard_entropy", 0x555577
    );
    public static final ThaumcraftItem BALANCED_SHARD = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "shard_balanced"
    );


    public static final ThaumcraftItem AMBER = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "amber"
    );
    public static final ThaumcraftItem THAUMIUM_INGOT = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "ingot_thaumium"
    );
    public static final ThaumcraftItem VOID_METAL_INGOT = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "ingot_void_metal"
    );
    public static final ThaumcraftItem QUICKSILVER = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "ingot_quicksilver"
    );
    public static final ThaumcraftItem THAUMIUM_NUGGET = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "nugget_thaumium"
    );
    public static final ThaumcraftItem VOID_SEED = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "void_seed"
    );
    public static final ThaumcraftItem VOID_METAL_NUGGET = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "nugget_void_metal"
    );
    public static final ThaumcraftItem QUICKSILVER_DROP = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "nugget_quicksilver"
    );





    // miscellaneous
    public static final ThaumcraftItem INKWELL = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "inkwell"
    );
    public static final ThaumcraftItem LABEL = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "label"
    );
    public static final ThaumcraftItem BOTTLE_TAINT = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "bottle_taint"
    );
    public static final ThaumcraftItem COIN = new BasicItem(
            new Item(STANDARD_SETTINGS),
            "coin"
    );





    
    public static final ThaumcraftItem STAFF_ROD_BLAZE = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_blaze"
    );
    public static final ThaumcraftItem STAFF_ROD_BONE = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_bone"
    );
    public static final ThaumcraftItem STAFF_ROD_GREATWOOD = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_greatwood"
    );
    public static final ThaumcraftItem STAFF_ROD_ICE = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_ice"
    );
    public static final ThaumcraftItem STAFF_ROD_OBSIDIAN = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_obsidian"
    );
    public static final ThaumcraftItem STAFF_ROD_QUARTZ = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_quartz"
    );
    public static final ThaumcraftItem STAFF_ROD_REED = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_reed"
    );
    public static final ThaumcraftItem STAFF_ROD_SILVERWOOD = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_silverwood"
    );
    public static final ThaumcraftItem STAFF_ROD_PRIMAL = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "staff_rod_primal"
    );






    public static final ThaumcraftItem WAND_ROD_BLAZE = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "wand_rod_blaze"
    );
    public static final ThaumcraftItem WAND_ROD_BONE = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "wand_rod_bone"
    );
    public static final ThaumcraftItem WAND_ROD_GREATWOOD = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "wand_rod_greatwood"
    );
    public static final ThaumcraftItem WAND_ROD_ICE = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "wand_rod_ice"
    );
    public static final ThaumcraftItem WAND_ROD_OBSIDIAN = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "wand_rod_obsidian"
    );
    public static final ThaumcraftItem WAND_ROD_QUARTZ = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "wand_rod_quartz"
    );
    public static final ThaumcraftItem WAND_ROD_REED = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "wand_rod_reed"
    );
    public static final ThaumcraftItem WAND_ROD_SILVERWOOD = new BasicItem(
            new Item(ONE_ITEM_SETTINGS),
            "wand_rod_silverwood"
    );






    public static net.minecraft.item.ToolItem THAUMIUM_SWORD_TOOL = new ThaumcraftSword(
            ToolMaterials.THAUMIUMIUM, 3, -2.4F, STANDARD_SETTINGS
    );
    public static net.minecraft.item.ToolItem THAUMIUM_PICKAXE_TOOL = new ThaumcraftPickaxe(
            ToolMaterials.THAUMIUMIUM, 1, -2.8F, STANDARD_SETTINGS
    );
    public static net.minecraft.item.ToolItem THAUMIUM_AXE_TOOL = new ThaumcraftAxe(
            ToolMaterials.THAUMIUMIUM, 5.0F, -3.0F, STANDARD_SETTINGS
    );
    public static net.minecraft.item.ToolItem THAUMIUM_SHOVEL_TOOL = new ThaumcraftShovel(
            ToolMaterials.THAUMIUMIUM, 1.5F, -3.0F, STANDARD_SETTINGS
    );
    public static net.minecraft.item.ToolItem THAUMIUM_HOE_TOOL = new ThaumcraftHoe(
            ToolMaterials.THAUMIUMIUM, -3, 0.0F, STANDARD_SETTINGS
    );

    public static net.minecraft.item.ToolItem VOIDMETAL_SWORD_TOOL = new ThaumcraftSword(
            ToolMaterials.VOID, 3, -2.4F, STANDARD_SETTINGS
    );
    public static net.minecraft.item.ToolItem VOIDMETAL_PICKAXE_TOOL = new ThaumcraftPickaxe(
            ToolMaterials.VOID, 1, -2.8F, STANDARD_SETTINGS
    );
    public static net.minecraft.item.ToolItem VOIDMETAL_AXE_TOOL = new ThaumcraftAxe(
            ToolMaterials.VOID, 5.0F, -3.0F, STANDARD_SETTINGS
    );
    public static net.minecraft.item.ToolItem VOIDMETAL_SHOVEL_TOOL = new ThaumcraftShovel(
            ToolMaterials.VOID, 1.5F, -3.0F, STANDARD_SETTINGS
    );
    public static net.minecraft.item.ToolItem VOIDMETAL_HOE_TOOL = new ThaumcraftHoe(
            ToolMaterials.VOID, -3, 0.0F, STANDARD_SETTINGS
    );


    public static final ThaumcraftItem THAUMIUM_SWORD = new ToolItem(
            THAUMIUM_SWORD_TOOL, "thaumium_sword"
    );
    public static final ThaumcraftItem THAUMIUM_PICKAXE = new ToolItem(
            THAUMIUM_PICKAXE_TOOL, "thaumium_pickaxe"
    );
    public static final ThaumcraftItem THAUMIUM_AXE = new ToolItem(
            THAUMIUM_AXE_TOOL, "thaumium_axe"
    );
    public static final ThaumcraftItem THAUMIUM_SHOVEL = new ToolItem(
            THAUMIUM_SHOVEL_TOOL, "thaumium_shovel"
    );
    public static final ThaumcraftItem THAUMIUM_HOE = new ToolItem(
            THAUMIUM_HOE_TOOL, "thaumium_hoe"
    );

    public static final ThaumcraftItem VOIDMETAL_SWORD = new ToolItem(
            VOIDMETAL_SWORD_TOOL, "voidmetal_sword"
    );
    public static final ThaumcraftItem VOIDMETAL_PICKAXE = new ToolItem(
            VOIDMETAL_PICKAXE_TOOL, "voidmetal_pickaxe"
    );
    public static final ThaumcraftItem VOIDMETAL_AXE = new ToolItem(
            VOIDMETAL_AXE_TOOL, "voidmetal_axe"
    );
    public static final ThaumcraftItem VOIDMETAL_SHOVEL = new ToolItem(
            VOIDMETAL_SHOVEL_TOOL, "voidmetal_shovel"
    );
    public static final ThaumcraftItem VOIDMETAL_HOE = new ToolItem(
            VOIDMETAL_HOE_TOOL, "voidmetal_hoe"
    );






    public static final ThaumcraftItem WAND_ITEM1 = new WandItem(
            new Wand(ONE_ITEM_SETTINGS, RodMaterials.WOOD, CapMaterials.IRON, true)
    );

    public static final ThaumcraftItem WAND_ITEM2 = new WandItem(
            new Wand(ONE_ITEM_SETTINGS, RodMaterials.GREATWOOD, CapMaterials.GOLD, true)
    );

    public static final ThaumcraftItem WAND_ITEM3 = new WandItem(
            new Wand(ONE_ITEM_SETTINGS, RodMaterials.SILVERWOOD, CapMaterials.THAUMIUM, true)
    );

    public static final ThaumcraftItem WAND_ITEM4 = new WandItem(
            new Wand(ONE_ITEM_SETTINGS, RodMaterials.OBSIDIAN, CapMaterials.VOID, true)
    );



    public static void register() {
        loadBooks();
        loadMaterials();
        loadMiscellaneous();

        loadCaps();
        loadRods();

        loadTools();
        loadFullWands();
    }




    public static void loadBooks() {

        THAUMONOMICON.load();
        THAUMONOMICON_CHEAT.load();
        CRIMSON_RITES.load();

        Thaumcraft.LOGGER.info("Loaded books");
    }

    public static void loadMaterials() {

        NITOR.load();
        ALUMENTUM.load();
        TALLOW.load();
        FILTER.load();

        PRIMAL_CHARM.load();
        SALIS_MUNDUS.load();

        CLOTH.load();
        KNOWLEDGE_FRAGMENT.load();
        MIRROR_GLASS.load();

        TAINT_SLIME.load();
        TAINT_TENDRIL.load();

        AIR_SHARD.load();
        FIRE_SHARD.load();
        WATER_SHARD.load();
        EARTH_SHARD.load();
        ORDER_SHARD.load();
        ENTROPY_SHARD.load();
        BALANCED_SHARD.load();

        AMBER.load();
        THAUMIUM_INGOT.load();
        VOID_METAL_INGOT.load();
        QUICKSILVER.load();
        THAUMIUM_NUGGET.load();
        VOID_SEED.load();
        VOID_METAL_NUGGET.load();
        QUICKSILVER_DROP.load();

        Thaumcraft.LOGGER.info("Loaded materials");
    }

    public static void loadMiscellaneous() {

        INKWELL.load();
        LABEL.load();
        BOTTLE_TAINT.load();
        COIN.load();

        Thaumcraft.LOGGER.info("Loaded miscellaneous");
    }

    public static void loadCaps() {

        CAP_COPPER.load();
        CAP_SILVER_INERT.load();
        CAP_SILVER.load();
        CAP_IRON.load();
        CAP_GOLD.load();
        CAP_THAUMIUM_INERT.load();
        CAP_THAUMIUM.load();
        CAP_VOID_INERT.load();
        CAP_VOID.load();

        Thaumcraft.LOGGER.info("Loaded caps");
    }

    public static void loadRods() {

        STAFF_ROD_BLAZE.load();
        STAFF_ROD_BONE.load();
        STAFF_ROD_GREATWOOD.load();
        STAFF_ROD_ICE.load();
        STAFF_ROD_OBSIDIAN.load();
        STAFF_ROD_QUARTZ.load();
        STAFF_ROD_REED.load();
        STAFF_ROD_SILVERWOOD.load();
        STAFF_ROD_PRIMAL.load();

        WAND_ROD_BLAZE.load();
        WAND_ROD_BONE.load();
        WAND_ROD_GREATWOOD.load();
        WAND_ROD_ICE.load();
        WAND_ROD_OBSIDIAN.load();
        WAND_ROD_QUARTZ.load();
        WAND_ROD_REED.load();
        WAND_ROD_SILVERWOOD.load();

        Thaumcraft.LOGGER.info("Loaded rods");
    }

    public static void loadTools() {

        THAUMIUM_SWORD.load();
        THAUMIUM_PICKAXE.load();
        THAUMIUM_AXE.load();
        THAUMIUM_SHOVEL.load();
        THAUMIUM_HOE.load();

        VOIDMETAL_SWORD.load();
        VOIDMETAL_PICKAXE.load();
        VOIDMETAL_AXE.load();
        VOIDMETAL_SHOVEL.load();
        VOIDMETAL_HOE.load();

        Thaumcraft.LOGGER.info("Loaded tools");
    }

    public static void loadFullWands() {

        WAND_ITEM1.load();
        WAND_ITEM2.load();
        WAND_ITEM3.load();
        WAND_ITEM4.load();

        Thaumcraft.LOGGER.info("Loaded full wands");
    }






}
