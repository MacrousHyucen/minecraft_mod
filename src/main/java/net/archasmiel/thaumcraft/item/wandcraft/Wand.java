package net.archasmiel.thaumcraft.item.wandcraft;

import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Cap;
import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Rod;
import net.archasmiel.thaumcraft.item.wandcraft.variants.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.variants.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.variants.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Weapon;

public class Wand extends WandAbstract implements VisCraft, Weapon, FociWear {

    public Wand(Settings settings, Cap caps, Rod rod, String type) {
        super(settings, rod, caps, 0.00f, 1.00f);
    }



    @Override
    public boolean canWearFoci() {
        return true;
    }

    @Override
    public boolean canVisCraft() {
        return true;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }
}
