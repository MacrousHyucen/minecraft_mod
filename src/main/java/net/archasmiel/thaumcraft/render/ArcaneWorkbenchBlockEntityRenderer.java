package net.archasmiel.thaumcraft.render;

import net.archasmiel.thaumcraft.blockentity.ArcaneWorkbenchBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class ArcaneWorkbenchBlockEntityRenderer implements BlockEntityRenderer<ArcaneWorkbenchBlockEntity> {

    final float itemSizeMul = 0.15f;
    final float itemCoordMul = 1/itemSizeMul;

    public ArcaneWorkbenchBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(ArcaneWorkbenchBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {


//        System.out.print("[");
//        for (int i = 0 ; i < 9 ; i++)
//            System.out.print(entity.getStack(i) + " ");
//        System.out.print("] ");
//        System.out.print(entity.getStack(10));
//        System.out.println();
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
            if (entity.getStack(i).getCount() > 0){
                // presets for rendering
                ModelTransformation.Mode mode = ModelTransformation.Mode.GUI;
                float sizeMul = itemSizeMul, coordMul = 1/sizeMul, delta = 0.0f;
                if (entity.getStack(i).getItem() instanceof BlockItem){
                    mode = ModelTransformation.Mode.GROUND;
                    sizeMul = 0.4f;
                    coordMul = 1/sizeMul;
                    delta = 1.2f/16;
                }

                matrices.push();
                matrices.scale(sizeMul, sizeMul, sizeMul);
                Pair<Float, Float> coords = getCoords(i, delta);
                matrices.translate(coordMul*coords.getLeft(), coordMul*1.01, coordMul*coords.getRight());
                matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90));
                MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(i), mode, light, overlay, matrices, vertexConsumers, i);
                matrices.pop();
                // if we not rendering block and have multiple items
                if (!(entity.getStack(i).getItem() instanceof BlockItem) && entity.getStack(i).getMaxCount() > 1) {
                    if (entity.getStack(i).getCount() > 1) {
                        matrices.push();
                        matrices.scale(itemSizeMul, itemSizeMul, itemSizeMul);
                        matrices.translate(itemCoordMul*coords.getLeft(), itemCoordMul*1.02, itemCoordMul*coords.getRight());
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90));
                        MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(i), mode, light, overlay, matrices, vertexConsumers, i);
                        matrices.pop();
                    }
                    if (entity.getStack(i).getCount() == entity.getStack(i).getMaxCount()) {
                        matrices.push();
                        matrices.scale(itemSizeMul, itemSizeMul, itemSizeMul);
                        matrices.translate(itemCoordMul*coords.getLeft(), itemCoordMul*1.03, itemCoordMul*coords.getRight());
                        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-90));
                        MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(i), mode, light, overlay, matrices, vertexConsumers, i);
                        matrices.pop();
                    }
                }

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
