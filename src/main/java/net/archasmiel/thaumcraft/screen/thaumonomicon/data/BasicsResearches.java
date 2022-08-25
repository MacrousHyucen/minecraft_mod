package net.archasmiel.thaumcraft.screen.thaumonomicon.data;

import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ForbiddenLevel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.Research;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ResearchBox;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.TabResearchMap;

import java.util.ArrayList;
import java.util.List;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs.TAB_SIZE;



public class BasicsResearches {

    // map
    private static final List<ResearchBox> ZERO_DEPENDENCIES = new ArrayList<>();
    public static final TabResearchMap BASICS_RESEARCHES = new TabResearchMap();



    // researches
    private static final Research ASPECTS_OF_MAGIC = new Research.Builder()
            .id("aspects_of_magic").name().description()
            .icon(Utility.loadTexture(MOD_ID, Textures.RESEARCH_PATH + "r_aspects.png"))
            .author("Archasmiel").forbiddenLevel(ForbiddenLevel.SAFE).build();



    // boxes
    private static final ResearchBox BOX_ASPECTS_OF_MAGIC = new ResearchBox.Builder()
            .research(ASPECTS_OF_MAGIC)
            .pos(242, 242).size(TAB_SIZE)
            .form(Textures.RESEARCH_CIRCLE).noBounds().build();



    static {
        BASICS_RESEARCHES.put(BOX_ASPECTS_OF_MAGIC, ZERO_DEPENDENCIES);
    }



    private BasicsResearches() {

    }
}
