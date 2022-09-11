package net.archasmiel.thaumcraft.screen.thaumonomicon.data;

import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Tab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.*;

public class Tabs {

    public static final String TRANSLATE_PATH = "gui.thaumcraft.";
    public static final Integer TAB_SIZE = 24;

    public static final String BASICS_ID = "basics";
    public static final String THAUMATURGY_ID = "thaumaturgy";
    public static final String ALCHEMY_ID = "alchemy";
    public static final String ARTIFICE_ID = "artifice";
    public static final String GOLEMANCY_ID = "golemancy";
    public static final String ELDRITCH_ID = "eldritch";

    public static final Supplier<Tab> BASICS = () -> new Tab.Builder()
        .id(BASICS_ID).name()
        .icon(RT_BASICS).background(NORMAL_BACKGROUND)
        .size().researchMap(BasicsResearches::buildMap).build();

    public static final Supplier<Tab> THAUMATURGY = () -> new Tab.Builder()
        .id(THAUMATURGY_ID).name()
        .icon(RT_THAUMATURGY).background(NORMAL_BACKGROUND)
        .size().researchMap().build();

    public static final Supplier<Tab> ALCHEMY = () -> new Tab.Builder()
        .id(ALCHEMY_ID).name()
        .icon(RT_ALCHEMY).background(NORMAL_BACKGROUND)
        .size().researchMap().build();

    public static final Supplier<Tab> ARTIFICE = () -> new Tab.Builder()
        .id(ARTIFICE_ID).name()
        .icon(RT_ARTIFICE).background(NORMAL_BACKGROUND)
        .size().researchMap().build();

    public static final Supplier<Tab> GOLEMANCY = () -> new Tab.Builder()
        .id(GOLEMANCY_ID).name()
        .icon(RT_GOLEMANCY).background(NORMAL_BACKGROUND)
        .size().researchMap().build();

    public static final Supplier<Tab> ELDRITCH = () -> new Tab.Builder()
        .id(ELDRITCH_ID).name()
        .icon(RT_ELDRITCH).background(ELDRITCH_BACKGROUND)
        .size().researchMap().build();

    private static final List<Supplier<Tab>> TAB_SUPPLIERS = Stream.of(
        BASICS, THAUMATURGY, ALCHEMY, ARTIFICE, GOLEMANCY, ELDRITCH
    ).collect(Collectors.toCollection(ArrayList::new));



    private Tabs() {

    }



    public static void addTab(Supplier<Tab> supplier) {
        TAB_SUPPLIERS.add(supplier);
    }

    public static void addTabs(Supplier<Tab>... suppliers) {
        TAB_SUPPLIERS.addAll(Arrays.asList(suppliers));
    }

    public static void addTabs(List<Supplier<Tab>> suppliers) {
        TAB_SUPPLIERS.addAll(suppliers);
    }





    public static List<Tab> buildTabs() {
        List<Tab> tabs = new ArrayList<>();
        TAB_SUPPLIERS.forEach(e -> tabs.add(e.get()));
        return posTabs(tabs);
    }

    public static List<Tab> posTabs(List<Tab> tabs) {
        int y = 0;
        for (Tab tab: tabs) {
            tab.setLocation(tab.getX(), y);
            y += tab.getHeight();
        }

        return tabs;
    }

}
