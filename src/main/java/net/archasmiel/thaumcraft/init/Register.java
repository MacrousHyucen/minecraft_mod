package net.archasmiel.thaumcraft.init;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.block.Functional;
import net.archasmiel.thaumcraft.init.item.*;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
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

    public static Item registerItem(String name, Item item, int color) {
        Item result = Registry.register(Registry.ITEM, new Identifier(Thaumcraft.MOD_ID, name), item);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> color, result);
        return result;
    }



    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Thaumcraft.MOD_ID, name), block);
    }

    public static Block registerBlock(String name, Block block, int color) {
        registerBlockItem(name, block, color);
        Block result = Registry.register(Registry.BLOCK, new Identifier(Thaumcraft.MOD_ID, name), block);
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> color, block);
        return result;
    }



    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier(Thaumcraft.MOD_ID, "block/"+name),
                new BlockItem(block, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)));
    }

    public static void registerBlockItem(String name, Block block, int color) {
        Item result = Registry.register(Registry.ITEM, new Identifier(Thaumcraft.MOD_ID, "block/"+name),
                new BlockItem(block, new FabricItemSettings().group(Thaumcraft.MOD_GROUP)));
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> color, result);
    }



    public static void register() {
        // Blocks
        Functional.register();

        // Items
        Books.register();
        Miscellaneous.register();
        Materials.register();
        Tools.register();

        WandRods.register();
        StaffRods.register();
        Caps.register();

        Test.register();

    }

}
