package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.lib.register.Material;
import net.minecraft.item.Item;



public class Materials {

    // Alchemy materials
    public static final Item NITOR = Material.register(
            "nitor"
    );

    public static final Item ALUMENTUM = Material.register(
            "alumentum"
    );

    public static final Item TALLOW = Material.register(
            "tallow"
    );



    // Thaumaturgy materials
    public static final Item PRIMAL_CHARM = Material.register(
            "primal_charm", 1
    );

    public static final Item SALIS_MUNDUS = Material.register(
            "salis_mundus"
    );



    // Artifice materials
    public static final Item CLOTH = Material.register(
            "cloth"
    );

    public static final Item FILTER = Material.register(
            "filter"
    );

    public static final Item KNOWLEDGE_FRAGMENT = Material.register(
            "knowledge_fragment"
    );

    public static final Item MIRROR_GLASS = Material.register(
            "mirror_glass"
    );



    // Tainted
    public static final Item TAINT_SLIME = Material.register(
            "taint_slime"
    );

    public static final Item TAINT_TENDRIL = Material.register(
            "taint_tendril"
    );



    // Shards
    public static final Item AIR_SHARD = Material.register(
            "shard_air", 0xffff7e, 64
    );

    public static final Item FIRE_SHARD = Material.register(
            "shard_fire", 0xff3c01, 64
    );

    public static final Item WATER_SHARD = Material.register(
            "shard_water", 0x0090ff, 64
    );

    public static final Item EARTH_SHARD = Material.register(
            "shard_earth", 0x00a000, 64
    );

    public static final Item ORDER_SHARD = Material.register(
            "shard_order", 0xeeccff, 64
    );

    public static final Item ENTROPY_SHARD = Material.register(
            "shard_entropy", 0x555577, 64
    );

    public static final Item BALANCED_SHARD = Material.register(
            "shard_balanced"
    );


    // Bars and nuggets
    public static final Item AMBER = Material.register(
            "amber"
    );

    public static final Item THAUMIUM_INGOT = Material.register(
            "ingot_thaumium"
    );

    public static final Item VOID_METAL_INGOT = Material.register(
            "ingot_void_metal"
    );

    public static final Item QUICKSILVER = Material.register(
            "ingot_quicksilver"
    );

    public static final Item THAUMIUM_NUGGET = Material.register(
            "nugget_thaumium"
    );

    public static final Item VOID_SEED = Material.register(
            "void_seed"
    );

    public static final Item VOID_METAL_NUGGET = Material.register(
            "nugget_void_metal"
    );

    public static final Item QUICKSILVER_DROP = Material.register(
            "nugget_quicksilver"
    );



    public static void register() {
        Thaumcraft.LOGGER.info("Loading materials");
    }

}
