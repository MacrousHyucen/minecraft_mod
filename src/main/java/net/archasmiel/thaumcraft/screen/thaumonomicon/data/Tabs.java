package net.archasmiel.thaumcraft.screen.thaumonomicon.data;

import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Tab;
import net.archasmiel.thaumcraft.util.collections.Registry;

import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.*;

public class Tabs {

    public static final String TRANSLATE_PATH = "gui.thaumcraft.";
    public static final Integer TAB_SIZE = 24;

    public static final Registry<Tab> TAB_REGISTRY = new Registry<>();

    public static final String BASICS_ID = "basics";
    public static final String THAUMATURGY_ID = "thaumaturgy";
    public static final String ALCHEMY_ID = "alchemy";
    public static final String ARTIFICE_ID = "artifice";
    public static final String GOLEMANCY_ID = "golemancy";
    public static final String ELDRITCH_ID = "eldritch";

    public static final Tab BASICS = new Tab.Builder()
        .id(BASICS_ID).name()
        .icon(RT_BASICS).background(NORMAL_BACKGROUND)
        .size().researchMap(BasicsResearches.BASICS_RESEARCHES).build();

    public static final Tab THAUMATURGY = new Tab.Builder()
        .id(THAUMATURGY_ID).name()
        .icon(RT_THAUMATURGY).background(NORMAL_BACKGROUND)
        .size().researchMap().build();

    public static final Tab ALCHEMY = new Tab.Builder()
        .id(ALCHEMY_ID).name()
        .icon(RT_ALCHEMY).background(NORMAL_BACKGROUND)
        .size().researchMap().build();

    public static final Tab ARTIFICE = new Tab.Builder()
        .id(ARTIFICE_ID).name()
        .icon(RT_ARTIFICE).background(NORMAL_BACKGROUND)
        .size().researchMap().build();

    public static final Tab GOLEMANCY = new Tab.Builder()
        .id(GOLEMANCY_ID).name()
        .icon(RT_GOLEMANCY).background(NORMAL_BACKGROUND)
        .size().researchMap().build();

    public static final Tab ELDRITCH = new Tab.Builder()
        .id(ELDRITCH_ID).name()
        .icon(RT_ELDRITCH).background(ELDRITCH_BACKGROUND)
        .size().researchMap().build();

    static {
        TAB_REGISTRY.registerAll(BASICS, THAUMATURGY, ALCHEMY, ARTIFICE, GOLEMANCY, ELDRITCH);
        posTabs(TAB_REGISTRY.valueList());
    }



    private Tabs() {
    }



    public static void addTab(Tab tab) {
        TAB_REGISTRY.register(tab);
        posTabs(TAB_REGISTRY.valueList());
    }

    public static void addTabs(Tab... tabs) {
        TAB_REGISTRY.registerAll(tabs);
        posTabs(TAB_REGISTRY.valueList());
    }

    public static void addTabs(List<Tab> tabs) {
        TAB_REGISTRY.registerAll(tabs);
        posTabs(TAB_REGISTRY.valueList());
    }



    public static void posTabs(List<Tab> tabs) {
        int y = 0;
        for (Tab tab: tabs) {
            tab.setLocation(tab.getX(), y);
            y += tab.getHeight();
        }
    }

    public static void posTabs(Tab... tabs) {
        int y = 0;
        for (Tab tab: tabs) {
            tab.setLocation(tab.getX(), y);
            y += tab.getHeight();
        }
    }



    public static Tab getTab(String id) {
        return TAB_REGISTRY.getById(id);
    }

    public static List<Tab> getTabs() {
        return TAB_REGISTRY.valueList();
    }

    public static List<String> getTabIDs() {
        return TAB_REGISTRY.keyList();
    }

}
