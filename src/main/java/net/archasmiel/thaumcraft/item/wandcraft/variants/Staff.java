package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.abilities.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.WandWeapon;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;

public class Staff extends WandAbstract implements WandWeapon, FociWear {

    public Staff(Settings settings, CapMaterials cap, RodMaterials rod) {
        super(settings, rod, cap, 0.00f, 2.50f, "staff");
    }



}
