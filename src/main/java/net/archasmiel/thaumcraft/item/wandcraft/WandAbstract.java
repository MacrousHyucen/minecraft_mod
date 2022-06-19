package net.archasmiel.thaumcraft.item.wandcraft;

import net.archasmiel.thaumcraft.init.libs.CapMaterials;
import net.archasmiel.thaumcraft.init.libs.RodMaterials;
import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Cap;
import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Rod;
import net.minecraft.item.Item;
import org.jetbrains.annotations.NotNull;

public abstract class WandAbstract extends Item {
    /*
            Set multiplier always as:
            10% aspect margin     ->   -0.10f to multiplier constructor/setter,
             5% aspect margin     ->   -0.05f ...,
             0%                   ->    0.00f ...,
            10% aspect discount   ->    0.10f ...,
            25% aspect discount   ->    0.25f ...;

            Getter will give same discount/margin in float you put into setter.

            Program changes discount/margin to [1 - multiplier] which means:
            -0.10f to constructor/setter   ->   1.10 multiplier for wand,
            -0.05f to constructor/setter   ->   1.05 ...,
             0.00f to constructor/setter   ->   1.00 ...,
             0.10f to constructor/setter   ->   0.90 ...,
             0.25f to constructor/setter   ->   0.75 ...;
    */



    private CapMaterials cap;
    private RodMaterials rod;

    private float discountMultiplier;
    private float capacityMultiplier;
    private float discount;
    private int capacity;



    public float getAerVis() {
        return aerVis;
    }
    public void setAerVis(float aerVis) {
        this.aerVis = aerVis;
    }

    public float getIgnisVis() {
        return ignisVis;
    }
    public void setIgnisVis(float ignisVis) {
        this.ignisVis = ignisVis;
    }

    public float getAquaVis() {
        return aquaVis;
    }
    public void setAquaVis(float aquaVis) {
        this.aquaVis = aquaVis;
    }

    public float getTerraVis() {
        return terraVis;
    }
    public void setTerraVis(float terraVis) {
        this.terraVis = terraVis;
    }

    public float getOrdoVis() {
        return ordoVis;
    }
    public void setOrdoVis(float ordoVis) {
        this.ordoVis = ordoVis;
    }

    public float getPerditioVis() {
        return perditioVis;
    }
    public void setPerditioVis(float perditioVis) {
        this.perditioVis = perditioVis;
    }

    private float aerVis;
    private float ignisVis;
    private float aquaVis;
    private float terraVis;
    private float ordoVis;
    private float perditioVis;



    public WandAbstract(Settings settings, RodMaterials rod, CapMaterials caps, float rawDiscountMultiplier, float capacityMultiplier) {
        super(settings);

        // basic info for capacity and discount
        this.setRod(rod);
        this.setCaps(caps);

        // info for capacity and info final values
        this.setCapacityMultiplier(capacityMultiplier);
        this.setDiscountMultiplier(1.00f - rawDiscountMultiplier);
    }



    public CapMaterials getCaps() {
        return cap;
    }

    public void setCaps(CapMaterials cap) {
        this.cap = cap;
    }

    public RodMaterials getRod() {
        return rod;
    }

    public void setRod(RodMaterials rod) {
        this.rod = rod;
    }

    public float getDiscountMultiplier() {
        return 1 - discountMultiplier;
    }

    public void setDiscountMultiplier(float discountMultiplier) {
        this.discountMultiplier = discountMultiplier;
        this.discount = 1.00f - this.cap.getVisDiscount() - this.discountMultiplier;
    }

    public float getCapacityMultiplier() {
        return capacityMultiplier;
    }

    public void setCapacityMultiplier(float capacityMultiplier) {
        this.capacityMultiplier = capacityMultiplier;
        this.capacity = (int) (this.rod.getVisCapacity() * this.capacityMultiplier);
    }

    public float getDiscount() {
        return discount;
    }

    public int getCapacity() {
        return capacity;
    }

}
