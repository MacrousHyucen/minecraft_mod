package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview;

import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.WLockedPlainPanel;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;


public class ResearchGUI extends WLockedPlainPanel {

    private Panel panel;
    private final List<Tab> tabs = new ArrayList<>();

    public ResearchGUI(Panel panel, List<Tab> tabs, int sizeX, int sizeY) {
        setLocation(0, 0);
        setSize(sizeX, sizeY);

        setPanel(panel);
        setTabs(tabs);
    }

    public Panel getPanel() {
        return panel;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs.clear();
        this.tabs.addAll(tabs);
        updateTabs();

        this.panel.setCurrentTab(tabs.get(0));
        this.panel.getCurrentTab().setState(true);
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
        updatePanel();
    }

    public void addTab(Tab tab) {
        tabs.add(tab);
        this.add(tab, tab.getX(), tab.getY(), tab.getWidth(), tab.getHeight());
    }

    private void updateTabs() {
        this.children.stream().filter(Tab.class::isInstance).forEach(this.children::remove);
        tabs.forEach(tab -> this.add(tab, tab.getX(), tab.getY(), tab.getWidth(), tab.getHeight()));
    }

    private void updatePanel() {
        this.children.stream().filter(Panel.class::isInstance).forEach(this.children::remove);
        this.add(panel, panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        // tabs first, then panel
        tabs.forEach(tab -> tab.paint(matrices, x + tab.getX(), y + tab.getY(), mouseX, mouseY));
        panel.paint(matrices, x + panel.getX(), y + panel.getY(), mouseX, mouseY);
    }
}
