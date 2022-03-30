package net.archasmiel.thaumcraft.init;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.groups.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Register {

    public static Item registerItem(String subgroup, String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Thaumcraft.MOD_ID, subgroup + name), item);
    }

    public static void register() {
        // Items
        Books.register();
        Miscellaneous.register();
        WandRods.register();
        StaffRods.register();
        Caps.register();
        Materials.register();

        // Blocks
    }

}
