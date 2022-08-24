package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.data.BasicsResearches;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Gui;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Panel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Tab;

import java.util.ArrayList;
import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Tabs.*;

public class ThaumonomiconGui extends LightweightGuiDescription {



    private static final Integer RESEARCH_X = 256;
    private static final Integer RESEARCH_Y = RESEARCH_X - TAB_SIZE;

    private static final Integer SIZE_X = TAB_SIZE + RESEARCH_X;
    private static final Integer SIZE_Y = RESEARCH_Y;

    private static final List<Tab> TABS = new ArrayList<>();
    static {
        Tabs.register();
        BasicsResearches.register();
        TABS.add(BASICS);
        TABS.add(THAUMATURGY);
        TABS.add(ALCHEMY);
        TABS.add(ARTIFICE);
        TABS.add(GOLEMANCY);
        TABS.add(ELDRITCH);
        reposTabs();
    }

    private static final Panel RESEARCH = new Panel(TAB_SIZE, 0, RESEARCH_X, RESEARCH_Y);
    private static final Gui ROOT = new Gui(RESEARCH, TABS, SIZE_X, SIZE_Y);






    public ThaumonomiconGui() {
        setRootPanel(ROOT);
    }


    public static Panel getResearchPanel() {
        return RESEARCH;
    }

    public static List<Tab> getTabs() {
        return ROOT.getTabs();
    }

    public static void setTabs(List<Tab> tabs) {
        ROOT.setTabs(tabs);
        reposTabs();
    }

    public static void addTab(Tab tab) {
        ROOT.addTab(tab);
        reposTabs();
    }

    public static void reposTabs() {
        int y = 0;
        for (Tab tab: TABS) {
            tab.setPosY(y);
            y += tab.getSize();
        }
    }


}
