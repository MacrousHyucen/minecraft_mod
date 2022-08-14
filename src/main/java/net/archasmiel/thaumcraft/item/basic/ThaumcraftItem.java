package net.archasmiel.thaumcraft.item.basic;

import net.minecraft.item.Item;

public abstract class ThaumcraftItem extends Item {

    private final String name;
    private Item item;

    protected ThaumcraftItem(Settings settings, String name) {
        super(settings);
        this.name = name;
    }



    public void setItem(Item item) {
        this.item = item;
    }
    public Item item() {
        return item;
    }
    public String name() {
        return name;
    }


    public abstract void model();
    public abstract void register();
    public void load() {
        model();
        register();
    }
}
