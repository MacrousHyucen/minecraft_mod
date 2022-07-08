package net.archasmiel.thaumcraft.render;

import net.archasmiel.thaumcraft.blockentity.ArcaneWorkbenchBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class ArcaneWorkbenchBlockEntityRenderer implements BlockEntityRenderer<ArcaneWorkbenchBlockEntity> {

    public ArcaneWorkbenchBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(ArcaneWorkbenchBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        renderWand(entity, tickDelta, matrices, vertexConsumers, light, overlay);
        renderCraftingInventory(entity, tickDelta, matrices, vertexConsumers, light, overlay);
    }

    private void renderWand(ArcaneWorkbenchBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(0.8, 1.05, 0.2);
        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90));
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(45));
        MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(10), ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 0);
        matrices.pop();
    }

    private void renderCraftingInventory(ArcaneWorkbenchBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        for (int i = 0 ; i < 9 ; i++) {
            ItemStack item = entity.getStack(i);
            if (item.getCount() > 0){

                // presets for rendering
                float maxHeight = 8.0f;
                if (item.getMaxCount() == 1) maxHeight = 0;
                else if (item.getMaxCount() <= 16)  maxHeight *= 0.5f;

                float percentItem = item.getCount() * maxHeight / item.getMaxCount();

                ModelTransformation.Mode mode;
                float delta;
                float sizeXZmul, sizeYmul;
                float coordXZmul, coordYmul;
                float coordY;

                boolean isBlock = item.getName().toString().contains("block");
                boolean fromThaumcraft = item.getName().toString().contains("thaumcraft");

                if (isBlock){
                    mode = ModelTransformation.Mode.GROUND;
                    sizeXZmul = fromThaumcraft ? 0.3f : 0.35f;
                    coordXZmul = 1/sizeXZmul;
                    sizeYmul = sizeXZmul;
                    coordYmul = coordXZmul;
                    coordY = fromThaumcraft ? 1.06f : 1.05f;
                    delta = fromThaumcraft ? 0 : 0.075f;
                } else {
                    mode = ModelTransformation.Mode.GUI;
                    sizeXZmul = 0.15f;
                    coordXZmul = 1/sizeXZmul;
                    sizeYmul = sizeXZmul * (percentItem + 1f);
                    coordYmul = 1/sizeYmul;
                    coordY = 1.01f + 0.00458715f*percentItem;
                    delta = 0;
                }

                matrices.push();
                matrices.scale(sizeXZmul, sizeYmul, sizeXZmul);
                Pair<Float, Float> coords = getCoords(i, delta);
                matrices.translate(coordXZmul*coords.getLeft(), coordY*coordYmul, coordXZmul*coords.getRight());
                matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90));
                int lightAbove = WorldRenderer.getLightmapCoordinates(entity.getWorld(), entity.getPos().up());
                MinecraftClient.getInstance().getItemRenderer().renderItem(item, mode, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
                matrices.pop();

            }
        }
    }

    private Pair<Float, Float> getCoords(int slotnum, float delta) {
        float flo1 = 5.0f/16, flo2 = 8.0f/16, flo3 = 11.0f/16;
        return switch (slotnum) {
            case 0 -> new Pair<>(flo1, flo1+delta);
            case 1 -> new Pair<>(flo2, flo1+delta);
            case 2 -> new Pair<>(flo3, flo1+delta);
            case 3 -> new Pair<>(flo1, flo2+delta);
            case 4 -> new Pair<>(flo2, flo2+delta);
            case 5 -> new Pair<>(flo3, flo2+delta);
            case 6 -> new Pair<>(flo1, flo3+delta);
            case 7 -> new Pair<>(flo2, flo3+delta);
            case 8 -> new Pair<>(flo3, flo3+delta);
            default -> throw new IllegalStateException("Unexpected value slot number: " + slotnum);
        };
    }



}
