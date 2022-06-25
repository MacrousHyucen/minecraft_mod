package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;
import net.archasmiel.thaumcraft.item.wandcraft.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.WandWeapon;

public class Staff extends WandAbstract implements VisCraft, WandWeapon, FociWear {

    public Staff(Settings settings, CapMaterials cap, RodMaterials rod) {
        super(settings, rod, cap, 0.00f, 2.50f, "staff");
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
