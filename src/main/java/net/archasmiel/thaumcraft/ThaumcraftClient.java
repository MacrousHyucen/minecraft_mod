package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.init.block.Functional;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class ThaumcraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        //ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new ThaumcraftModelProvider());

        BlockRenderLayerMap.INSTANCE.putBlock(Functional.ARCANE_WORKBENCH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Functional.DECONSTRUCTION_TABLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Functional.TABLE, RenderLayer.getCutout());

    }

}
