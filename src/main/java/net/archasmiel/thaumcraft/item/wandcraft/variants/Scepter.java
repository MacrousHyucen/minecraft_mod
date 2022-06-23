package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.init.libs.CapMaterials;
import net.archasmiel.thaumcraft.init.libs.RodMaterials;
import net.archasmiel.thaumcraft.item.wandcraft.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.Weapon;

public class Scepter extends WandAbstract implements VisCraft, Weapon, FociWear {

    public Scepter(Settings settings, CapMaterials cap, RodMaterials rod) {
        super(settings, rod, cap, 0.10f, 1.5f, "scepter");
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
