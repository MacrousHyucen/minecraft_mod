package net.archasmiel.thaumcraft.gui.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;

import java.util.Arrays;
import java.util.List;

import static net.archasmiel.thaumcraft.gui.thaumonomicon.Icons.*;
import static net.archasmiel.thaumcraft.gui.thaumonomicon.Icons.rt_basics;

public class ThaumonomiconGui extends LightweightGuiDescription {

    private static final Integer tabSize = 26;
    private static final Integer researchX = 256, researchY = 230;
    private static final Integer sizeX = tabSize + researchX, sizeY = 230;

    public static final ResearchGui root = new ResearchGui(sizeX, sizeY);

    private final ResearchPanel research = new ResearchPanel(researchX, researchY);
    List<ResearchTab> origTabs = Arrays.asList(
            new ResearchTab(tabSize, rt_basics, "gui.thaumcraft.basics_tab"),
            new ResearchTab(tabSize, rt_thaumaturgy, "gui.thaumcraft.thaumaturgy_tab"),
            new ResearchTab(tabSize, rt_alchemy, "gui.thaumcraft.alchemy_tab"),
            new ResearchTab(tabSize, rt_artifice, "gui.thaumcraft.artifice_tab"),
            new ResearchTab(tabSize, rt_golemancy, "gui.thaumcraft.golemancy_tab"),
            new ResearchTab(tabSize, rt_eldritch, "gui.thaumcraft.eldritch_tab")
    );





    public ThaumonomiconGui() {
        root.setSize(sizeX, sizeY);
        research.setSize(researchX, researchY);
        setRootPanel(root);

        origTabs.get(0).setActive(true);
        root.setTabs(origTabs);
        root.setResearchPanel(research, tabSize, 0);
    }

}
