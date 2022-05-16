package net.archasmiel.thaumcraft.lib.register;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.BlockDataGen;
import net.archasmiel.thaumcraft.lib.ItemDataGen;
import net.minecraft.block.Block;

public class Rotatable {

    public static Block register(String name, Block block) {
        ItemDataGen.simpleItemBlockModel(name);
        BlockDataGen.simpleBlockLootTable(name);
        BlockDataGen.simpleRotatableBlockState(name);
        return Register.registerBlock(name, block);
    }

}
