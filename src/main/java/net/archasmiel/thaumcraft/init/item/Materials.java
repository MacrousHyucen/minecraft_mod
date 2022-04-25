package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.item.Shard;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Materials {

    public static final Item ALUMENTUM = Register.registerItem(
            "alumentum",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item NITOR = Register.registerItem(
            "nitor",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );



    public static final Item PRIMAL_CHARM = Register.registerItem(
            "primal_charm",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );


    public static final Item AIR_SHARD = Register.registerItem(
            "shard_air",
            new Shard(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item FIRE_SHARD = Register.registerItem(
            "shard_fire",
            new Shard(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item WATER_SHARD = Register.registerItem(
            "shard_water",
            new Shard(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item EARTH_SHARD = Register.registerItem(
            "shard_earth",
            new Shard(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item ORDER_SHARD = Register.registerItem(
            "shard_order",
            new Shard(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item ENTROPY_SHARD = Register.registerItem(
            "shard_entropy",
            new Shard(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item BALANCED_SHARD = Register.registerItem(
            "shard_balanced",
            new Shard(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );



    public static final Item AMBER = Register.registerItem(
            "amber",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item THAUMIUM_INGOT = Register.registerItem(
            "ingot_thaumium",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item VOID_METAL_INGOT = Register.registerItem(
            "ingot_void_metal",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item QUICKSILVER = Register.registerItem(
            "ingot_quicksilver",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item THAUMIUM_NUGGET = Register.registerItem(
            "nugget_thaumium",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item VOID_METAL_NUGGET = Register.registerItem(
            "nugget_void_metal",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item QUICKSILVER_DROP = Register.registerItem(
            "nugget_quicksilver",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );



    public static void register() {}

}
