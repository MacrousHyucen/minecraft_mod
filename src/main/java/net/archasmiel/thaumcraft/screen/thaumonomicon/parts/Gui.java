package net.archasmiel.thaumcraft.screen.thaumonomicon.parts;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.archasmiel.thaumcraft.sounds.Sounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;



public class Gui extends WPlainPanel {

    private final Panel panel;
    private final List<Tab> tabs = new ArrayList<>();








    public Gui(Panel panel, List<Tab> tabs, Integer sizeX, Integer sizeY) {
        setSize(sizeX, sizeY);

        this.panel = panel;

        setTabs(tabs);
        for (Tab tab: tabs) {
            if (tab.getState()) {
                this.panel.setCurrentTab(tab);
                break;
            }
        }
    }



    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        for (Tab tab: tabs) {
            tab.paint(matrices, x + tab.getPosX(), y + tab.getPosY(), mouseX, mouseY);
        }
        panel.paint(matrices, x + panel.getPanelX(), y + panel.getPanelY(), mouseX, mouseY);
    }

    @Override
    public InputResult onClick(int x, int y, int button) {
        if (button == 0) {
            for (Tab tab: tabs) {
                if (!tab.getState() && tab.isPointOnTab(x, y)) {
                    panel.getCurrentTab().setState(false);
                    panel.setCurrentTab(tab);
                    tab.setState(true);

                    MinecraftClient.getInstance().getSoundManager()
                            .play(PositionedSoundInstance.master(Sounds.PAGE_FLIP, 1.0F));

                    return InputResult.PROCESSED;
                }
            }
        }

        return InputResult.IGNORED;
    }

    @Override
    public WPanel setBackgroundPainter(BackgroundPainter painter) {
        return null;
    }



    public void addTab(Tab tab) {
        tabs.add(tab);
        updateChildren();
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs.clear();
        this.tabs.addAll(tabs);
        updateChildren();
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    private void updateChildren() {
        this.children.clear();
        this.add(panel, panel.getPanelX(), panel.getPanelY(), panel.getSizeX(), panel.getSizeY());
        for (Tab tab : tabs) {
            this.add(tab, tab.getPosX(), tab.getPosY(), tab.getSize(), tab.getSize());
        }
    }

}
