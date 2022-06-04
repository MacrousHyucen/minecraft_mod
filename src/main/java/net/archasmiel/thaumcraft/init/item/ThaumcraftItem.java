package net.archasmiel.thaumcraft.init.item;

import net.minecraft.item.Item;

public abstract class ThaumcraftItem implements Loadable {

    private boolean hasRegistered;
    private Item registeredItem;

    private final Item item;
    private final String name;
    private final int color;



    public boolean getRegistered() {
        return hasRegistered;
    }
    public void setRegistered(boolean hasRegistered) {
        this.hasRegistered = hasRegistered;
    }

    public Item getItem() {
        return registeredItem;
    }
    public void setItem(Item registeredItem) {
        this.registeredItem = registeredItem;
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









    public ThaumcraftItem(Item item, String name){
        this.item = item;
        this.name = name;
        this.color = 0x000000;
    }

    public ThaumcraftItem(Item item, String name, int color){
        this.item = item;
        this.name = name;
        this.color = color;
    }

}
