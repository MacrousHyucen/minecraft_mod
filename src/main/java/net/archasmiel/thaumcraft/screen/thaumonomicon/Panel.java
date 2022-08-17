package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.*;

public class Panel extends WWidget {

    private Tab activeTab;

    private final Integer sizeX;
    private final Integer sizeY;

    private Integer panelX;
    private Integer panelY;




    public Panel(Integer panelX, Integer panelY, Integer sizeX, Integer sizeY) {
        this.panelX = panelX;
        this.panelY = panelY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setSize(sizeX, sizeY);
    }



    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        ScreenDrawing.texturedRect(matrices, x, y, sizeX, sizeY, cutBack(), DEF_COLOR);
        ScreenDrawing.texturedRect(matrices, x, y, sizeX, sizeY, research_border, DEF_COLOR);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public InputResult onMouseDrag(int x, int y, int button, double deltaX, double deltaY) {
        if (button == 0) {
            double backX = activeTab.getBackX() - deltaX;
            if (backX < 0) backX = 0;
            else if (backX > sizeX) backX = sizeX;
            activeTab.setBackX(backX);

            double backY = activeTab.getBackY() - deltaY;
            if (backY < 0) backY = 0;
            else if (backY > sizeY) backY = sizeY;
            activeTab.setBackY(backY);
        }
        return InputResult.PROCESSED;
    }




    private Texture cutBack() {
        float backX = (float) activeTab.getBackX();
        float backY = (float) activeTab.getBackY();
        return activeTab.getBackground().withUv(
                (backX)/sizeX/2,
                (backY)/sizeY/2,
                (backX)/sizeX/2 + 0.5f,
                (backY)/sizeY/2 + 0.5f
        );
    }

    public void setCurrentTab(Tab tab) {
        this.activeTab = tab;
    }

    public Tab getCurrentTab() {
        return activeTab;
    }



    public Integer getSizeX() {
        return sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public Integer getPanelX() {
        return panelX;
    }

    public void setPanelX(Integer panelX) {
        this.panelX = panelX;
    }

    public Integer getPanelY() {
        return panelY;
    }

    public void setPanelY(Integer panelY) {
        this.panelY = panelY;
    }
}
