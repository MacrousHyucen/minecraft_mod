package net.archasmiel.thaumcraft.item.basic;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.generation.ThaumcraftRegistry;
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
        ThaumcraftRegistry.simpleItemModel(Thaumcraft.MOD_ID, "generated", name(), "shard");
    }

    @Override
    public void register() {
        setItem(color() == 0x000000 ? Register.registerItem(name(), this) : Register.registerItem(name(), this, color()));
    }

}
