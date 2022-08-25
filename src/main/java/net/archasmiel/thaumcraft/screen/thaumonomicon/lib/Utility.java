package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Matrix4f;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;

public class Utility {

    private Utility() {

    }

    public static Texture cutTexture(Texture texture, float x, float y, float dx, float dy, int sizeX, int sizeY) {
        return texture.withUv(
                x / sizeX,
                y / sizeY,
                (x + dx) / sizeX,
                (y + dy) / sizeY
        );
    }

    public static Texture loadTexture(String modId, String path) {
        return new Texture(new Identifier(modId, path));
    }

    public static Texture loadTexture(String path) {
        return new Texture(new Identifier(MOD_ID, path));
    }


    public static void precisiveTexturedRect(MatrixStack matrices, float x, float y, float width, float height, Texture texture, int color) {
        precisiveTexturedRect(matrices, x, y, width, height, texture, color, 1.0F);
    }

    public static void precisiveTexturedRect(MatrixStack matrices, float x, float y, float width, float height, Texture texture, int color, float opacity) {
        precisiveTexturedRect(matrices, x, y, width, height, texture.image(), texture.u1(), texture.v1(), texture.u2(), texture.v2(), color, opacity);
    }

    public static void precisiveTexturedRect(MatrixStack matrices, float x, float y, float width, float height, Identifier texture, float u1, float v1, float u2, float v2, int color, float opacity) {
        if (width <= 0) {
            width = 1;
        }

        if (height <= 0) {
            height = 1;
        }

        float r = (color >> 16 & 255) / 255.0F;
        float g = (color >> 8 & 255) / 255.0F;
        float b = (color & 255) / 255.0F;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        Matrix4f model = matrices.peek().getPositionMatrix();
        RenderSystem.enableBlend();
        RenderSystem.setShaderTexture(0, texture);
        RenderSystem.setShaderColor(r, g, b, opacity);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        buffer.vertex(model, x, (y + height), 0.0F).texture(u1, v2).next();
        buffer.vertex(model, (x + width), (y + height), 0.0F).texture(u2, v2).next();
        buffer.vertex(model, (x + width), y, 0.0F).texture(u2, v1).next();
        buffer.vertex(model, x, y, 0.0F).texture(u1, v1).next();
        buffer.end();
        BufferRenderer.draw(buffer);
        RenderSystem.disableBlend();
    }

}
