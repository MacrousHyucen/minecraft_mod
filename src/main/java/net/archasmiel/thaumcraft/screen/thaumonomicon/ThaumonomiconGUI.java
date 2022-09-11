package net.archasmiel.thaumcraft.screen.thaumonomicon;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.BookGUI;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Panel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.ResearchGUI;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Tab;

import java.util.List;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs.TAB_SIZE;

public class ThaumonomiconGUI extends LightweightGuiDescription {

    private static final Integer SIZE_X = 256 + 2*TAB_SIZE + 2*TAB_SIZE;
    private static final Integer SIZE_Y = 230;

    private final BookGUI book;
    private final ResearchGUI researchGUI;



    public ThaumonomiconGUI() {
        book = new BookGUI(SIZE_X, SIZE_Y);
        Panel researchPanel = new Panel(TAB_SIZE, 0, SIZE_X - 2 * TAB_SIZE, SIZE_Y);
        researchGUI = new ResearchGUI(researchPanel, Tabs.getTabs(), SIZE_X, SIZE_Y);

        researchPanel.setHost(this);
        book.setHost(this);

        setRootPanel(researchGUI);
    }



    public List<Tab> getTabs() {
        return researchGUI.getTabs();
    }

    public BookGUI getBook() {
        return book;
    }

    public ResearchGUI getResearchGUI() {
        return researchGUI;
    }

    public void setTabs(List<Tab> tabs) {
        researchGUI.setTabs(tabs);
    }

    public void addTab(Tab tab) {
        researchGUI.addTab(tab);
    }



}
