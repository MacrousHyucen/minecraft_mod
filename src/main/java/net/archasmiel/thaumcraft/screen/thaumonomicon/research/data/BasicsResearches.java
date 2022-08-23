package net.archasmiel.thaumcraft.screen.thaumonomicon.research.data;

import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.GuiUtil;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Icons;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ForbiddenLevel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.Research;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ResearchBox;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;

public class BasicsResearches {



    public static final Research ASPECTS_OF_MAGIC =
            new Research.Builder()
                    .tabId(Tabs.BASICS.id).id("aspects_of_magic")
                    .name().description()
                    .icon(Icons.loadTexture(MOD_ID, Icons.RESEARCH_PATH + "r_aspects.png"))
                    .author("Archasmiel").forbiddenLevel(ForbiddenLevel.SAFE).build();

    public static final ResearchBox BOX_ASPECTS_OF_MAGIC =
            new ResearchBox.Builder()
                    .research(ASPECTS_OF_MAGIC).pos(24, 24).size(24, 24)
                    .form(GuiUtil.research_circle).noBounds().build();





}
