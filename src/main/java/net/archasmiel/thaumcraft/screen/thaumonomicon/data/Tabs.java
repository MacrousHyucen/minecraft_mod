package net.archasmiel.thaumcraft.screen.thaumonomicon.data;

import net.archasmiel.thaumcraft.util.collections.Registry;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Tab;

import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.*;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.ELDRITCH_BACKGROUND;

public class Tabs {

    public static final String TRANSLATE_PATH = "gui.thaumcraft.";
    public static final Integer TAB_SIZE = 24;

    private static final Registry<Tab> TAB_REGISTRY = new Registry<>();

    public static final String BASICS_ID = "basics";
    public static final String THAUMATURGY_ID = "thaumaturgy";
    public static final String ALCHEMY_ID = "alchemy";
    public static final String ARTIFICE_ID = "artifice";
    public static final String GOLEMANCY_ID = "golemancy";
    public static final String ELDRITCH_ID = "eldritch";

    private Tabs() {

    }

    private static final Tab basics = new Tab.Builder()
            .id(BASICS_ID).name()
            .icon(RT_BASICS).background(NORMAL_BACKGROUND)
            .size().researchMap(BasicsResearches.BASICS_RESEARCHES).active().build();

    private static final Tab thaumaturgy = new Tab.Builder()
            .id(THAUMATURGY_ID).name()
            .icon(RT_THAUMATURGY).background(NORMAL_BACKGROUND)
            .size().researchMap().build();

    private static final Tab alchemy = new Tab.Builder()
            .id(ALCHEMY_ID).name()
            .icon(RT_ALCHEMY).background(NORMAL_BACKGROUND)
            .size().researchMap().build();

    private static final Tab artifice = new Tab.Builder()
            .id(ARTIFICE_ID).name()
            .icon(RT_ARTIFICE).background(NORMAL_BACKGROUND)
            .size().researchMap().build();

    private static final Tab golemancy = new Tab.Builder()
            .id(GOLEMANCY_ID).name()
            .icon(RT_GOLEMANCY).background(NORMAL_BACKGROUND)
            .size().researchMap().build();

    private static final Tab eldritch = new Tab.Builder()
            .id(ELDRITCH_ID).name()
            .icon(RT_ELDRITCH).background(ELDRITCH_BACKGROUND)
            .size().researchMap().build();

    static {
        addTabs(basics, thaumaturgy, alchemy, artifice, golemancy, eldritch);
        reposTabs();
    }



    public static Tab getVanillaTabByName(String name) {
        return switch (name) {
            case BASICS_ID -> basics;
            case THAUMATURGY_ID -> thaumaturgy;
            case ALCHEMY_ID -> alchemy;
            case ARTIFICE_ID -> artifice;
            case GOLEMANCY_ID -> golemancy;
            case ELDRITCH_ID -> eldritch;

            default -> throw new IllegalStateException("Invalid vanilla tab name");
        };
    }

    public static void reposTabs() {
        int y = 0;
        for (Tab tab: TAB_REGISTRY.valueList()) {
            tab.setLocation(tab.getX(), y);
            y += tab.getHeight();
        }
    }



    public static void addTab(Tab tab) {
        TAB_REGISTRY.register(tab);
    }

    public static void addTabs(Tab... tabs) {
        TAB_REGISTRY.registerAll(tabs);
    }

    public static void addTabs(List<Tab> tabs) {
        TAB_REGISTRY.registerAll(tabs);
    }

    public static List<Tab> getTabList() {
        return TAB_REGISTRY.valueList();
    }

}
