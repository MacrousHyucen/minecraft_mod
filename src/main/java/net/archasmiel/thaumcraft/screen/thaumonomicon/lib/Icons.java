package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;

public class Icons {

    private Icons() {

    }

    public static final String RESEARCH_PATH = "textures/other/research/";

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




    public static Texture loadTexture(String modId, String path) {
        return new Texture(new Identifier(modId, path));
    }
}
