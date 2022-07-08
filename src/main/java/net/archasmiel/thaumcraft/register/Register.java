package net.archasmiel.thaumcraft.register;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Register {

    // Registering item
    public static Item registerItem(String name, Item item) {
        return Registry.register(
                Registry.ITEM,
                new Identifier(Thaumcraft.MOD_ID, name),
                item
        );
    }

    public static Item registerItem(String name, Item item, int color) {
        Item result = Registry.register(
                Registry.ITEM,
                new Identifier(Thaumcraft.MOD_ID, name),
                item
        );
        registerItemColor(color, result);
        return result;
    }









    // Registering block
    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);

        return Registry.register(
                Registry.BLOCK,
                new Identifier(Thaumcraft.MOD_ID, name),
                block
        );
    }

    public static Block registerBlock(String name, Block block, int color) {
        registerBlockItem(name, block, color);
        Block result = Registry.register(
                Registry.BLOCK,
                new Identifier(Thaumcraft.MOD_ID, name),
                block
        );
        registerBlockColor(color, result);
        return result;
    }








    // Registering item related on block
    public static void registerBlockItem(String name, Block block) {
        Registry.register(
                Registry.ITEM,
                new Identifier(Thaumcraft.MOD_ID, "block/" + name),
                new BlockItem(block, new FabricItemSettings().group(Thaumcraft.MOD_GROUP_GENERAL))
        );
    }

    public static void registerBlockItem(String name, Block block, int color) {
        Item result = Registry.register(
                Registry.ITEM,
                new Identifier(Thaumcraft.MOD_ID, "block/" + name),
                new BlockItem(block, new FabricItemSettings().group(Thaumcraft.MOD_GROUP_GENERAL))
        );
        registerItemColor(color, result);
    }






    private static void registerItemColor(int color, Item item){
        ColorProviderRegistry.ITEM.register(
                (stack, tintIndex) -> color, item
        );
    }

    private static void registerBlockColor(int color, Block block){
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> color, block
        );
    }

}
