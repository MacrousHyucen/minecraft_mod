package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.util.Identifier;

public class Utility {

    private Utility() {

    }

    public static Texture cutTexture(Texture texture, float x, float y, float dx, float dy, int sizeX, int sizeY) {
        return texture.withUv(
                x / sizeX,
                y / sizeY,
                (x + dx) / sizeX,
                (y + dy) / sizeY
        );
    }

    public static Texture loadTexture(String modId, String path) {
        return new Texture(new Identifier(modId, path));
    }
}
