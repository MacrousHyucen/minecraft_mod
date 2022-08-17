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
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Pair;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class ArcaneWorkbenchBlockEntityRenderer implements BlockEntityRenderer<ArcaneWorkbenchBlockEntity> {

    private VertexConsumerProvider vertexConsumers;
    private int light;
    private int overlay;

    public ArcaneWorkbenchBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {

    }

    @Override
    public void render(ArcaneWorkbenchBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        this.vertexConsumers = vertexConsumers;
        this.light = light;
        this.overlay = overlay;
        renderWand(entity, matrices);
        renderCraftingInventory(entity, matrices);
    }

    private void renderWand(ArcaneWorkbenchBlockEntity entity, MatrixStack matrices) {

        if (entity.getWorld() != null && entity.getWorld().getBlockEntity(entity.getPos()) != null) {
            Pair<Float, Float> coord;       // coordinates for different directions
            float angle1;                   // x and z rotating angles
            float angle2;

            Direction facing = entity.getWorld().getBlockState(entity.getPos()).get(Properties.HORIZONTAL_FACING);

            switch (facing) {
                case NORTH -> {
                    coord = new Pair<>(0.2f, 0.8f);
                    angle1 = 90;
                    angle2 = -45;
                }
                case EAST -> {
                    coord = new Pair<>(0.2f, 0.2f);
                    angle1 = 90;
                    angle2 = 45;
                }
                case SOUTH -> {
                    coord = new Pair<>(0.8f, 0.2f);
                    angle1 = -90;
                    angle2 = 45;
                }
                case WEST -> {
                    coord = new Pair<>(0.8f, 0.8f);
                    angle1 = -90;
                    angle2 = -45;
                }
                default -> throw new IllegalStateException("Wrong arcane workbench facing.");
            }

            matrices.push();
            matrices.translate(coord.getLeft(), 1.05, coord.getRight());
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(angle1));
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(angle2));
            MinecraftClient.getInstance().getItemRenderer().renderItem(entity.getStack(10), ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 0);
            matrices.pop();
        }
    }

    private void renderCraftingInventory(ArcaneWorkbenchBlockEntity entity, MatrixStack matrices) {
        for (int i = 0; i < 9; i++) {
            ItemStack item = entity.getStack(i);
            if (item.getCount() <= 0) continue;

            renderItem(matrices, entity, i, 1, item);

            float percent = (float) item.getCount() / item.getMaxCount();
            if (item.getMaxCount() > 1 && !item.getName().toString().contains("block")) {
                if (percent >= 0.25f)
                    renderItem(matrices, entity, i, 2, item);
                if (percent >= 0.50f)
                    renderItem(matrices, entity, i, 3, item);
                if (percent >= 0.75f)
                    renderItem(matrices, entity, i, 4, item);
            }
        }
    }

    private void renderItem(MatrixStack matrices, ArcaneWorkbenchBlockEntity entity, int slot, int itemNum, ItemStack item) {
        matrices.push();
        setCoordinates(entity, matrices, slot, itemNum);
        setScale(matrices, item);
        MinecraftClient.getInstance().getItemRenderer().renderItem(item, ModelTransformation.Mode.FIXED, light, overlay, matrices, vertexConsumers, 0);
        matrices.pop();
    }

    private void setCoordinates(ArcaneWorkbenchBlockEntity entity, MatrixStack matrices, int slot, int itemNum) {
        if (entity.getWorld() != null && entity.getWorld().getBlockEntity(entity.getPos()) != null) {
            Pair<Float, Float> coord;
            Vec3f rotVectorY = new Vec3f(0f, 0f, 1f);    // vector for model rotation around z axis
            float angle;                                 // angle for model rotation around z axis

            Direction facing = entity.getWorld().getBlockState(entity.getPos()).get(Properties.HORIZONTAL_FACING);
            int div = (slot / 3) + 1;
            int mod = (slot % 3) + 1;

            switch (facing) {
                case NORTH -> {
                    angle = 0f;
                    coord = new Pair<>(0.875f - 0.1875f * mod, 0.875f - 0.1875f * div);
                }
                case EAST -> {
                    angle = 90f;
                    coord = new Pair<>(0.125f + 0.1875f * div, 0.875f - 0.1875f * mod);
                }
                case SOUTH -> {
                    angle = 180f;
                    coord = new Pair<>(0.125f + 0.1875f * mod, 0.125f + 0.1875f * div);
                }
                case WEST -> {
                    angle = 270f;
                    coord = new Pair<>(0.875f - 0.1875f * div, 0.125f + 0.1875f * mod);
                }
                default -> throw new IllegalStateException("Wrong arcane workbench facing.");
            }
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90.0f));    // rotating model around X axis (for item correct models)
            matrices.translate(coord.getLeft(), coord.getRight(), -1 - itemNum * 0.01f);          // translating item to its slot on table
            matrices.multiply(rotVectorY.getDegreesQuaternion(angle));          // rotating model around z axis
        }
    }

    private void setScale(MatrixStack matrices, ItemStack item) {
        float scale = item.getName().toString().contains("block") ? 0.225f : 0.15f;
        matrices.scale(scale, scale, scale);
    }


}
