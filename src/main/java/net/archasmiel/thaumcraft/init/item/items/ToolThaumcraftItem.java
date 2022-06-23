package net.archasmiel.thaumcraft.init.item.items;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.ThaumcraftItem;
import net.minecraft.item.Item;

import static net.archasmiel.thaumcraft.lib.gen.ItemDataGen.simpleItemModel;


public class ToolThaumcraftItem extends ThaumcraftItem {



    public ToolThaumcraftItem(Item item, String name) {
        super(item, name);
    }

    public ToolThaumcraftItem(Item item, String name, int color) {
        super(item, name, color);
    }




    public void model() {
        simpleItemModel("handheld", name(), name());
    }

    public void register() {

        if (color() == 0x000000)
            setItem(Register.registerItem(name(), item()));
        else
            setItem(Register.registerItem(name(), item(), color()));

        setRegistered(true);
    }

    public void load() {
        model();
        register();
    }
}
