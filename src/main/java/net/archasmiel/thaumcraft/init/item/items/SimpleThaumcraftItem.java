package net.archasmiel.thaumcraft.init.item.items;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.ThaumcraftItem;
import net.minecraft.item.Item;
import static net.archasmiel.thaumcraft.lib.ItemDataGen.simpleItemModel;



public class SimpleThaumcraftItem extends ThaumcraftItem {



    public SimpleThaumcraftItem(Item item, String name) {
        super(item, name);
    }
    public SimpleThaumcraftItem(Item item, String name, int color) {
        super(item, name, color);
    }



    @Override
    public void model() {
        simpleItemModel("generated", this.name(), this.name());
    }

    @Override
    public void register() {
        if (this.color() == 0x000000)
            this.setItem(
                Register.registerItem(name(), item())
            );
        else
            this.setItem(
                Register.registerItem(name(), item(), color())
            );

        this.setRegistered(true);
    }

    @Override
    public void load() {
        this.model();
        this.register();
    }

}
