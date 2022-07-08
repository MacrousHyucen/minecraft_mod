package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.block.Blocks;
import net.archasmiel.thaumcraft.blockentity.BlockEntities;
import net.archasmiel.thaumcraft.render.ArcaneWorkbenchBlockEntityRenderer;
import net.archasmiel.thaumcraft.screen.ScreenHandlers;
import net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class ThaumcraftClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.ARCANE_WORKBENCH.block(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.DECONSTRUCTION_TABLE.block(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Blocks.TABLE.block(), RenderLayer.getCutout());

        HandledScreens.register(ScreenHandlers.ARCANE_WORKBENCH_SCREEN_HANDLER, ArcaneWorkbenchScreen::new);

        BlockEntityRendererRegistry.register(BlockEntities.ARCANE_WORKBENCH, ArcaneWorkbenchBlockEntityRenderer::new);
    }

}
