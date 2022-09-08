package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview;

import io.github.cottonmc.cotton.gui.client.Scissors;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.WLockedPlainPanel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.util.math.MatrixStack;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.DEF_COLOR;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.RESEARCH_BORDER;

public class Panel extends WLockedPlainPanel {

    private Tab currentTab;

    public Panel(int panelX, int panelY, int sizeX, int sizeY) {
        setLocation(panelX, panelY);
        setSize(sizeX, sizeY);
    }

    public Tab getCurrentTab() {
        return currentTab;
    }

    public void setCurrentTab(Tab tab) {
        if (currentTab != null) {
            this.currentTab.setState(false);
        }
        this.currentTab = tab;
        this.currentTab.setState(true);

        this.children.clear();
        this.currentTab.getResearchMap().keyList().stream().map(ResearchBox.class::cast).forEach(box ->
            this.add(box, Integer.MAX_VALUE, Integer.MAX_VALUE, box.getWidth(), box.getHeight())
        );
        updateChildren();
    }

    public void updateChildren() {
        this.children.forEach(e -> {
            ResearchBox box = (ResearchBox) e;
            float pX = box.getRelX() - currentTab.getBackX();
            float pY = box.getRelY() - currentTab.getBackY();

            box.setLocation((int) pX, (int) pY);
            box.setVisible(!(pX < -box.getWidth() || pY < -box.getHeight() || pX > width || pY > height));
        });
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        ScreenDrawing.texturedRect(
            matrices,
            x, y,
            width, height,
            currentTab.cutBackground(width, height), DEF_COLOR
        );

        Scissors.push(x, y, width, height);
        this.children.forEach(e ->
            e.paint(matrices, x, y, mouseX, mouseY)
        );
        Scissors.pop();

        ScreenDrawing.texturedRect(
            matrices,
            x, y,
            width, height,
            RESEARCH_BORDER, DEF_COLOR
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public InputResult onMouseDrag(int x, int y, int button, double deltaX, double deltaY) {
        if (button == 0) {
            float backX = currentTab.getBackX() - (float) deltaX;
            if (backX < 0) {
                backX = 0;
            } else if (backX > width) {
                backX = width;
            }
            currentTab.setBackX(backX);

            float backY = currentTab.getBackY() - (float) deltaY;
            if (backY < 0) {
                backY = 0;
            } else if (backY > height) {
                backY = height;
            }
            currentTab.setBackY(backY);

            updateChildren();
            return InputResult.PROCESSED;
        }

        return InputResult.IGNORED;
    }
}
