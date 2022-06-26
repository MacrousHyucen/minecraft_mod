package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.abilities.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;

public class Wand extends WandAbstract implements VisCraft, FociWear {

    public Wand(Settings settings, RodMaterials rod, CapMaterials cap, boolean fullAspects) {
        super(settings, rod, cap, 0.00f, 1.00f, "wand", fullAspects);
    }


}
