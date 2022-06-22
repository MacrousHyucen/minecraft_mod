package net.archasmiel.thaumcraft.init.libs;



public enum CapMaterials implements ThaumcraftCapMaterial {
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
