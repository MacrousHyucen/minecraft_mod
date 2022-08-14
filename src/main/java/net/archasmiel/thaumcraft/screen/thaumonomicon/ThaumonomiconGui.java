package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;

import java.util.Arrays;
import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.GuiUtil.eldritch_back;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.GuiUtil.normal_back;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.Icons.*;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.Icons.rt_basics;

public class ThaumonomiconGui extends LightweightGuiDescription {

    private static final String TRANSLATE_PATH = "gui.thaumcraft.";
    private static final Integer TAB_SIZE = 26;

    private static final Integer RESEARCH_X = 256;
    private static final Integer RESEARCH_Y = RESEARCH_X - TAB_SIZE;

    private static final Integer SIZE_X = TAB_SIZE + RESEARCH_X;
    private static final Integer SIZE_Y = RESEARCH_Y;

    public static final ResearchGui ROOT = new ResearchGui(SIZE_X, SIZE_Y);

    private static List<ResearchTab> tabs = Arrays.asList(
            new ResearchTab(normal_back, TAB_SIZE, rt_basics, TRANSLATE_PATH + "basics_tab"),
            new ResearchTab(normal_back, TAB_SIZE, rt_thaumaturgy, TRANSLATE_PATH + "thaumaturgy_tab"),
            new ResearchTab(normal_back, TAB_SIZE, rt_alchemy, TRANSLATE_PATH + "alchemy_tab"),
            new ResearchTab(normal_back, TAB_SIZE, rt_artifice, TRANSLATE_PATH + "artifice_tab"),
            new ResearchTab(normal_back, TAB_SIZE, rt_golemancy, TRANSLATE_PATH + "golemancy_tab"),
            new ResearchTab(eldritch_back, TAB_SIZE, rt_eldritch, TRANSLATE_PATH + "eldritch_tab")
    );





    public ThaumonomiconGui() {
        setRootPanel(ROOT);

        ROOT.setTabs(tabs);
        ROOT.setResearchPanel(new ResearchPanel(RESEARCH_X, RESEARCH_Y, tabs.get(0).getBackground()), TAB_SIZE, 0);
    }



    public static List<ResearchTab> getTabs() {
        return tabs;
    }

    public static void setTabs(List<ResearchTab> origTabs) {
        tabs = origTabs;
    }

    public static void addTab(ResearchTab tab) {
        tabs.add(tab);
    }

}
