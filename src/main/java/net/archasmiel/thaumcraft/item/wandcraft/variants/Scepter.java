package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.materials.wand.CapMaterials;
import net.archasmiel.thaumcraft.materials.wand.RodMaterials;
import net.archasmiel.thaumcraft.register.Register;

public class Scepter extends WandAbstract implements VisCraft{

    public Scepter(Settings settings, RodMaterials rod, CapMaterials cap) {
        super(
            settings,
            String.format("%s_%s_%s", "scepter", rod.getMaterialName(), cap.getMaterialName()),
            rod,
            cap,
            0.10f,
            1.50f,
            "scepter"
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
