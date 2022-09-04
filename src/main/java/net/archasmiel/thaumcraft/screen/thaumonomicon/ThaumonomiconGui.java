package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.ResearchGUI;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Panel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Tab;

import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs.*;

public class ThaumonomiconGui extends LightweightGuiDescription {

    public ThaumonomiconGui() {
        setRootPanel(root);
    }
    private static final Integer SIZE_X = 256 + TAB_SIZE;
    private static final Integer SIZE_Y = 256 - TAB_SIZE;

    private static final Integer RESEARCH_X = SIZE_X - TAB_SIZE;
    private static final Integer RESEARCH_Y = SIZE_Y;

    private final Panel researchPanel = new Panel(TAB_SIZE, 0, RESEARCH_X, RESEARCH_Y);
    private final ResearchGUI root = new ResearchGUI(researchPanel, Tabs.getTabList(), SIZE_X, SIZE_Y);

    public List<Tab> getTabs() {
        return root.getTabs();
    }

    public void setTabs(List<Tab> tabs) {
        root.setTabs(tabs);
        reposTabs();
    }

    public void addTab(Tab tab) {
        root.addTab(tab);
        reposTabs();
    }

}
