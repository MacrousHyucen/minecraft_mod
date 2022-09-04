package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
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

    public Panel(int panelX, int panelY, int sizeX, int sizeY) {
        setLocation(panelX, panelY);
        setSize(sizeX, sizeY);
    }

    private Tab currentTab;

    public Tab getCurrentTab() {
        return currentTab;
    }

    public void updateChildren() {
        this.children.forEach(e -> {
            ResearchBox box = (ResearchBox) e;
            float pX = box.getRelX() - currentTab.getBackX();
            float pY = box.getRelY() - currentTab.getBackY();

            System.out.printf("%s %f %f\n", box.getId(), pX, pY);
            if (pX < 0 || pY < 0 || pX > (width - box.getWidth()) || pY > (height - box.getHeight())) {
                box.setLocation(Integer.MAX_VALUE, Integer.MAX_VALUE);
                return;
            }

            box.setLocation((int) pX, (int) pY);
        });
    }

    public void setCurrentTab(Tab tab) {
        if (currentTab == null) {
            this.currentTab = tab;
            this.currentTab.setState(true);
            return;
        }

        this.currentTab.setState(false);
        this.currentTab = tab;
        this.currentTab.setState(true);

        this.children.clear();
        this.currentTab.getResearchMap().keyList().forEach(box ->
            this.add(box, Integer.MAX_VALUE, Integer.MAX_VALUE, box.getWidth(), box.getHeight())
        );
        updateChildren();
    }

    @Override
    public WPanel setBackgroundPainter(BackgroundPainter painter) {
        return null;
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
        this.children.forEach(e ->
            e.paint(matrices, x, y, mouseX, mouseY)
        );
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

    @Override
    public boolean canResize() {
        return false;
    }
}
