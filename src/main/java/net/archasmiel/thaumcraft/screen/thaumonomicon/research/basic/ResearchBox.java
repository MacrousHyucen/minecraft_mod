package net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.client.util.math.MatrixStack;

import java.util.Objects;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.DEF_COLOR;

public class ResearchBox extends WButton {

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
        ScreenDrawing.texturedRect(matrices, x, y, sizeX, sizeY, formTex, DEF_COLOR);
        ScreenDrawing.texturedRect(matrices, x, y, sizeX, sizeY, boundsTex, DEF_COLOR);
        ScreenDrawing.texturedRect(matrices, x, y, sizeX, sizeY, research.getIcon(), DEF_COLOR);
    }

    @Override
    public InputResult onClick(int x, int y, int button) {
        return InputResult.IGNORED;
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
