package net.archasmiel.thaumcraft.screen.thaumonomicon.parts;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Identified;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.Research;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

import java.util.Objects;

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

        public Builder pos(int posX, int posY) {
            box.setPos(posX, posY);
            return this;
        }


        public Builder size() {
            return this.size(TAB_SIZE);
        }

        public Builder size(int size) {
            return this.size(size, size);
        }

        public Builder size(int sizeX, int sizeY) {
            box.setSizes(sizeX, sizeY);
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
            if (box.sizeX == 0 || box.sizeY == 0)
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

    private int posX;
    private int posY;
    private int sizeX;
    private int sizeY;

    private Texture formTex;

    private boolean hasBounds;
    private Texture boundsTex;

    private Research research;





    private ResearchBox() {

    }






    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        if (this.getParent() instanceof Panel panel) {
            int pX = x + posX - (int) panel.getCurrentTab().getBackX();
            int pY = y + posY - (int) panel.getCurrentTab().getBackY();
            if (pX >= x && pX <= x+panel.getSizeX()-sizeX && pY >= y && pY <= y+panel.getSizeY()-sizeY) {
                Utility.precisiveTexturedRect(matrices, pX, pY, sizeX, sizeY, formTex, DEF_COLOR);
                if (hasBounds) Utility.precisiveTexturedRect(matrices, pX, pY, sizeX, sizeY, boundsTex, DEF_COLOR);
                Utility.precisiveTexturedRect(matrices, pX + (float) sizeX*3/16, pY + (float) sizeX*3/16, (float) sizeX*5/8, (float) sizeX*5/8, research.getIcon(), DEF_COLOR);
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
        int width = (int) Math.max(
                MinecraftClient.getInstance().textRenderer.getWidth(research.getName()) * 0.75f,
                MinecraftClient.getInstance().textRenderer.getWidth(research.getDescription()) * 0.66f
        ) + 7;
        ScreenDrawing.coloredRect(matrices, x+tX, y+tY, width, 25, 0xBB000000);

        x += 4;
        y += 4;
        matrices.push();

        float scaling = 0.75f;
        float invScaling = 1/scaling;
        matrices.scale(scaling, scaling, 1.0f);
        ScreenDrawing.drawStringWithShadow(matrices, research.getName().asOrderedText(), HorizontalAlignment.LEFT, (int)(invScaling*(x+tX)), (int)(invScaling*(y+tY)), 200, 0x99FFFFFF);

        matrices.scale(invScaling, invScaling, 1.0f);
        scaling = 0.66f;
        invScaling = 1/scaling;
        matrices.scale(scaling, scaling, 1.0f);
        ScreenDrawing.drawStringWithShadow(matrices, research.getDescription().asOrderedText(), HorizontalAlignment.LEFT, (int)(invScaling*(x+tX)), (int)(invScaling*(y+tY+10)), 200, 0x99CCCCCC);

        matrices.pop();
    }




    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setSizes(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }



    @Override
    public String getId() {
        return research.getId();
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResearchBox that = (ResearchBox) o;

        if (posX != that.posX) return false;
        if (posY != that.posY) return false;
        if (sizeX != that.sizeX) return false;
        if (sizeY != that.sizeY) return false;
        if (!Objects.equals(formTex, that.formTex)) return false;
        return Objects.equals(boundsTex, that.boundsTex);
    }

    @Override
    public int hashCode() {
        int result = posX;
        result = 31 * result + posY;
        result = 31 * result + sizeX;
        result = 31 * result + sizeY;
        result = 31 * result + (formTex != null ? formTex.hashCode() : 0);
        result = 31 * result + (boundsTex != null ? boundsTex.hashCode() : 0);
        return result;
    }
}
