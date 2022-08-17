package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.*;

public class Tab extends WButton {

    private final TranslatableText name;
    private final Texture icon;

    private Integer posX;
    private Integer posY;
    private Integer size;

    private double backX = 0;
    private double backY = 0;

    private final Texture background;
    private boolean state = false;







    public Tab(Texture background, Integer x, Integer y, Integer size, Texture icon, String name) {
        this.name = new TranslatableText(name);
        this.icon = icon;

        this.posX = x;
        this.posY = y;
        this.size = size;

        this.background = background;
    }




    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        int sizeTemp = size*3/4;

        if (getState()) {
            ScreenDrawing.texturedRect(matrices, x, y, size, size, research_tab_active, DEF_COLOR);
            ScreenDrawing.texturedRect(matrices, x + size/4, y + size/8, sizeTemp, sizeTemp, icon, DEF_COLOR);
            return;
        }

        ScreenDrawing.texturedRect(matrices, x, y, size, size, research_tab_inactive, DEF_COLOR);
        ScreenDrawing.texturedRect(matrices, x + size/2, y + size/8, sizeTemp, sizeTemp, icon, DEF_COLOR);
        ScreenDrawing.texturedRect(matrices, x, y, size, size, research_tab_shadow, DEF_COLOR);
    }

    @Override
    public void renderTooltip(MatrixStack matrices, int x, int y, int tX, int tY) {
        ScreenDrawing.drawString(matrices, name.asOrderedText(), x + tX + 8, y + tY, DEF_COLOR);
    }

    @Override
    public InputResult onClick(int x, int y, int button) {
        return InputResult.IGNORED;
    }

    @Override
    public boolean canResize() {
        return true;
    }

    @Override
    public boolean canFocus() {
        return true;
    }






    public boolean isPointOnTab(Integer x, Integer y) {
        return ((x < posX +size) && (x > posX)) && ((y < posY +size) && (y > posY));
    }





    public Integer getPosX() {
        return posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public Integer getSize() {
        return size;
    }

    public boolean getState() {
        return state;
    }

    public double getBackX() {
        return backX;
    }

    public double getBackY() {
        return backY;
    }

    public Texture getBackground() {
        return background;
    }



    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setBackX(double backX) {
        this.backX = (float) backX;
    }

    public void setBackY(double backY) {
        this.backY = (float) backY;
    }

}
