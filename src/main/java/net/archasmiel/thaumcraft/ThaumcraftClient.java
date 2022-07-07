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
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
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

        BlockEntityRendererRegistry.INSTANCE.register(BlockEntities.ARCANE_WORKBENCH, ArcaneWorkbenchBlockEntityRenderer::new);

//        ServerPlayNetworking.registerGlobalReceiver(SET_BLOCK_PACKET, (server, player, handler, buf, sender) -> {
//            BlockPos pos = buf.readBlockPos(); // reads must be done in the same order
//
//            ArrayList<ItemStack> input = new ArrayList<>();
//
//            for (int i = 0 ; i < 9 ; i++) {
//                input.add(buf.readItemStack());
//            }
//            ItemStack wand = buf.readItemStack();
//
//            Block blockToSet = Registry.BLOCK.get(buf.readIdentifier());
//            String mode = buf.readString();
//
//            server.execute(() -> { // We are now on the main thread
//                if (blockToSet instanceof ArcaneWorkbench) {
//                    if (mode.equals("change_inventory")){
//                        BlockEntity entity = player.getWorld().getBlockEntity(pos);
//                        if (entity instanceof ArcaneWorkbenchBlockEntity workbench) {
//                            System.out.println("ARCANE WORKBENCH CONTENT");
//
//                            BlockState aState = player.getWorld().getBlockState(pos);
//
//                            for (int i = 0 ; i < 9 ; i++) {
//                                workbench.setStack(i, input.get(i));
//                            }
//                            workbench.setStack(10, wand);
//                            workbench.markDirty();
//
//                            BlockState bState = player.getWorld().getBlockState(pos);
//                            player.getWorld().updateListeners(pos, aState, bState, Block.NOTIFY_ALL);
//                        }
//                    }
//                }
//            });
//        });
    }

}
