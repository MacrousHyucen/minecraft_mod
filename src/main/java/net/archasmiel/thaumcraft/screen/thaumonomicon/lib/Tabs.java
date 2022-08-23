package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Tab;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.*;

public class Tabs {

    public static final String TRANSLATE_PATH = "gui.thaumcraft.";
    public static final Integer TAB_SIZE = 26;

    public static final Tab BASICS = new Tab.Builder()
            .id("basics").name()
            .icon(RT_BASICS).background(NORMAL_BACKGROUND)
            .size(TAB_SIZE).active().build();

    public static final Tab THAUMATURGY = new Tab.Builder()
            .id("thaumaturgy").name()
            .icon(RT_THAUMATURGY).background(NORMAL_BACKGROUND)
            .size(TAB_SIZE).build();

    public static final Tab ALCHEMY = new Tab.Builder()
            .id("alchemy").name()
            .icon(RT_ALCHEMY).background(NORMAL_BACKGROUND)
            .size(TAB_SIZE).build();

    public static final Tab ARTIFICE = new Tab.Builder()
            .id("artifice").name()
            .icon(RT_ARTIFICE).background(NORMAL_BACKGROUND)
            .size(TAB_SIZE).build();

    public static final Tab GOLEMANCY = new Tab.Builder()
            .id("golemancy").name()
            .icon(RT_GOLEMANCY).background(NORMAL_BACKGROUND)
            .size(TAB_SIZE).build();

    public static final Tab ELDRITCH = new Tab.Builder()
            .id("eldritch").name()
            .icon(RT_ELDRITCH).background(ELDRITCH_BACKGROUND)
            .size(TAB_SIZE).build();



    private Tabs() {

    }
}
