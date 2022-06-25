package net.archasmiel.thaumcraft.item.basic.items;

import net.archasmiel.thaumcraft.item.basic.ThaumcraftItem;
import net.archasmiel.thaumcraft.lib.generation.ItemDataGeneration;
import net.archasmiel.thaumcraft.register.Register;
import net.minecraft.item.Item;


public class ToolItem extends ThaumcraftItem {



    public ToolItem(Item item, String name) {
        super(item, name);
    }

    public ToolItem(Item item, String name, int color) {
        super(item, name, color);
    }



    @Override
    public void model() {
        ItemDataGeneration.simpleItemModel("handheld", name(), name());
    }

    @Override
    public void register() {

        if (color() == 0x000000)
            setItem(Register.registerItem(name(), item()));
        else
            setItem(Register.registerItem(name(), item(), color()));

        setRegistered(true);
    }

    @Override
    public void load() {
        model();
        register();
    }
}
