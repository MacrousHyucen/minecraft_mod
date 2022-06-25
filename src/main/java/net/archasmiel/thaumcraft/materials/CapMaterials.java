package net.archasmiel.thaumcraft.materials;


/*
            Set 'visDiscount' always as:
            10% aspect margin     ->   -0.10f to 'discount' constructor/setter,
             5% aspect margin     ->   -0.05f ...,
             0%                   ->    0.00f ...,
            10% aspect discount   ->    0.10f ...,
            25% aspect discount   ->    0.25f ...;

            Getter will give same discount/margin in float you put into setter.

            Program will change discount/margin to [1 - multiplier] which means:
            -0.10f   ->   1.10 vis usage multiplier for cap,
            -0.05f   ->   1.05 ...,
             0.00f   ->   1.00 ...,
             0.10f   ->   0.90 ...,
             0.25f   ->   0.75 ...;
    */


public enum CapMaterials implements CapMaterial {
    IRON     ("cap_iron", "iron",     -0.10f),
    GOLD     ("cap_gold", "gold",      0.00f),
    THAUMIUM ("cap_thaumium", "thaumium",  0.10f),
    VOID     ("cap_void", "void",      0.20f),

    COPPER   ("cap_copper", "copper",   -0.15f),
    SILVER   ("cap_silver", "silver",    0.05f);





    private final String registryName;
    private final String name;
    private final float visDiscount;

    CapMaterials(String registryName, String name, float visDiscount) {
        this.registryName = registryName;
        this.name = name;
        this.visDiscount = visDiscount;
    }


    @Override
    public String getRegistryName() {
        return registryName;
    }

    @Override
    public String getMaterialName() {
        return name;
    }

    @Override
    public float getVisDiscount() {
        return visDiscount;
    }
}
