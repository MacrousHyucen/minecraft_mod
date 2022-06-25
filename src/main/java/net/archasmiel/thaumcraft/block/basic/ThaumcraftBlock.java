package net.archasmiel.thaumcraft.block.basic;

import net.minecraft.block.Block;

public abstract class ThaumcraftBlock implements LoadableBlock {

    private boolean hasRegistered;
    private Block registeredBlock;

    private final Block block;
    private final String name;
    private final int color;







    public Block block() {
        return block;
    }
    public String name() {
        return name;
    }
    public int color() {
        return color;
    }

    public Block getBlock() {
        return registeredBlock;
    }
    public void setBlock(Block registeredBlock) {
        this.registeredBlock = registeredBlock;
    }
    public boolean getRegistered() {
        return hasRegistered;
    }
    public void setRegistered(boolean hasRegistered) {
        this.hasRegistered = hasRegistered;
    }









    public ThaumcraftBlock(Block block, String name){
        this.block = block;
        this.name = name;
        this.color = 0x000000;
    }

    public ThaumcraftBlock(Block block, String name, int color){
        this.block = block;
        this.name = name;
        this.color = color;
    }

}
