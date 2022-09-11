package net.archasmiel.thaumcraft.screen.thaumonomicon.data;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.DrawUtility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic.BookView;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.element.Separator;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.ResearchBox;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.ForbiddenLevel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.research.Research;
import net.archasmiel.thaumcraft.util.collections.ResearchGraph;

import java.util.ArrayList;
import java.util.List;


public class BasicsResearches {

    // maps
    private static final List<ResearchBox> ZERO_DEPENDENCIES = new ArrayList<>();

    // researches
    private static ResearchBox aspectsOfMagic;
    private static ResearchBox aurasAndNodes;
    private static ResearchBox warpFluxThings;
    private static ResearchBox crimsonCult;

    private static Research aspectsOfMagicResearch;
    private static Research aurasAndNodesResearch;
    private static Research warpFluxThingsResearch;
    private static Research crimsonCultResearch;

    private static BookView aspectsOfMagicView;
    private static BookView aurasAndNodesView;
    private static BookView warpFluxThingsView;
    private static BookView crimsonCultView;

    public BasicsResearches() {

    }

    private static void buildBoxes() {
        aspectsOfMagic = new ResearchBox.Builder()
            .research(aspectsOfMagicResearch).pos(242, 194).size()
            .form(Textures.RESEARCH_CIRCLE).noBounds().build();

        aurasAndNodes = new ResearchBox.Builder()
            .research(aurasAndNodesResearch)
            .pos(194, 194).size()
            .form(Textures.RESEARCH_CIRCLE).noBounds().build();

        warpFluxThings = new ResearchBox.Builder()
            .research(warpFluxThingsResearch)
            .pos(242, 242).size()
            .form(Textures.RESEARCH_CIRCLE).noBounds().build();

        crimsonCult = new ResearchBox.Builder()
            .research(crimsonCultResearch)
            .pos(242, 290).size()
            .form(Textures.RESEARCH_CIRCLE).bounds(Textures.RESEARCH_FLOWER).build();
    }

    private static void buildResearches() {
        aspectsOfMagicResearch = new Research.Builder()
            .id("aspects_of_magic").name().description()
            .icon(DrawUtility.loadTexture(Textures.RESEARCH_PATH + "r_aspects.png"))
            .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE)
            .bookview(aspectsOfMagicView).build();

        aurasAndNodesResearch = new Research.Builder()
            .id("auras_and_nodes").name().description()
            .icon(DrawUtility.loadTexture(Textures.RESEARCH_PATH + "r_nodes.png"))
            .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE)
            .bookview(aurasAndNodesView).build();

        warpFluxThingsResearch = new Research.Builder()
            .id("warp_flux_things").name().description()
            .icon(DrawUtility.loadTexture(Textures.RESEARCH_PATH + "r_warp.png"))
            .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE)
            .bookview(warpFluxThingsView).build();

        crimsonCultResearch = new Research.Builder()
            .id("crimson_cult").name().description()
            .icon(DrawUtility.loadTexture(Textures.ITEM_PATH + "crimson_rites.png"))
            .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.MODERATE)
            .bookview(crimsonCultView).build();
    }

    private static void buildViews() {
        aspectsOfMagicView = new BookView.Builder()
            .add(new Separator(50, 30),
                new Separator(50, 45),
                new Separator(50, 60),
                new Separator(50, 75))
            .add(new Separator(50, 30),
                new Separator(50, 45),
                new Separator(50, 60),
                new Separator(50, 75))
            .build();

        aurasAndNodesView = new BookView.Builder()
            .build();

        warpFluxThingsView = new BookView.Builder()
            .build();

        crimsonCultView = new BookView.Builder()
            .build();
    }

    public static ResearchGraph buildMap() {
        ResearchGraph researches = new ResearchGraph();

        buildViews();
        buildResearches();
        buildBoxes();

        researches.put(aspectsOfMagic, ZERO_DEPENDENCIES);
        researches.put(aurasAndNodes, List.of());
        researches.put(warpFluxThings, ZERO_DEPENDENCIES);
        researches.put(crimsonCult, ZERO_DEPENDENCIES);

        return researches;
    }

}
