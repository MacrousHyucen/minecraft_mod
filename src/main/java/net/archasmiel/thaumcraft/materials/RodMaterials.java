package net.archasmiel.thaumcraft.materials;



public enum RodMaterials implements RodMaterial {
    WOOD       ("rod_wood",       "wood",       25),
    GREATWOOD  ("rod_greatwood",  "greatwood",  50),
    SILVERWOOD ("rod_silverwood", "silverwood", 100),

    BLAZE      ("rod_blaze",      "blaze",      75),
    BONE       ("rod_bone",       "bone",       75),
    ICE        ("rod_ice",        "ice",        75),
    OBSIDIAN   ("rod_obsidian",   "obsidian",   75),
    QUARTZ     ("rod_quartz",     "quartz",     75),
    REED       ("rod_reed",       "reed",       75),

    PRIMAL     ("rod_primal",     "primal",     150);





    private final String registryName;
    private final String name;
    private final int visCapacity;

    RodMaterials(String registryName, String name, int visCapacity) {
        this.registryName = registryName;
        this.name = name;
        this.visCapacity = visCapacity;
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
    public int getCapacity() {
        return visCapacity;
    }

    @Override
    public boolean isStick() {
        return this == WOOD;
    }

    @Override
    public boolean isPrimal() {
        return this == PRIMAL;
    }


}
