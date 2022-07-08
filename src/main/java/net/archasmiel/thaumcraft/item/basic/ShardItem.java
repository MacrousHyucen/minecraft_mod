package net.archasmiel.thaumcraft.item.basic;

import net.archasmiel.thaumcraft.lib.generation.ItemDataGeneration;
import net.archasmiel.thaumcraft.register.Register;


public class ShardItem extends ThaumcraftItem {



    public ShardItem(Settings settings, String name) {
        super(settings, name);
        load();
    }
    public ShardItem(Settings settings, String name, int color) {
        super(settings, name, color);
        load();
    }


    @Override
    public void model() {
        ItemDataGeneration.simpleItemModel("generated", name(), "shard");
    }

    @Override
    public void register() {
        setItem(color() == 0x000000 ? Register.registerItem(name(), this) : Register.registerItem(name(), this, color()));
    }

}
