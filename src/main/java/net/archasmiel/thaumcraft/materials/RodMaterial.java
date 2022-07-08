package net.archasmiel.thaumcraft.materials;



public interface RodMaterial {

    String getRegistryName();
    String getMaterialName();
    int getVisCapacity();

    boolean canBeUsedByWand();
    boolean isStick();

}
