package net.archasmiel.thaumcraft.item.basic;

import net.minecraft.item.Item;

public abstract class ThaumcraftItem extends Item {

    private final String name;
    private final int color;
    private Item item;

    public ThaumcraftItem(Settings settings, String name) {
        super(settings);
        this.name = name;
        this.color = 0x000000;
    }

    public ThaumcraftItem(Settings settings, String name, int color) {
        super(settings);
        this.name = name;
        this.color = color;
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
    public int color() {
        return color;
    }



    public abstract void model();
    public abstract void register();
    public void load() {
        model();
        register();
    }
}
