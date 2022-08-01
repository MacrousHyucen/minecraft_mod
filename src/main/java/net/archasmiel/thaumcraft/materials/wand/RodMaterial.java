package net.archasmiel.thaumcraft.materials.wand;



public interface RodMaterial {

    String getRegistryName();
    String getMaterialName();
    int getCapacity();

    boolean isStick();
    boolean isPrimal();

}
