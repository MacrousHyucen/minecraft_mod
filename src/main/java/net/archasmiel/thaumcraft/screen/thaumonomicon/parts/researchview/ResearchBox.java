package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.screen.thaumonomicon.ThaumonomiconGUI;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.DrawUtility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Identified;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.Research;
import net.archasmiel.thaumcraft.sounds.Sounds;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs.TAB_SIZE;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.DEF_COLOR;

public class ResearchBox extends WWidget implements Identified {

    public static class Builder {

        private final ResearchBox box;

        public Builder() {
            box = new ResearchBox();
        }

        public Builder research(Research research) {
            box.research = research;
            return this;
        }

        public Builder pos(int x, int y) {
            box.relX = x;
            box.relY = y;
            return this;
        }


        /**
         *   Basic size of ResearchBox.<br>
         *   Equals default size of Tab.
         */
        public Builder size() {
            return this.size(TAB_SIZE);
        }

        public Builder size(int size) {
            return this.size(size, size);
        }

        public Builder size(int width, int height) {
            box.setSize(width, height);
            return this;
        }



        public Builder form(Texture formTex) {
            box.formTex = formTex;
            return this;
        }

        public Builder bounds(Texture boundsTex) {
            box.boundsTex = boundsTex;
            box.hasBounds = true;
            return this;
        }

        public Builder noBounds() {
            box.hasBounds = false;
            return this;
        }

        public ResearchBox build() {
            if (box.width <= 0 || box.height <= 0)
                throw new IllegalStateException("Zero size research box");
            if (box.research == null)
                throw new IllegalStateException("No content for research box");
            if (box.formTex == null)
                throw new IllegalStateException("No form texture for research box");
            if (box.hasBounds && box.boundsTex == null)
                throw new IllegalStateException("No bounds texture for research box");

            return box;
        }

    }

    private Texture formTex;
    private boolean hasBounds;
    private Texture boundsTex;
    private Research research;
    private int relX;
    private int relY;
    private boolean visible = false;

    private ResearchBox() {

    }

    @Override
    public String getId() {
        return research.getId();
    }

    public Texture getFormTex() {
        return formTex;
    }

    public Texture getBoundsTex() {
        return boundsTex;
    }

    public Research getResearch() {
        return research;
    }

    public int getRelX() {
        return relX;
    }

    public int getRelY() {
        return relY;
    }

    public void setVisible(boolean state) {
        this.visible = state;
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        if (!visible) return;

        float pX = (float) x + this.x;
        float pY = (float) y + this.y;

        DrawUtility.precisiveTexturedRect(
            matrices,
            pX, pY,
            this.width, this.height,
            formTex, DEF_COLOR
        );

        float iconWidth = this.width * 0.625f;
        float iconHeight = this.height * 0.625f;
        DrawUtility.precisiveTexturedRect(
            matrices,
            pX + (this.width - iconWidth) * 0.5f,
            pY + (this.height - iconHeight) * 0.5f,
            iconWidth,
            iconHeight,
            research.getIcon(),
            DEF_COLOR
        );

        if (hasBounds) {
            DrawUtility.precisiveTexturedRect(
                matrices,
                pX, pY,
                this.width, this.height,
                boundsTex, DEF_COLOR
            );
        }
    }

    @Override
    @Environment(EnvType.CLIENT)
    public InputResult onClick(int x, int y, int button) {
        if (!visible) return InputResult.IGNORED;

        if (this.getHost() instanceof ThaumonomiconGUI gui) {
            gui.getBook().setCurrentView(this.research.getBookView());
            gui.setRootPanel(gui.getBook());

            MinecraftClient.getInstance().getSoundManager()
                .play(PositionedSoundInstance.master(Sounds.PAGE_FLIP, 1.0F));
        }

        return InputResult.PROCESSED;
    }

    @Override
    public void renderTooltip(MatrixStack matrices, int x, int y, int tX, int tY) {
        if (!visible) return;

        int intent = 3;

        x += 7;
        y -= 15;
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        int width = (int) Math.max(
            textRenderer.getWidth(research.getName()) * 0.8f,
            textRenderer.getWidth(research.getDescription()) * 0.5f
        ) + 2*intent;
        int height = (int) (30*0.5f);
        ScreenDrawing.coloredRect(matrices, x+tX, y+tY, width, height+2*intent, 0xAA000000);

        x += intent;
        y += intent;
        matrices.push();
        float scaling = 0.8f;
        float invScaling = 1/scaling;
        matrices.scale(scaling, scaling, 1.0f);
        MinecraftClient.getInstance().textRenderer.drawWithShadow(
            matrices, research.getName().asOrderedText(),
            invScaling*(x+tX), invScaling*(y+tY), DEF_COLOR);

        matrices.scale(invScaling, invScaling, 1.0f);
        scaling = 0.5f;
        invScaling = 1/scaling;
        matrices.scale(scaling, scaling, 1.0f);
        MinecraftClient.getInstance().textRenderer.drawWithShadow(
            matrices, research.getDescription().asOrderedText(),
            invScaling*(x+tX), invScaling*(y+tY+10), 0xBB8888FF);
        matrices.pop();
    }

    @Override
    public boolean canResize() {
        return false;
    }
}
