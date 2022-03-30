package net.archasmiel.thaumcraft.item.groups;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

import static net.archasmiel.thaumcraft.init.Group.materials;

public class Materials {

    public static final Item PRIMAL_CHARM = Register.registerItem(
            materials, "primal_charm",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );



    public static void register() {}

}
