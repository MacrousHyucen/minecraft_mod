package net.archasmiel.thaumcraft.item.basic;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.generation.ThaumcraftRegistry;
import net.archasmiel.thaumcraft.register.Register;



public class BasicItem extends ThaumcraftItem {



    public BasicItem(Settings settings, String name) {
        super(settings, name);
        load();
    }


    @Override
    public void model() {
        ThaumcraftRegistry.simpleItemModel(Thaumcraft.MOD_ID, "generated", name(), name());
    }

    @Override
    public void register() {
        setItem(Register.registerItem(name(), this));
    }

}
