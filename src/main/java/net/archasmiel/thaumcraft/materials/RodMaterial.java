package net.archasmiel.thaumcraft.materials;



public interface RodMaterial {

    String getRegistryName();
    String getMaterialName();
    int getCapacity();

    boolean isStick();
    boolean isPrimal();

}
