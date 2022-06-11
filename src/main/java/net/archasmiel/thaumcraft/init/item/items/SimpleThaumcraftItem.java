package net.archasmiel.thaumcraft.init.item.items;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.ThaumcraftItem;
import net.minecraft.item.Item;
import static net.archasmiel.thaumcraft.lib.gen.ItemDataGen.simpleItemModel;



public class SimpleThaumcraftItem extends ThaumcraftItem {



    public SimpleThaumcraftItem(Item item, String name) {
        super(item, name);
    }
    public SimpleThaumcraftItem(Item item, String name, int color) {
        super(item, name, color);
    }



    @Override
    public void model() {
        simpleItemModel("generated", name(), name());
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
