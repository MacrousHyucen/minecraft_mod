package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.Tab;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.eldritch_back;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.normal_back;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Icons.*;

public class Tabs {

    public static final String TRANSLATE_PATH = "gui.thaumcraft.";
    public static final Integer TAB_SIZE = 26;

    public static final Tab BASICS       =  new Tab("basics",       normal_back,    TAB_SIZE, RT_BASICS);
    static {
        BASICS.setState(true);
    }

    public static final Tab THAUMATURGY  =  new Tab("thaumaturgy",  normal_back,    TAB_SIZE, RT_THAUMATURGY);
    public static final Tab ALCHEMY      =  new Tab("alchemy",      normal_back,    TAB_SIZE, RT_ALCHEMY);
    public static final Tab ARTIFICE     =  new Tab("artifice",     normal_back,    TAB_SIZE, RT_ARTIFICE);
    public static final Tab GOLEMANCY    =  new Tab("golemancy",    normal_back,    TAB_SIZE, RT_GOLEMANCY);
    public static final Tab ELDRITCH     =  new Tab("eldritch",     eldritch_back,  TAB_SIZE, RT_ELDRITCH);



    private Tabs() {

    }
}
