package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.item.items.*;
import net.archasmiel.thaumcraft.init.libs.ThaumcraftMaterial;
import net.archasmiel.thaumcraft.init.tools.*;
import net.archasmiel.thaumcraft.item.Thaumonomicon;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;


public class ItemRegister {


    // books
    public static final ThaumcraftItem THAUMONOMICON = new BasicThaumcraftItem(
            new Thaumonomicon(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "thaumonomicon"
    );

    public static final ThaumcraftItem THAUMONOMICON_CHEAT = new BasicThaumcraftItem(
            new Thaumonomicon(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "thaumonomicon_cheat"
    );

    public static final ThaumcraftItem CRIMSON_RITES = new BasicThaumcraftItem(
            new Thaumonomicon(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "crimson_rites"
    );





    // caps
    public static final ThaumcraftItem CAP_COPPER = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_copper"
    );
    public static final ThaumcraftItem CAP_SILVER_INERT = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_silver_inert"
    );
    public static final ThaumcraftItem CAP_SILVER = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_silver"
    );
    public static final ThaumcraftItem CAP_IRON = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_iron"
    );
    public static final ThaumcraftItem CAP_GOLD = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_gold"
    );
    public static final ThaumcraftItem CAP_THAUMIUM_INERT = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_thaumium_inert"
    );
    public static final ThaumcraftItem CAP_THAUMIUM = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_thaumium"
    );
    public static final ThaumcraftItem CAP_VOID_INERT = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_void_inert"
    );
    public static final ThaumcraftItem CAP_VOID = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cap_void"
    );




    

    // materials
    public static final ThaumcraftItem NITOR = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "nitor"
    );
    public static final ThaumcraftItem ALUMENTUM = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "alumentum"
    );
    public static final ThaumcraftItem TALLOW = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "tallow"
    );
    public static final ThaumcraftItem FILTER = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "filter"
    );


    public static final ThaumcraftItem PRIMAL_CHARM = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "primal_charm"
    );
    public static final ThaumcraftItem SALIS_MUNDUS = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "salis_mundus"
    );


    public static final ThaumcraftItem CLOTH = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "cloth"
    );
    public static final ThaumcraftItem KNOWLEDGE_FRAGMENT = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "knowledge_fragment"
    );
    public static final ThaumcraftItem MIRROR_GLASS = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "mirror_glass"
    );


    public static final ThaumcraftItem TAINT_SLIME = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "taint_slime"
    );
    public static final ThaumcraftItem TAINT_TENDRIL = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "taint_tendril"
    );


    public static final ThaumcraftItem AIR_SHARD = new ShardThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "shard_air", 0xffff7e
    );
    public static final ThaumcraftItem FIRE_SHARD = new ShardThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "shard_fire", 0xff3c01
    );
    public static final ThaumcraftItem WATER_SHARD = new ShardThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "shard_water", 0x0090ff
    );
    public static final ThaumcraftItem EARTH_SHARD = new ShardThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "shard_earth", 0x00a000
    );
    public static final ThaumcraftItem ORDER_SHARD = new ShardThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "shard_order", 0xeeccff
    );
    public static final ThaumcraftItem ENTROPY_SHARD = new ShardThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "shard_entropy", 0x555577
    );
    public static final ThaumcraftItem BALANCED_SHARD = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "shard_balanced"
    );


    public static final ThaumcraftItem AMBER = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "amber"
    );
    public static final ThaumcraftItem THAUMIUM_INGOT = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "ingot_thaumium"
    );
    public static final ThaumcraftItem VOID_METAL_INGOT = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "ingot_void_metal"
    );
    public static final ThaumcraftItem QUICKSILVER = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "ingot_quicksilver"
    );
    public static final ThaumcraftItem THAUMIUM_NUGGET = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "nugget_thaumium"
    );
    public static final ThaumcraftItem VOID_SEED = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "void_seed"
    );
    public static final ThaumcraftItem VOID_METAL_NUGGET = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "nugget_void_metal"
    );
    public static final ThaumcraftItem QUICKSILVER_DROP = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "nugget_quicksilver"
    );





    // miscellaneous
    public static final ThaumcraftItem INKWELL = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "inkwell"
    );
    public static final ThaumcraftItem LABEL = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "label"
    );
    public static final ThaumcraftItem BOTTLE_TAINT = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "bottle_taint"
    );
    public static final ThaumcraftItem COIN = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP)),
            "coin"
    );





    
    public static final ThaumcraftItem STAFF_ROD_BLAZE = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_blaze"
    );
    public static final ThaumcraftItem STAFF_ROD_BONE = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_bone"
    );
    public static final ThaumcraftItem STAFF_ROD_GREATWOOD = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_greatwood"
    );
    public static final ThaumcraftItem STAFF_ROD_ICE = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_ice"
    );
    public static final ThaumcraftItem STAFF_ROD_OBSIDIAN = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_obsidian"
    );
    public static final ThaumcraftItem STAFF_ROD_QUARTZ = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_quartz"
    );
    public static final ThaumcraftItem STAFF_ROD_REED = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_reed"
    );
    public static final ThaumcraftItem STAFF_ROD_SILVERWOOD = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_silverwood"
    );
    public static final ThaumcraftItem STAFF_ROD_PRIMAL = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "staff_rod_primal"
    );






    public static final ThaumcraftItem WAND_ROD_BLAZE = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_blaze"
    );
    public static final ThaumcraftItem WAND_ROD_BONE = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_bone"
    );
    public static final ThaumcraftItem WAND_ROD_GREATWOOD = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_greatwood"
    );
    public static final ThaumcraftItem WAND_ROD_ICE = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_ice"
    );
    public static final ThaumcraftItem WAND_ROD_OBSIDIAN = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_obsidian"
    );
    public static final ThaumcraftItem WAND_ROD_QUARTZ = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_quartz"
    );
    public static final ThaumcraftItem WAND_ROD_REED = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_reed"
    );
    public static final ThaumcraftItem WAND_ROD_SILVERWOOD = new BasicThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_silverwood"
    );






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


    public static final ThaumcraftItem THAUMIUM_SWORD = new ToolThaumcraftItem(
            THAUMIUM_SWORD_TOOL, "thaumium_sword"
    );
    public static final ThaumcraftItem THAUMIUM_PICKAXE = new ToolThaumcraftItem(
            THAUMIUM_PICKAXE_TOOL, "thaumium_pickaxe"
    );
    public static final ThaumcraftItem THAUMIUM_AXE = new ToolThaumcraftItem(
            THAUMIUM_AXE_TOOL, "thaumium_axe"
    );
    public static final ThaumcraftItem THAUMIUM_SHOVEL = new ToolThaumcraftItem(
            THAUMIUM_SHOVEL_TOOL, "thaumium_shovel"
    );
    public static final ThaumcraftItem THAUMIUM_HOE = new ToolThaumcraftItem(
            THAUMIUM_HOE_TOOL, "thaumium_hoe"
    );

    public static final ThaumcraftItem VOIDMETAL_SWORD = new ToolThaumcraftItem(
            VOIDMETAL_SWORD_TOOL, "voidmetal_sword"
    );
    public static final ThaumcraftItem VOIDMETAL_PICKAXE = new ToolThaumcraftItem(
            VOIDMETAL_PICKAXE_TOOL, "voidmetal_pickaxe"
    );
    public static final ThaumcraftItem VOIDMETAL_AXE = new ToolThaumcraftItem(
            VOIDMETAL_AXE_TOOL, "voidmetal_axe"
    );
    public static final ThaumcraftItem VOIDMETAL_SHOVEL = new ToolThaumcraftItem(
            VOIDMETAL_SHOVEL_TOOL, "voidmetal_shovel"
    );
    public static final ThaumcraftItem VOIDMETAL_HOE = new ToolThaumcraftItem(
            VOIDMETAL_HOE_TOOL, "voidmetal_hoe"
    );






    public static final ThaumcraftItem WAND_ITEM1 = new WandThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_wood", "wand_cap_iron", "wand"
    );

    public static final ThaumcraftItem WAND_ITEM2 = new WandThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_greatwood", "wand_cap_gold", "wand"
    );

    public static final ThaumcraftItem WAND_ITEM3 = new WandThaumcraftItem(
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1)),
            "wand_rod_silverwood", "wand_cap_thaumium", "wand"
    );



    public static void register() {
        loadBooks();
        loadMaterials();
        loadMiscellaneous();

        loadTools();
        loadFullWands();

        loadCaps();
        loadRods();
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

        Thaumcraft.LOGGER.info("Loaded full wands");
    }






}
