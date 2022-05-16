package net.archasmiel.thaumcraft.lib.register;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.ItemDataGen;
import net.minecraft.item.Item;

public class Tool {

    public static Item register(String name, Item item) {
        ItemDataGen.simpleItemModel("handheld", name);
        return Register.registerItem(name, item);
    }

}
