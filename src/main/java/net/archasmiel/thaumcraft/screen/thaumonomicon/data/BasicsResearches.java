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
import java.util.function.Supplier;


public class BasicsResearches {

    // map
    private static final List<ResearchBox> ZERO_DEPENDENCIES = new ArrayList<>();
    public static final ResearchGraph BASICS_RESEARCHES = new ResearchGraph();




    // researches
    private static final Supplier<BookView> ASPECTS_OF_MAGIC_VIEW = () -> new BookView.Builder()
        .add(new Separator(50, 30),
            new Separator(50, 45),
            new Separator(50, 60),
            new Separator(50, 75))
        .add(new Separator(50, 30),
            new Separator(50, 45),
            new Separator(50, 60),
            new Separator(50, 75))
        .build();

    private static final ResearchBox ASPECTS_OF_MAGIC = new ResearchBox.Builder()
        .research(new Research.Builder()
            .id("aspects_of_magic").name().description()
            .icon(DrawUtility.loadTexture(Textures.RESEARCH_PATH + "r_aspects.png"))
            .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE)
            .bookview(ASPECTS_OF_MAGIC_VIEW).build())
        .pos(242, 194).size()
        .form(Textures.RESEARCH_CIRCLE).noBounds().build();



    private static final Supplier<BookView> AURAS_AND_NODES_VIEW = () -> new BookView.Builder()
        .build();

    private static final ResearchBox AURAS_AND_NODES = new ResearchBox.Builder()
        .research(new Research.Builder()
            .id("auras_and_nodes").name().description()
            .icon(DrawUtility.loadTexture(Textures.RESEARCH_PATH + "r_nodes.png"))
            .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE)
            .bookview(AURAS_AND_NODES_VIEW).build())
        .pos(194, 194).size()
        .form(Textures.RESEARCH_CIRCLE).noBounds().build();



    private static final Supplier<BookView> WARP_FLUX_THINGS_VIEW = () -> new BookView.Builder()
        .build();

    private static final ResearchBox WARP_FLUX_THINGS = new ResearchBox.Builder()
        .research(new Research.Builder()
            .id("warp_flux_things").name().description()
            .icon(DrawUtility.loadTexture(Textures.RESEARCH_PATH + "r_warp.png"))
            .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.SAFE)
            .bookview(WARP_FLUX_THINGS_VIEW).build())
        .pos(242, 242).size()
        .form(Textures.RESEARCH_CIRCLE).noBounds().build();



    private static final Supplier<BookView> CRIMSON_CULT_VIEW = () -> new BookView.Builder()
        .build();

    private static final ResearchBox CRIMSON_CULT = new ResearchBox.Builder()
        .research(new Research.Builder()
            .id("crimson_cult").name().description()
            .icon(DrawUtility.loadTexture(Textures.ITEM_PATH + "crimson_rites.png"))
            .author(Thaumcraft.AUTHOR).forbiddenLevel(ForbiddenLevel.MODERATE)
            .bookview(CRIMSON_CULT_VIEW).build())
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
