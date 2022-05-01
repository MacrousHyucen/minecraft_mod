package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class Miscellaneous {



    public static final Item INKWELL = Register.registerItem(
            "inkwell",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item LABEL = Register.registerItem(
            "label",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item BOTTLE_TAINT = Register.registerItem(
            "bottle_taint",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item COIN = Register.registerItem(
            "coin",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static void register() {}

}
