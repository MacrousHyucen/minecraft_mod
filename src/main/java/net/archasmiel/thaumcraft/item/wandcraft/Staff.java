package net.archasmiel.thaumcraft.item.wandcraft;

import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Cap;
import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Rod;
import net.archasmiel.thaumcraft.item.wandcraft.variants.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.variants.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.variants.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Weapon;

public class Staff extends WandAbstract implements VisCraft, Weapon, FociWear {

    public Staff(Settings settings, Cap caps, Rod rod) {
        super(settings, rod, caps, 0.00f, 2.50f);
    }



    @Override
    public boolean isWeapon() {
        return true;
    }

    @Override
    public boolean canWearFoci() {
        return true;
    }

    @Override
    public boolean canVisCraft() {
        return false;
    }
}
