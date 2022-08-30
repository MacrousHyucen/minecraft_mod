package net.archasmiel.thaumcraft.screen.thaumonomicon.parts;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.archasmiel.thaumcraft.networking.PacketIDs;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.PacketByteBuf;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.DEF_COLOR;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.RESEARCH_BORDER;

public class Panel extends WPlainPanel {

    private Tab currentTab;

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



    @Override
    public WPanel setBackgroundPainter(BackgroundPainter painter) {
        return null;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        ScreenDrawing.texturedRect(matrices, x, y, sizeX, sizeY, currentTab.cutBackground(sizeX, sizeY), DEF_COLOR);
        for (WWidget widget: this.children) widget.paint(matrices, x, y, mouseX, mouseY);
        ScreenDrawing.texturedRect(matrices, x, y, sizeX, sizeY, RESEARCH_BORDER, DEF_COLOR);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public InputResult onMouseDrag(int x, int y, int button, double deltaX, double deltaY) {
        if (button == 0) {
            float backX = currentTab.getBackX() - (float) deltaX;
            if (backX < 0) backX = 0;
            else
            if (backX > sizeX) backX = sizeX;
            currentTab.setBackX(backX);

            float backY = currentTab.getBackY() - (float) deltaY;
            if (backY < 0) backY = 0;
            else
            if (backY > sizeY) backY = sizeY;
            currentTab.setBackY(backY);

            updateChildren();
            sendActiveTabUpdate();

            return InputResult.PROCESSED;
        }

        return InputResult.IGNORED;
    }

    private void sendActiveTabUpdate() {
        PacketByteBuf packet = PacketByteBufs.create();
        packet.writeString(currentTab.getId());
        packet.writeFloat(currentTab.getBackX()).writeFloat(currentTab.getBackY());
        ClientPlayNetworking.send(PacketIDs.THAUMONOMICON_DATA_SERVER, packet);
    }




    public void updateChildren() {
        for (WWidget widget: this.children) {
            if (widget instanceof ResearchBox box) {
                int pX = box.getPosX() - (int) currentTab.getBackX();
                int pY = box.getPosY() - (int) currentTab.getBackY();
                if (pX >= 0 && pX <= sizeX-box.getSizeX() && pY >= 0 && pY <= sizeY-box.getSizeY()) {
                    box.setLocation(pX, pY);
                } else {
                    box.setLocation(Integer.MAX_VALUE, Integer.MAX_VALUE);
                }
            }
        }
    }

    public void setCurrentTab(Tab tab) {
        this.currentTab = tab;
        this.children.clear();
        for (ResearchBox box: this.currentTab.getResearchMap().keyList()) {
            this.add(box, Integer.MAX_VALUE, Integer.MAX_VALUE, box.getSizeX(), box.getSizeY());
        }
        updateChildren();
    }

    public Tab getCurrentTab() {
        return currentTab;
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
