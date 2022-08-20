package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import net.archasmiel.thaumcraft.screen.thaumonomicon.Tab;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.eldritch_back;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil.normal_back;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Icons.*;

public class Tabs {

    public static final String TRANSLATE_PATH = "gui.thaumcraft.";
    public static final Integer TAB_SIZE = 26;

    public static final Tab BASICS       =  new Tab("basics",       normal_back,    TAB_SIZE,  rt_basics);
    static {
        BASICS.setState(true);
    }

    public static final Tab THAUMATURGY  =  new Tab("thaumaturgy",  normal_back,    TAB_SIZE,  rt_thaumaturgy);
    public static final Tab ALCHEMY      =  new Tab("alchemy",      normal_back,    TAB_SIZE,  rt_alchemy);
    public static final Tab ARTIFICE     =  new Tab("artifice",     normal_back,    TAB_SIZE,  rt_artifice);
    public static final Tab GOLEMANCY    =  new Tab("golemancy",    normal_back,    TAB_SIZE,  rt_golemancy);
    public static final Tab ELDRITCH     =  new Tab("eldritch",     eldritch_back,  TAB_SIZE,  rt_eldritch);



    private Tabs() {

    }
}
