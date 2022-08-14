package net.archasmiel.thaumcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWithEntity;

public abstract class ThaumcraftBlockWithEntity extends BlockWithEntity {

    private final String name;
    private Block block;

    protected ThaumcraftBlockWithEntity(Settings settings, String name){
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
