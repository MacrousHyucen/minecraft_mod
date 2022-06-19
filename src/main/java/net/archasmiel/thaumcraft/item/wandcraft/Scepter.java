package net.archasmiel.thaumcraft.item.wandcraft;

import net.archasmiel.thaumcraft.init.libs.CapMaterials;
import net.archasmiel.thaumcraft.init.libs.RodMaterials;
import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Cap;
import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Rod;
import net.archasmiel.thaumcraft.item.wandcraft.variants.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.variants.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Weapon;

public class Scepter extends WandAbstract implements VisCraft, Weapon, FociWear {

    public Scepter(Settings settings, CapMaterials cap, RodMaterials rod) {
        super(settings, rod, cap, 0.10f, 1.5f);
    }



    @Override
    public boolean canVisCraft() {
        return true;
    }

    @Override
    public boolean canWearFoci() {
        return false;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }
}
