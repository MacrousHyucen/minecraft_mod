package net.archasmiel.thaumcraft.screen.thaumonomicon.parts;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.*;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Tabs.TRANSLATE_PATH;

public class Tab extends WButton {

    // TODO make builder and research basic system

    public final String id;
    private final TranslatableText name;
    private final Texture icon;

    private Integer posX;
    private Integer posY;

    private Integer size;
    private Integer sizeD2;
    private Integer sizeD4;
    private Integer sizeD8;

    private boolean flipped;

    private float backX = 0;
    private float backY = 0;

    private final Texture background;
    private boolean state = false;





    public Tab(String id, Texture background, Integer size, Texture icon) {
        this.id = id;
        this.name = new TranslatableText(TRANSLATE_PATH + id + "_tab");
        this.icon = icon;

        this.posX = this.posY = 0;
        this.size = size;
        this.sizeD2 = size/2;
        this.sizeD4 = size/4;
        this.sizeD8 = size/8;

        this.background = background;
    }

    public Tab(String id, Texture background, Integer x, Integer y, Integer size, Texture icon) {
        this.id = id;
        this.name = new TranslatableText(TRANSLATE_PATH + id + "_tab");
        this.icon = icon;

        this.posX = x;
        this.posY = y;
        this.size = size;
        this.sizeD2 = size/2;
        this.sizeD4 = size/4;
        this.sizeD8 = size/8;

        this.background = background;
    }




    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        int iconSize = 3*sizeD4;

        if (getState()) {
            ScreenDrawing.texturedRect(matrices, x, y, size, size, research_tab_active, DEF_COLOR);
            ScreenDrawing.texturedRect(matrices, x + sizeD4, y + sizeD8, iconSize, iconSize, icon, DEF_COLOR);
            return;
        }
        ScreenDrawing.texturedRect(matrices, x, y, size, size, research_tab_inactive, DEF_COLOR);
        ScreenDrawing.texturedRect(matrices, x + sizeD2, y + sizeD8, iconSize, iconSize, icon, DEF_COLOR);

        if (!isPointOnTab(mouseX, mouseY)) ScreenDrawing.texturedRect(matrices, x, y, size, size, research_tab_shadow, DEF_COLOR);
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
        return (x > posX && x < posX+size) && (y > posY && y < posY+size);
    }

    public Texture cutBackground(int sizeX, int sizeY) {
        float x1 = backX/sizeX/2;
        float y1 = backY/sizeY/2;
        float x2 = x1 + 0.5f;
        float y2 = y1 + 0.5f;
        return background.withUv(x1, y1, x2, y2);
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

    public float getBackX() {
        return backX;
    }

    public float getBackY() {
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
        this.sizeD2 = size/2;
        this.sizeD4 = size/4;
        this.sizeD8 = size/8;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setBackX(float backX) {
        this.backX = backX;
    }

    public void setBackY(float backY) {
        this.backY = backY;
    }

}
