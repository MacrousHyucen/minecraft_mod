package net.archasmiel.thaumcraft.block.basic.blocks;

import net.archasmiel.thaumcraft.block.basic.ThaumcraftBlock;
import net.archasmiel.thaumcraft.lib.generation.BlockDataGeneration;
import net.archasmiel.thaumcraft.lib.generation.ItemDataGeneration;
import net.archasmiel.thaumcraft.register.Register;
import net.minecraft.block.Block;

public class BasicBlock extends ThaumcraftBlock {
    public BasicBlock(Block block, String name) {
        super(block, name);
    }

    public BasicBlock(Block block, String name, int color) {
        super(block, name, color);
    }




    @Override
    public void model() {
        ItemDataGeneration.simpleItemBlockModel(name());
        BlockDataGeneration.simpleBlockLootTable(name());
    }

    @Override
    public void register() {

        if (color() == 0x000000)
            setBlock(Register.registerBlock(name(), block()));
        else
            setBlock(Register.registerBlock(name(), block(), color()));

        setRegistered(true);
    }

    @Override
    public void load() {
        model();
        register();
    }
}
