package net.archasmiel.thaumcraft.screen.thaumonomicon.parts;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;



public class Gui extends WPlainPanel {

    private Panel panel;
    private final List<Tab> tabs = new ArrayList<>();








    public Gui(Panel panel, List<Tab> tabs, Integer sizeX, Integer sizeY) {
        setSize(sizeX, sizeY);
        this.panel = panel;
        setTabs(tabs);
        setLocation(0, 0);
    }



    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        for (WWidget widget: this.children){
            if (widget instanceof Tab t)
                t.paint(matrices, x + t.getPosX(), y + t.getPosY(), mouseX, mouseY);
        }
        for (WWidget widget: this.children){
            if (widget instanceof Panel p)
                p.paint(matrices, x + p.getPanelX(), y + p.getPanelY(), mouseX, mouseY);
        }
    }


    @Override
    public InputResult onClick(int x, int y, int button) {
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

        for (Tab tab: tabs) {
            if (tab.getState()) {
                this.panel.setCurrentTab(tab);
                break;
            }
        }
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
        updateChildren();
    }



    private void updateChildren() {
        this.children.clear();
        this.add(panel, panel.getPanelX(), panel.getPanelY(), panel.getSizeX(), panel.getSizeY());
        for (Tab tab : tabs) {
            this.add(tab, tab.getPosX(), tab.getPosY(), tab.getSize(), tab.getSize());
        }
    }



    public Panel getPanel() {
        return panel;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

}
