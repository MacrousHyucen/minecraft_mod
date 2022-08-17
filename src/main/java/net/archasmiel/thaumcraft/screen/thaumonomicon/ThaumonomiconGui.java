package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;

import java.util.ArrayList;
import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.*;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Icons.*;

public class ThaumonomiconGui extends LightweightGuiDescription {

    private static final String TRANSLATE_PATH = "gui.thaumcraft.";
    private static final Integer TAB_SIZE = 26;

    private static final Integer RESEARCH_X = 256;
    private static final Integer RESEARCH_Y = RESEARCH_X - TAB_SIZE;

    private static final Integer SIZE_X = TAB_SIZE + RESEARCH_X;
    private static final Integer SIZE_Y = RESEARCH_Y;

    private static final List<Tab> TABS = makeBasicTabs();
    private static final Panel RESEARCH = new Panel(TAB_SIZE, 0, RESEARCH_X, RESEARCH_Y);
    private static final Gui ROOT = new Gui(RESEARCH, TABS, SIZE_X, SIZE_Y);






    public ThaumonomiconGui() {
        setRootPanel(ROOT);
    }



    public static List<Tab> getTabs() {
        return ROOT.getTabs();
    }

    public static void setTabs(List<Tab> tabs) {
        ROOT.setTabs(tabs);
    }

    public static void addTab(Tab tab) {
        ROOT.addTab(tab);
    }

    public static List<Tab> makeBasicTabs() {
        List<Tab> tabs = new ArrayList<>();

        tabs.add(new Tab(normal_back, 0, 0, TAB_SIZE, rt_basics, TRANSLATE_PATH + "basics_tab"));
        tabs.add(new Tab(normal_back, 0, 0, TAB_SIZE, rt_thaumaturgy, TRANSLATE_PATH + "thaumaturgy_tab"));
        tabs.add(new Tab(normal_back, 0, 0, TAB_SIZE, rt_alchemy, TRANSLATE_PATH + "alchemy_tab"));
        tabs.add(new Tab(normal_back, 0, 0, TAB_SIZE, rt_artifice, TRANSLATE_PATH + "artifice_tab"));
        tabs.add(new Tab(normal_back, 0, 0, TAB_SIZE, rt_golemancy, TRANSLATE_PATH + "golemancy_tab"));
        tabs.add(new Tab(eldritch_back, 0, 0, TAB_SIZE, rt_eldritch, TRANSLATE_PATH + "eldritch_tab"));

        int y = 0;
        for (Tab tab: tabs) {
            tab.setPosY(y);
            y += tab.getSize();
        }

        tabs.get(0).setState(true);
        return tabs;
    }

}
