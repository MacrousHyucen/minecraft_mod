package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Identified;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.Research;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
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

    private ResearchBox() {

    }

    private Texture formTex;
    private boolean hasBounds;
    private Texture boundsTex;
    private Research research;
    private int relX;
    private int relY;

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

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        if (this.getParent() instanceof Panel panel) {
            float pX = (float) x + this.x;
            float pY = (float) y + this.y;

            if (pX >= x && pY >= y && pX <= (x + panel.getWidth() - this.width) && pY <= (y + panel.getHeight() - this.height)) {
                Utility.precisiveTexturedRect(
                    matrices,
                    pX, pY,
                    this.width, this.height,
                    formTex, DEF_COLOR
                );

                float iconWidth = this.width * 0.625f;
                float iconHeight = this.height * 0.625f;
                Utility.precisiveTexturedRect(
                    matrices,
                    pX + (this.width - iconWidth) * 0.5f,
                    pY + (this.height - iconHeight) * 0.5f,
                    iconWidth,
                    iconHeight,
                    research.getIcon(),
                    DEF_COLOR
                );

                if (hasBounds) {
                    Utility.precisiveTexturedRect(
                        matrices,
                        pX, pY,
                        this.width, this.height,
                        boundsTex, DEF_COLOR
                    );
                }
            }
        }
    }

    @Override
    public InputResult onClick(int x, int y, int button) {
        System.out.println("clicked on " + research.getId());
        return InputResult.PROCESSED;
    }

    @Override
    public void renderTooltip(MatrixStack matrices, int x, int y, int tX, int tY) {
        x += 7;
        y -= 15;
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        int width = (int) Math.max(
            textRenderer.getWidth(research.getName()) * 0.75f,
            textRenderer.getWidth(research.getDescription()) * 0.66f
        ) + 7;
        ScreenDrawing.coloredRect(matrices, x+tX, y+tY, width, 25, 0xBB000000);

        x += 4;
        y += 4;
        matrices.push();

        float scaling = 0.75f;
        float invScaling = 1/scaling;
        matrices.scale(scaling, scaling, 1.0f);
        ScreenDrawing.drawStringWithShadow(
            matrices,
            research.getName().asOrderedText(),
            HorizontalAlignment.LEFT,
            (int)(invScaling*(x+tX)),
            (int)(invScaling*(y+tY)),
            200, 0x99FFFFFF
        );

        matrices.scale(invScaling, invScaling, 1.0f);
        scaling = 0.66f;
        invScaling = 1/scaling;
        matrices.scale(scaling, scaling, 1.0f);
        ScreenDrawing.drawStringWithShadow(
            matrices,
            research.getDescription().asOrderedText(),
            HorizontalAlignment.LEFT,
            (int)(invScaling*(x+tX)),
            (int)(invScaling*(y+tY+10)),
            200, 0x99CCCCCC
        );

        matrices.pop();
    }
}
