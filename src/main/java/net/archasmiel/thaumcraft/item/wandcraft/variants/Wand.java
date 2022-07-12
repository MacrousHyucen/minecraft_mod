package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;
import net.archasmiel.thaumcraft.register.Register;

public class Wand extends WandAbstract implements VisCraft, FociWear {

    public Wand(Settings settings, RodMaterials rod, CapMaterials cap) {
        super(
            settings,
            String.format("%s_%s_%s", "wand", rod.getMaterialName(), cap.getMaterialName()),
            rod,
            cap,
            0.00f,
            1.00f,
            "wand"
        );
        load();
    }




    @Override
    public void model() {
    }

    @Override
    public void register() {
        setItem(Register.registerItem(name(), this));
    }
}
