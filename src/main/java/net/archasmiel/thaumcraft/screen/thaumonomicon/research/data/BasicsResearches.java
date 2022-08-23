package net.archasmiel.thaumcraft.screen.thaumonomicon.research.data;

import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ForbiddenLevel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.Research;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ResearchBox;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;

public class BasicsResearches {


    // researches
    public static final Research ASPECTS_OF_MAGIC =
            new Research.Builder()
                    .tabId(Tabs.BASICS.getId()).id("aspects_of_magic")
                    .name().description()
                    .icon(Utility.loadTexture(MOD_ID, Textures.RESEARCH_PATH + "r_aspects.png"))
                    .author("Archasmiel").forbiddenLevel(ForbiddenLevel.SAFE).build();

    // boxes
    public static final ResearchBox BOX_ASPECTS_OF_MAGIC =
            new ResearchBox.Builder()
                    .research(ASPECTS_OF_MAGIC).pos(24, 24).size(24, 24)
                    .form(Textures.RESEARCH_CIRCLE).noBounds().build();





}
