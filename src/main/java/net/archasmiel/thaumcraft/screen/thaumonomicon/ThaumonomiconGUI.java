package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.BookGUI;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Panel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.ResearchGUI;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Tab;

import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs.*;

public class ThaumonomiconGUI extends LightweightGuiDescription {

    private static final Integer SIZE_X = 256 + 2*TAB_SIZE + 2*TAB_SIZE;
    private static final Integer SIZE_Y = 230;

    private final BookGUI book =
        new BookGUI(SIZE_X, SIZE_Y);
    private final Panel researchPanel =
        new Panel(TAB_SIZE, 0, SIZE_X - 2*TAB_SIZE, SIZE_Y);
    private final ResearchGUI root =
        new ResearchGUI(researchPanel, Tabs.buildTabs(), SIZE_X, SIZE_Y);



    public ThaumonomiconGUI() {
        researchPanel.setHost(this);
        book.setHost(this);

        setRootPanel(root);
    }



    public List<Tab> getTabs() {
        return root.getTabs();
    }

    public BookGUI getBook() {
        return book;
    }

    public ResearchGUI getResearchGUI() {
        return root;
    }

    public void setTabs(List<Tab> tabs) {
        root.setTabs(tabs);
    }

    public void addTab(Tab tab) {
        root.addTab(tab);
    }

}
