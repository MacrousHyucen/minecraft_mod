package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.abilities.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.WandWeapon;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;
import net.archasmiel.thaumcraft.register.Register;

public class Staff extends WandAbstract implements WandWeapon, FociWear {

    public Staff(Settings settings, RodMaterials rod, CapMaterials cap) {
        super(
            settings,
            String.format("%s_%s_%s", "staff", rod.getMaterialName(), cap.getMaterialName()),
            rod,
            cap,
            0.00f,
            2.50f,
            "staff"
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
