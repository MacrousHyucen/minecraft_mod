package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Gui;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Panel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Tab;

import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs.*;

public class ThaumonomiconGui extends LightweightGuiDescription {

    private static final Integer SIZE_X = 256 + TAB_SIZE;
    private static final Integer SIZE_Y = 256 - TAB_SIZE;

    private static final Integer RESEARCH_X = SIZE_X - TAB_SIZE;
    private static final Integer RESEARCH_Y = SIZE_Y;



    private final Panel research = new Panel(TAB_SIZE, 0, RESEARCH_X, RESEARCH_Y);
    private final Gui root = new Gui(research, Tabs.getTabList(), SIZE_X, SIZE_Y);






    public ThaumonomiconGui() {
        setRootPanel(root);
    }



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
