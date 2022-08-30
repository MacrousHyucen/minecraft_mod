package net.archasmiel.thaumcraft.screen.thaumonomicon.parts;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Identified;
import net.archasmiel.thaumcraft.util.collections.ResearchGraph;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility;
import net.archasmiel.thaumcraft.sounds.Sounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs.TRANSLATE_PATH;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.*;

public class Tab extends WButton implements Identified {

    public static class Builder {

        private final Tab tab;

        public Builder() {
            tab = new Tab();
            tab.posX = 0;
            tab.posY = 0;
            tab.backX = 0;
            tab.backY = 0;
            tab.state = false;
            tab.flipped = false;
        }


        public Builder id(String id) {
            tab.id = id;
            return this;
        }


        // only-thaumcraft builder method
        public Builder name() {
            if (tab.id == null || tab.id.equals(""))
                throw new IllegalStateException("No id found for tab name");
            tab.name = new TranslatableText(TRANSLATE_PATH + tab.id + "_tab");
            return this;
        }

        public Builder name(TranslatableText name) {
            tab.name = name;
            return this;
        }

        public Builder name(String key) {
            tab.name = new TranslatableText(key);
            return this;
        }



        public Builder icon(Texture icon) {
            tab.icon = icon;
            return this;
        }

        public Builder pos(int posX, int posY) {
            tab.posX = posX;
            tab.posY = posY;
            return this;
        }

        public Builder size(int size) {
            tab.size = size;
            return this;
        }

        public Builder background(Texture background) {
            tab.background = background;
            return this;
        }


        public Builder backPos(float backX, float backY) {
            tab.backX = backX;
            tab.backY = backY;
            return this;
        }

        public Builder flipped() {
            tab.flipped = true;
            return this;
        }

        public Builder active() {
            tab.state = true;
            return this;
        }



        public Builder researchMap(ResearchGraph researchMap) {
            tab.researchMap = researchMap;
            return this;
        }

        public Builder researchMap() {
            tab.researchMap = new ResearchGraph();
            return this;
        }



        public Tab build() {
            if (tab.id == null || tab.id.equals(""))
                throw new IllegalStateException("No id for tab");
            if (tab.name == null)
                throw new IllegalStateException("No name for tab");
            if (tab.icon == null)
                throw new IllegalStateException("No icon for tab");
            if (tab.size == 0)
                throw new IllegalStateException("No size for tab");
            if (tab.background == null)
                throw new IllegalStateException("No background for tab");

            return tab;
        }


    }


    private String id;
    private TranslatableText name;
    private Texture icon;

    private Integer posX;
    private Integer posY;

    private Integer size;

    private ResearchGraph researchMap;

    private float backX;
    private float backY;

    private Texture background;
    private boolean state;
    private boolean flipped;




    private Tab() {

    }





    @Override
    public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
        if (getState()) {
            Utility.precisiveTexturedRect(matrices, x, y, size, size, RESEARCH_TAB_ACTIVE, DEF_COLOR);
            Utility.precisiveTexturedRect(matrices, x + (float) size/4, y + (float) size/8, (float) size*3/4, (float) size*3/4, icon, DEF_COLOR);
            return;
        }

        Utility.precisiveTexturedRect(matrices, x, y, size, size, RESEARCH_TAB_INACTIVE, DEF_COLOR);
        Utility.precisiveTexturedRect(matrices, x + (float) size/2, y + (float) size/8, (float) size*3/4, (float) size*3/4, icon, DEF_COLOR);
        if (!isPointOnTab(mouseX, mouseY))
            Utility.precisiveTexturedRect(matrices, x, y, size, size, RESEARCH_TAB_SHADOW, DEF_COLOR);
    }

    @Override
    public void renderTooltip(MatrixStack matrices, int x, int y, int tX, int tY) {
        ScreenDrawing.drawString(matrices, name.asOrderedText(), x + tX + 8, y + tY, DEF_COLOR);
    }

    @Override
    public InputResult onClick(int x, int y, int button) {
        if (button == 0 && this.getParent() instanceof Gui gui && !id.equals(gui.getPanel().getCurrentTab().getId())) {
            gui.getPanel().getCurrentTab().setState(false);
            gui.getPanel().setCurrentTab(this);
            gui.getPanel().getCurrentTab().setState(true);

            MinecraftClient.getInstance().getSoundManager()
                    .play(PositionedSoundInstance.master(Sounds.PAGE_FLIP, 1.0F));

            return InputResult.PROCESSED;
        }

        return InputResult.IGNORED;
    }

    @Override
    public boolean canResize() {
        return true;
    }

    @Override
    public boolean canFocus() {
        return true;
    }






    public boolean isPointOnTab(Integer x, Integer y) {
        return (x > posX && x < posX+size) && (y > posY && y < posY+size);
    }

    public Texture cutBackground(int sizeX, int sizeY) {
        float x1 = backX/sizeX/2;
        float y1 = backY/sizeY/2;
        float x2 = x1 + 0.5f;
        float y2 = y1 + 0.5f;
        return background.withUv(x1, y1, x2, y2);
    }




    @Override
    public String getId() {
        return id;
    }

    public Integer getPosX() {
        return posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public Integer getSize() {
        return size;
    }

    public boolean getState() {
        return state;
    }

    public float getBackX() {
        return backX;
    }

    public float getBackY() {
        return backY;
    }

    public Texture getBackground() {
        return background;
    }

    public ResearchGraph getResearchMap() {
        return researchMap;
    }



    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setBackX(float backX) {
        this.backX = backX;
    }

    public void setBackY(float backY) {
        this.backY = backY;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
