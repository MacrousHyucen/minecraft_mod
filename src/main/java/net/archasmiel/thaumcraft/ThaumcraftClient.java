package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.init.block.Functional;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ThaumcraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Functional.ARCANE_WORKBENCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Functional.DECONSTRUCTION_TABLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Functional.TABLE, RenderLayer.getCutout());

        // wit
        // ModModelPredicateProvider.registerModModels();
    }

}
