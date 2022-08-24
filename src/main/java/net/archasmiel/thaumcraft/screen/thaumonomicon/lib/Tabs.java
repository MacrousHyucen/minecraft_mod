package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Tab;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.data.BasicsResearches;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.*;

public class Tabs {

    public static final String TRANSLATE_PATH = "gui.thaumcraft.";
    public static final Integer TAB_SIZE = 24;

    public static Tab BASICS;
    public static Tab THAUMATURGY;
    public static Tab ALCHEMY;
    public static Tab ARTIFICE;
    public static Tab GOLEMANCY;
    public static Tab ELDRITCH;



    private Tabs() {

    }

    public static void register() {
        BASICS = new Tab.Builder()
                .id("basics").name()
                .icon(RT_BASICS).background(NORMAL_BACKGROUND)
                .size(TAB_SIZE).researchMap(BasicsResearches.BASICS_RESEARCH_MAP).active().build();

        THAUMATURGY = new Tab.Builder()
                .id("thaumaturgy").name()
                .icon(RT_THAUMATURGY).background(NORMAL_BACKGROUND)
                .size(TAB_SIZE).researchMap().build();

        ALCHEMY = new Tab.Builder()
                .id("alchemy").name()
                .icon(RT_ALCHEMY).background(NORMAL_BACKGROUND)
                .size(TAB_SIZE).researchMap().build();

        ARTIFICE = new Tab.Builder()
                .id("artifice").name()
                .icon(RT_ARTIFICE).background(NORMAL_BACKGROUND)
                .size(TAB_SIZE).researchMap().build();

        GOLEMANCY = new Tab.Builder()
                .id("golemancy").name()
                .icon(RT_GOLEMANCY).background(NORMAL_BACKGROUND)
                .size(TAB_SIZE).researchMap().build();

        ELDRITCH = new Tab.Builder()
                .id("eldritch").name()
                .icon(RT_ELDRITCH).background(ELDRITCH_BACKGROUND)
                .size(TAB_SIZE).researchMap().build();

    }
}
