package net.archasmiel.thaumcraft.gui.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;


public class ResearchGui extends WPlainPanel {

    private final Integer sizeX, sizeY;

    private ResearchPanel panel;
    private Integer panelX, panelY;

    private List<ResearchTab> tabs = new ArrayList<>();
    private ResearchTab activeTab;

    public ResearchGui(Integer sizeX, Integer sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setSize(sizeX, sizeY);
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        int ypos = 0;
        for (ResearchTab tab : tabs) {
            tab.paint(matrices, x, y + ypos, mouseX, mouseY);
            ypos += tab.getSize();
        }
        panel.paint(matrices, x + panelX, y + panelY, panel.getSizeX(), panel.getSizeY());
    }

    @Override
    public WPanel setBackgroundPainter(BackgroundPainter painter) {
        return null;
    }

    @Override
    public InputResult onClick(int x, int y, int button) {
        if (button == 0) {
            if (x >= 0 && x <= panelX)
                for (int i = 0 ; i < tabs.size() ; i++) {
                    if (y >= i * tabs.get(i).getSize() && y <= (i + 1) * tabs.get(i).getSize()){
                        if (!tabs.get(i).isActive()){
                            for (ResearchTab tab: tabs) tab.setActive(false);
                            tabs.get(i).setActive(true);
                        }
                    }
                }
        }
        return InputResult.IGNORED;
    }

    public void addTab(ResearchTab w) {
        tabs.add(w);
        super.children.clear();
        addTabsToScreen();
    }

    public void setTabs(List<ResearchTab> wList) {
        tabs.clear();
        tabs.addAll(wList);
        super.children.clear();
        addTabsToScreen();
    }

    private void addTabsToScreen() {
        int ypos = 0;
        for (ResearchTab tab : tabs) {
            super.add(tab, 0, ypos, tab.getSize(), tab.getSize());
            ypos += tab.getSize();
        }
    }

    public List<ResearchTab> getTabs() {
        return tabs;
    }

    public void setResearchPanel(ResearchPanel w, int x, int y, int width, int height) {
        panel = w;
        panelX = x;
        panelY = y;
        super.add(w, x, y, width, height);
    }
}
