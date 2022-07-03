package net.archasmiel.thaumcraft.block;

import net.minecraft.block.Block;

public abstract class ThaumcraftBlock extends Block {

    private final String name;
    private Block block;

    public ThaumcraftBlock(Settings settings, String name){
        super(settings);
        this.name = name;
        load();
    }


    public void setBlock(Block block) {
        this.block = block;
    }
    public Block block() {
        return block;
    }
    public String name() {
        return name;
    }

    public abstract void model();
    public abstract void register();
    public void load() {
        model();
        register();
    }

}
