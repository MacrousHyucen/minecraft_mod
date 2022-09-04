package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;


public class ResearchGUI extends WPlainPanel {

    public ResearchGUI(Panel panel, List<Tab> tabs, Integer sizeX, Integer sizeY) {
        setLocation(0, 0);
        setSize(sizeX, sizeY);

        setPanel(panel);
        setTabs(tabs);
    }

    private Panel panel;
    private final List<Tab> tabs = new ArrayList<>();

    public Panel getPanel() {
        return panel;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void addTab(Tab tab) {
        tabs.add(tab);
        updateChildren();
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs.clear();
        this.tabs.addAll(tabs);

        tabs.stream().filter(Tab::getState).findFirst().ifPresent(tab ->
            this.panel.setCurrentTab(tab)
        );
        updateChildren();
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
        updateChildren();
    }

    private void updateChildren() {
        this.children.clear();
        tabs.forEach(tab -> this.add(tab, tab.getX(), tab.getY(), tab.getWidth(), tab.getHeight()));
        this.add(panel, panel.getX(), panel.getY(), panel.getWidth(), panel.getHeight());
    }

    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        this.children.stream().filter(Tab.class::isInstance).map(Tab.class::cast).forEach(t ->
            t.paint(matrices, x + t.getX(), y + t.getY(), mouseX, mouseY)
        );
        this.children.stream().filter(Panel.class::isInstance).map(Panel.class::cast).forEach(e ->
            e.paint(matrices, x + e.getX(), y + e.getY(), mouseX, mouseY)
        );
    }

    @Override
    public InputResult onClick(int x, int y, int button) {
        return InputResult.IGNORED;
    }

    @Override
    public WPanel setBackgroundPainter(BackgroundPainter painter) {
        return null;
    }
}
