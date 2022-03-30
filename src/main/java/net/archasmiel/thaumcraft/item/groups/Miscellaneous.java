package net.archasmiel.thaumcraft.item.groups;


import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static net.archasmiel.thaumcraft.init.Group.miscellaneous;

public class Miscellaneous {

    public static final Item ALUMENTUM = Register.registerItem(
            miscellaneous, "alumentum",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item NITOR = Register.registerItem(
            miscellaneous, "nitor",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );



    public static void register() {}

}
