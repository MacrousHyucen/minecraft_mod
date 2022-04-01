package net.archasmiel.thaumcraft.gui.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;

import java.util.Arrays;
import java.util.List;

import static net.archasmiel.thaumcraft.gui.Icons.*;
import static net.archasmiel.thaumcraft.gui.Icons.rt_basics;

public class ThaumonomiconGui extends LightweightGuiDescription {

    private static final Integer tabSize = 26;
    private static final Integer researchesX = 256, researchesY = 230;
    private static final Integer sizeX = tabSize + researchesX, sizeY = 230;

    public static final ResearchGui root = new ResearchGui(sizeX, sizeY);

    private final ResearchPanel research = new ResearchPanel(researchesX, researchesY);
    List<ResearchTab> origTabs = Arrays.asList(
            new ResearchTab(tabSize, rt_basics, "thaumcraft.gui.basics_tab"),
            new ResearchTab(tabSize, rt_thaumaturgy, "thaumcraft.gui.thaumaturgy_tab"),
            new ResearchTab(tabSize, rt_alchemy, "thaumcraft.gui.alchemy_tab"),
            new ResearchTab(tabSize, rt_artifice, "thaumcraft.gui.artifice_tab"),
            new ResearchTab(tabSize, rt_golemancy, "thaumcraft.gui.golemancy_tab"),
            new ResearchTab(tabSize, rt_eldritch, "thaumcraft.gui.eldritch_tab")
    );

    public ThaumonomiconGui() {

        root.setSize(sizeX, sizeY);
        setRootPanel(root);

        origTabs.get(0).setActive(true);
        root.setTabs(origTabs);
        root.setResearchPanel(research, tabSize, 0, researchesX, researchesY);

    }




}
