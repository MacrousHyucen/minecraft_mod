package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;

public class Scepter extends WandAbstract implements VisCraft{

    public Scepter(Settings settings, CapMaterials cap, RodMaterials rod) {
        super(settings, rod, cap, 0.10f, 1.5f, "scepter");
    }


}
