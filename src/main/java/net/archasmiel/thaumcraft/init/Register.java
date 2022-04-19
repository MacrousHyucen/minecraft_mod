package net.archasmiel.thaumcraft.init;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.block.Functional;
import net.archasmiel.thaumcraft.init.item.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Register {

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Thaumcraft.MOD_ID, name), item);
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Thaumcraft.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier(Thaumcraft.MOD_ID, "block/"+name),
                new BlockItem(block, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)));
    }

    public static void register() {
        // Items
        Books.register();
        Miscellaneous.register();
        WandRods.register();
        StaffRods.register();
        Caps.register();
        Materials.register();

        // Blocks
        Functional.register();
    }

}
