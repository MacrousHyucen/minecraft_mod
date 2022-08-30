package net.archasmiel.thaumcraft.screen.thaumonomicon.data;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.ResearchBox;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.ForbiddenLevel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic.Research;
import net.archasmiel.thaumcraft.util.collections.ResearchGraph;

import java.util.ArrayList;
import java.util.List;


public class BasicsResearches {

    // map
    private static final List<ResearchBox> ZERO_DEPENDENCIES = new ArrayList<>();
    public static final ResearchGraph BASICS_RESEARCHES = new ResearchGraph();




    // researches
    private static final ResearchBox ASPECTS_OF_MAGIC = new ResearchBox.Builder()
            .research(new Research.Builder()
                    .id("aspects_of_magic").name().description()
                    .icon(Utility.loadTexture(Textures.RESEARCH_PATH + "r_aspects.png"))
                    .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE).build())
            .pos(242, 194).size()
            .form(Textures.RESEARCH_CIRCLE).noBounds().build();

    private static final ResearchBox AURAS_AND_NODES = new ResearchBox.Builder()
            .research(new Research.Builder()
                    .id("auras_and_nodes").name().description()
                    .icon(Utility.loadTexture(Textures.RESEARCH_PATH + "r_nodes.png"))
                    .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE).build())
            .pos(194, 194).size()
            .form(Textures.RESEARCH_CIRCLE).noBounds().build();

    private static final ResearchBox WARP_FLUX_THINGS = new ResearchBox.Builder()
            .research(new Research.Builder()
                    .id("warp_flux_things").name().description()
                    .icon(Utility.loadTexture(Textures.RESEARCH_PATH + "r_warp.png"))
                    .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE).build())
            .pos(242, 242).size()
            .form(Textures.RESEARCH_CIRCLE).noBounds().build();

    private static final ResearchBox CRIMSON_CULT = new ResearchBox.Builder()
            .research(new Research.Builder()
                    .id("crimson_cult").name().description()
                    .icon(Utility.loadTexture(Textures.ITEM_PATH + "crimson_rites.png"))
                    .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.MODERATE).build())
            .pos(242, 290).size()
            .form(Textures.RESEARCH_CIRCLE).bounds(Textures.RESEARCH_FLOWER).build();



    static {
        BASICS_RESEARCHES.put(ASPECTS_OF_MAGIC, ZERO_DEPENDENCIES);
        BASICS_RESEARCHES.put(AURAS_AND_NODES, List.of());
        BASICS_RESEARCHES.put(WARP_FLUX_THINGS, ZERO_DEPENDENCIES);
        BASICS_RESEARCHES.put(CRIMSON_CULT, ZERO_DEPENDENCIES);
    }



    private BasicsResearches() {

    }
}
