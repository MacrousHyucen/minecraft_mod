package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;
import net.archasmiel.thaumcraft.register.Register;

public class Scepter extends WandAbstract implements VisCraft{

    public Scepter(Settings settings, CapMaterials cap, RodMaterials rod) {
        super(
            settings,
            String.format("%s_%s_%s", "scepter", rod.getMaterialName(), cap.getMaterialName()),
            rod,
            cap,
            0.00f,
            2.50f,
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
