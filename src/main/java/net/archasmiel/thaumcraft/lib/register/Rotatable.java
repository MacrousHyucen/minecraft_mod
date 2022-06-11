package net.archasmiel.thaumcraft.lib.register;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.gen.BlockDataGen;
import net.archasmiel.thaumcraft.lib.gen.ItemDataGen;
import net.minecraft.block.Block;

public class Rotatable {

    // TODO
    // Delete in future commits
    public static Block register(String name, Block block) {
        ItemDataGen.simpleItemBlockModel(name);
        BlockDataGen.simpleBlockLootTable(name);
        BlockDataGen.simpleRotatableBlockState(name);
        return Register.registerBlock(name, block);
    }

}
