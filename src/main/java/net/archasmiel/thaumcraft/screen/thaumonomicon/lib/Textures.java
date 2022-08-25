package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility.cutTexture;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility.loadTexture;

public class Textures {

    private Textures() {

    }

    public static final Integer DEF_COLOR = 0xFFFFFFFF;
    public static final String RESEARCH_PATH = "textures/other/research/";
    public static final String ITEM_PATH = "textures/item/";


    // backgrounds for book
    public static final Texture CONTENTS =
            new Texture(new Identifier(Thaumcraft.MOD_ID, "textures/gui/thaumonomicon/research.png"));
    public static final Texture NORMAL_BACKGROUND =
            new Texture(new Identifier(Thaumcraft.MOD_ID, "textures/gui/thaumonomicon/researchback.png"));
    public static final Texture ELDRITCH_BACKGROUND =
            new Texture(new Identifier(Thaumcraft.MOD_ID, "textures/gui/thaumonomicon/researchback_eldritch.png"));

    // research border
    public static final Texture RESEARCH_BORDER =
            cutTexture(CONTENTS, 0, 0, 256, 230, 256, 256);

    // tabs
    public static final Texture RESEARCH_TAB_ACTIVE =
            cutTexture(CONTENTS, 152, 232, 24, 24, 256, 256);
    public static final Texture RESEARCH_TAB_INACTIVE =
            cutTexture(CONTENTS, 176, 232, 24, 24, 256, 256);
    public static final Texture RESEARCH_TAB_SHADOW =
            cutTexture(CONTENTS, 200, 232, 24, 24, 256, 256);

    // research forms
    public static final Texture RESEARCH_SQUARE =
            cutTexture(CONTENTS, 0, 230, 26, 26, 256, 256);
    public static final Texture RESEARCH_CIRCLE =
            cutTexture(CONTENTS, 54, 230, 26, 26, 256, 256);
    public static final Texture RESEARCH_HEX =
            cutTexture(CONTENTS, 110, 230, 26, 26, 256, 256);
    public static final Texture RESEARCH_FLOWER =
            cutTexture(CONTENTS, 26, 230, 26, 26, 256, 256);

    // weird yellow textures
    public static final Texture RESEARCH_YELLOW_SQUARE =
            cutTexture(CONTENTS, 86, 230, 26, 26, 256, 256);
    public static final Texture RESEARCH_YELLOW_HEX =
            cutTexture(CONTENTS, 230, 230, 26, 26, 256, 256);

    // Research tabs in original sort
    public static final Texture RT_BASICS =
            loadTexture(MOD_ID, RESEARCH_PATH + "tab/r_basics.png");
    public static final Texture RT_THAUMATURGY =
            loadTexture(MOD_ID, RESEARCH_PATH + "tab/r_thaumaturgy.png");
    public static final Texture RT_ALCHEMY =
            loadTexture(MOD_ID, RESEARCH_PATH + "tab/r_alchemy.png");
    public static final Texture RT_ARTIFICE =
            loadTexture(MOD_ID, RESEARCH_PATH + "tab/r_artifice.png");
    public static final Texture RT_GOLEMANCY =
            loadTexture(MOD_ID, RESEARCH_PATH + "tab/r_golemancy.png");
    public static final Texture RT_ELDRITCH =
            loadTexture(MOD_ID, RESEARCH_PATH + "tab/r_eldritch.png");

}
