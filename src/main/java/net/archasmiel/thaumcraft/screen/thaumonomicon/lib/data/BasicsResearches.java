package net.archasmiel.thaumcraft.screen.thaumonomicon.lib.data;

import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ForbiddenLevel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.Research;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ResearchBox;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.TabResearchMap;

import java.util.ArrayList;
import java.util.List;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Tabs.TAB_SIZE;

public class BasicsResearches {

    private BasicsResearches() {

    }


    // researches
    private static Research ASPECTS_OF_MAGIC;

    // boxes
    private static ResearchBox BOX_ASPECTS_OF_MAGIC;

    // map
    private static final List<ResearchBox> ZERO_DEPENDENCIES = new ArrayList<>();
    public static final TabResearchMap BASICS_RESEARCH_MAP = new TabResearchMap();




    public static void register() {
        ASPECTS_OF_MAGIC = new Research.Builder()
                        .tabId(Tabs.BASICS.getId()).id("aspects_of_magic")
                        .name().description()
                        .icon(Utility.loadTexture(MOD_ID, Textures.RESEARCH_PATH + "r_aspects.png"))
                        .author("Archasmiel").forbiddenLevel(ForbiddenLevel.SAFE).build();

        BOX_ASPECTS_OF_MAGIC = new ResearchBox.Builder()
                        .research(ASPECTS_OF_MAGIC).pos(242, 242).size(TAB_SIZE)
                        .form(Textures.RESEARCH_CIRCLE).noBounds().build();

        BASICS_RESEARCH_MAP.put(BOX_ASPECTS_OF_MAGIC, ZERO_DEPENDENCIES);
    }
}
