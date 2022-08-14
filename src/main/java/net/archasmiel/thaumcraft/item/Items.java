package net.archasmiel.thaumcraft.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.basic.BasicItem;
import net.archasmiel.thaumcraft.item.basic.ThaumonomiconItem;
import net.archasmiel.thaumcraft.item.tool.*;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Scepter;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Staff;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Wand;
import net.archasmiel.thaumcraft.materials.tools.ToolMaterials;
import net.archasmiel.thaumcraft.materials.wand.CapMaterials;
import net.archasmiel.thaumcraft.materials.wand.RodMaterials;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_GROUP_GENERATED;
import static net.archasmiel.thaumcraft.generation.WandcraftGeneration.*;
import static net.archasmiel.thaumcraft.materials.aspect.Aspect.primaryAspects;


public class Items {

    public static FabricItemSettings NOTAB_STANDARD_SETTINGS = new FabricItemSettings();
    public static FabricItemSettings NOTAB_ONE_ITEM_SETTINGS = new FabricItemSettings().maxCount(1);

    public static FabricItemSettings STANDARD_SETTINGS = new FabricItemSettings().group(Thaumcraft.MOD_GROUP_GENERAL);
    public static FabricItemSettings ONE_ITEM_SETTINGS = new FabricItemSettings().group(Thaumcraft.MOD_GROUP_GENERAL).maxCount(1);



    // books
    public static Item THAUMONOMICON;
    public static Item THAUMONOMICON_CHEAT;
    public static Item CRIMSON_RITES;



    // caps
    public static Item CAP_COPPER;
    public static Item CAP_SILVER_INERT;
    public static Item CAP_SILVER;
    public static Item CAP_IRON;
    public static Item CAP_GOLD;
    public static Item CAP_THAUMIUM_INERT;
    public static Item CAP_THAUMIUM;
    public static Item CAP_VOID_INERT;
    public static Item CAP_VOID;


    
    // rods
    public static Item STAFF_ROD_BLAZE;
    public static Item STAFF_ROD_BONE;
    public static Item STAFF_ROD_GREATWOOD;
    public static Item STAFF_ROD_ICE;
    public static Item STAFF_ROD_OBSIDIAN;
    public static Item STAFF_ROD_QUARTZ;
    public static Item STAFF_ROD_REED;
    public static Item STAFF_ROD_SILVERWOOD;
    public static Item STAFF_ROD_PRIMAL;

    public static Item WAND_ROD_BLAZE;
    public static Item WAND_ROD_BONE;
    public static Item WAND_ROD_GREATWOOD;
    public static Item WAND_ROD_ICE;
    public static Item WAND_ROD_OBSIDIAN;
    public static Item WAND_ROD_QUARTZ;
    public static Item WAND_ROD_REED;
    public static Item WAND_ROD_SILVERWOOD;

    
    
    // materials
    public static Item NITOR;
    public static Item ALUMENTUM;
    public static Item TALLOW;
    public static Item FILTER;

    public static Item PRIMAL_CHARM;
    public static Item SALIS_MUNDUS;
    
    public static Item CLOTH;
    public static Item KNOWLEDGE_FRAGMENT;
    public static Item MIRROR_GLASS;
    
    public static Item TAINT_SLIME;
    public static Item TAINT_TENDRIL;
    
    public static Item AIR_SHARD;
    public static Item FIRE_SHARD;
    public static Item WATER_SHARD;
    public static Item EARTH_SHARD;
    public static Item ORDER_SHARD;
    public static Item ENTROPY_SHARD;
    public static Item BALANCED_SHARD;
    
    public static Item AMBER;
    public static Item VOID_SEED;
    public static Item THAUMIUM_INGOT;
    public static Item THAUMIUM_NUGGET;
    public static Item VOID_METAL_INGOT;
    public static Item VOID_METAL_NUGGET;
    public static Item QUICKSILVER;
    public static Item QUICKSILVER_DROP;

    
    
    // miscellaneous
    public static Item INKWELL;
    public static Item LABEL;
    public static Item BOTTLE_TAINT;
    public static Item COIN;



    // tools
    public static Item THAUMIUM_SWORD;
    public static Item THAUMIUM_PICKAXE;
    public static Item THAUMIUM_AXE;
    public static Item THAUMIUM_SHOVEL;
    public static Item THAUMIUM_HOE;

    public static Item VOIDMETAL_SWORD;
    public static Item VOIDMETAL_PICKAXE;
    public static Item VOIDMETAL_AXE;
    public static Item VOIDMETAL_SHOVEL;
    public static Item VOIDMETAL_HOE;



    // wandcraft
    public static Map<String, Item> WANDS = new HashMap<>();
    public static Map<String, Item> SCEPTERS = new HashMap<>();
    public static Map<String, Item> STAFFS = new HashMap<>();




    private Items() {

    }

    public static void loadBooks() {
        THAUMONOMICON = new ThaumonomiconItem(ONE_ITEM_SETTINGS, "thaumonomicon").item();
        THAUMONOMICON_CHEAT = new BasicItem(ONE_ITEM_SETTINGS, "thaumonomicon_cheat").item();
        CRIMSON_RITES = new BasicItem(ONE_ITEM_SETTINGS, "crimson_rites").item();
    }

    public static void loadMaterials() {
        NITOR = new BasicItem(STANDARD_SETTINGS, "nitor").item();
        ALUMENTUM = new BasicItem(STANDARD_SETTINGS, "alumentum").item();
        TALLOW = new BasicItem(STANDARD_SETTINGS, "tallow").item();
        FILTER = new BasicItem(STANDARD_SETTINGS, "filter").item();


        PRIMAL_CHARM = new BasicItem(ONE_ITEM_SETTINGS, "primal_charm").item();
        SALIS_MUNDUS = new BasicItem(STANDARD_SETTINGS, "salis_mundus").item();


        CLOTH = new BasicItem(STANDARD_SETTINGS, "cloth").item();
        KNOWLEDGE_FRAGMENT = new BasicItem(STANDARD_SETTINGS, "knowledge_fragment").item();
        MIRROR_GLASS = new BasicItem(STANDARD_SETTINGS, "mirror_glass").item();


        TAINT_SLIME = new BasicItem(STANDARD_SETTINGS, "taint_slime").item();
        TAINT_TENDRIL = new BasicItem(STANDARD_SETTINGS, "taint_tendril").item();


        AIR_SHARD = new BasicItem(STANDARD_SETTINGS, "shard_air").item();
        FIRE_SHARD = new BasicItem(STANDARD_SETTINGS, "shard_fire").item();
        WATER_SHARD = new BasicItem(STANDARD_SETTINGS, "shard_water").item();
        EARTH_SHARD = new BasicItem(STANDARD_SETTINGS, "shard_earth").item();
        ORDER_SHARD = new BasicItem(STANDARD_SETTINGS, "shard_order").item();
        ENTROPY_SHARD = new BasicItem(STANDARD_SETTINGS, "shard_entropy").item();
        BALANCED_SHARD = new BasicItem(STANDARD_SETTINGS, "shard_balanced").item();


        AMBER = new BasicItem(STANDARD_SETTINGS, "amber").item();
        VOID_SEED = new BasicItem(STANDARD_SETTINGS, "void_seed").item();

        THAUMIUM_INGOT = new BasicItem(STANDARD_SETTINGS, "ingot_thaumium").item();
        THAUMIUM_NUGGET = new BasicItem(STANDARD_SETTINGS, "nugget_thaumium").item();
        VOID_METAL_INGOT = new BasicItem(STANDARD_SETTINGS, "ingot_void_metal").item();
        VOID_METAL_NUGGET = new BasicItem(STANDARD_SETTINGS, "nugget_void_metal").item();
        QUICKSILVER = new BasicItem(STANDARD_SETTINGS, "ingot_quicksilver").item();
        QUICKSILVER_DROP = new BasicItem(STANDARD_SETTINGS, "nugget_quicksilver").item();
    }

    public static void loadMiscellaneous() {
        INKWELL = new BasicItem(ONE_ITEM_SETTINGS, "inkwell").item();
        LABEL = new BasicItem(STANDARD_SETTINGS, "label").item();
        BOTTLE_TAINT = new BasicItem(STANDARD_SETTINGS, "bottle_taint").item();
        COIN = new BasicItem(STANDARD_SETTINGS, "coin").item();
    }

    public static void loadCaps() {
        CAP_COPPER = new BasicItem(STANDARD_SETTINGS, "cap_copper").item();
        CAP_SILVER_INERT = new BasicItem(STANDARD_SETTINGS, "cap_silver_inert").item();
        CAP_SILVER = new BasicItem(STANDARD_SETTINGS, "cap_silver").item();
        CAP_IRON = new BasicItem(STANDARD_SETTINGS, "cap_iron").item();
        CAP_GOLD = new BasicItem(STANDARD_SETTINGS, "cap_gold").item();
        CAP_THAUMIUM_INERT = new BasicItem(STANDARD_SETTINGS, "cap_thaumium_inert").item();
        CAP_THAUMIUM = new BasicItem(STANDARD_SETTINGS, "cap_thaumium").item();
        CAP_VOID_INERT = new BasicItem(STANDARD_SETTINGS, "cap_void_inert").item();
        CAP_VOID = new BasicItem(STANDARD_SETTINGS, "cap_void").item();
    }

    public static void loadRods() {
        WAND_ROD_GREATWOOD = new BasicItem(STANDARD_SETTINGS, "wand_rod_greatwood").item();
        WAND_ROD_SILVERWOOD = new BasicItem(STANDARD_SETTINGS, "wand_rod_silverwood").item();
        WAND_ROD_REED = new BasicItem(STANDARD_SETTINGS, "wand_rod_reed").item();
        WAND_ROD_BLAZE = new BasicItem(STANDARD_SETTINGS, "wand_rod_blaze").item();
        WAND_ROD_ICE = new BasicItem(STANDARD_SETTINGS, "wand_rod_ice").item();
        WAND_ROD_OBSIDIAN = new BasicItem(STANDARD_SETTINGS, "wand_rod_obsidian").item();
        WAND_ROD_QUARTZ = new BasicItem(STANDARD_SETTINGS, "wand_rod_quartz").item();
        WAND_ROD_BONE = new BasicItem(STANDARD_SETTINGS, "wand_rod_bone").item();

        STAFF_ROD_GREATWOOD = new BasicItem(STANDARD_SETTINGS, "staff_rod_greatwood").item();
        STAFF_ROD_SILVERWOOD = new BasicItem(STANDARD_SETTINGS, "staff_rod_silverwood").item();
        STAFF_ROD_REED = new BasicItem(STANDARD_SETTINGS, "staff_rod_reed").item();
        STAFF_ROD_BLAZE = new BasicItem(STANDARD_SETTINGS, "staff_rod_blaze").item();
        STAFF_ROD_ICE = new BasicItem(STANDARD_SETTINGS, "staff_rod_ice").item();
        STAFF_ROD_OBSIDIAN = new BasicItem(STANDARD_SETTINGS, "staff_rod_obsidian").item();
        STAFF_ROD_QUARTZ = new BasicItem(STANDARD_SETTINGS, "staff_rod_quartz").item();
        STAFF_ROD_BONE = new BasicItem(STANDARD_SETTINGS, "staff_rod_bone").item();
        STAFF_ROD_PRIMAL = new BasicItem(STANDARD_SETTINGS, "staff_rod_primal").item();
    }

    public static void loadTools() {
        THAUMIUM_SWORD = new ThaumcraftSwordItem(ToolMaterials.THAUMIUM, 3, -2.4F, ONE_ITEM_SETTINGS, "thaumium_sword").item();
        THAUMIUM_PICKAXE = new ThaumcraftPickaxeItem(ToolMaterials.THAUMIUM, 1, -2.8F, ONE_ITEM_SETTINGS, "thaumium_pickaxe").item();
        THAUMIUM_AXE = new ThaumcraftAxeItem(ToolMaterials.THAUMIUM, 5.0F, -3.0F, ONE_ITEM_SETTINGS, "thaumium_axe").item();
        THAUMIUM_SHOVEL = new ThaumcraftShovelItem(ToolMaterials.THAUMIUM, 1.5F, -3.0F, ONE_ITEM_SETTINGS, "thaumium_shovel").item();
        THAUMIUM_HOE = new ThaumcraftHoeItem(ToolMaterials.THAUMIUM, -3, 0.0F, ONE_ITEM_SETTINGS, "thaumium_hoe").item();

        VOIDMETAL_SWORD = new ThaumcraftSwordItem(ToolMaterials.VOID, 3, -2.4F, ONE_ITEM_SETTINGS, "voidmetal_sword").item();
        VOIDMETAL_PICKAXE = new ThaumcraftPickaxeItem(ToolMaterials.VOID, 1, -2.8F, ONE_ITEM_SETTINGS, "voidmetal_pickaxe").item();
        VOIDMETAL_AXE = new ThaumcraftAxeItem(ToolMaterials.VOID, 5.0F, -3.0F, ONE_ITEM_SETTINGS, "voidmetal_axe").item();
        VOIDMETAL_SHOVEL = new ThaumcraftShovelItem(ToolMaterials.VOID, 1.5F, -3.0F, ONE_ITEM_SETTINGS, "voidmetal_shovel").item();
        VOIDMETAL_HOE = new ThaumcraftHoeItem(ToolMaterials.VOID, -3, 0.0F, ONE_ITEM_SETTINGS, "voidmetal_hoe").item();
    }

    public static void loadWands() {

        // generates full capacity wandcraft items via appendStacksMethod in second tab
        // also registers wands in system
        // registered items put in Map

        // wands
        Arrays.stream(RodMaterials.values()).filter(rod -> !rod.isPrimal()).forEach(rod ->
            Arrays.stream(CapMaterials.values()).map(cap -> new Wand(NOTAB_ONE_ITEM_SETTINGS, rod, cap) {
                @Override
                public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
                    registerWandNbt(group, stacks, this);
                }
            }).forEach(wand -> {
                generateWandcraftData(wand);
                WANDS.put(wand.name(), wand.item());
            })
        );

        // scepters
        Arrays.stream(RodMaterials.values()).filter(rodMaterials -> !rodMaterials.isPrimal()).forEach(rodMaterials ->
            Arrays.stream(CapMaterials.values()).map(cap -> new Scepter(NOTAB_ONE_ITEM_SETTINGS, rodMaterials, cap) {
                @Override
                public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
                    registerWandNbt(group, stacks, this);
                }
            }).forEach(scepter -> {
                generateWandcraftData(scepter);
                SCEPTERS.put("thaumcraft:" + scepter.name(), scepter.item());
            })
        );

        // staffs
        Arrays.stream(RodMaterials.values()).filter(rod -> !rod.isStick()).forEach(rod ->
            Arrays.stream(CapMaterials.values()).map(cap -> new Staff(NOTAB_ONE_ITEM_SETTINGS, rod, cap) {
                @Override
                public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
                    registerWandNbt(group, stacks, this);
                }
            }).forEach(staff -> {
                generateWandcraftData(staff);
                STAFFS.put("thaumcraft:" + staff.name(), staff.item());
            })
        );
    }

    private static void registerWandNbt(ItemGroup group, DefaultedList<ItemStack> stacks, WandAbstract item) {
        if (group == MOD_GROUP_GENERATED) {
            ItemStack stack = new ItemStack(item, 1);
            NbtCompound nbt = stack.getNbt() != null ? stack.getNbt() : new NbtCompound();
            for (String i: primaryAspects) {
                nbt.putFloat(i, item.getCapacity());
            }
            stack.setNbt(nbt);
            stacks.add(stack);
        }
    }








    public static void register() {
        loadBooks();
        loadMaterials();
        loadMiscellaneous();

        loadCaps();
        loadRods();

        loadTools();
        loadWands();

        Thaumcraft.LOGGER.info("Loaded items");
    }
}
