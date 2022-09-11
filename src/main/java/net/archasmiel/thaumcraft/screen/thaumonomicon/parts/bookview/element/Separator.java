package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.element;

import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.DrawUtility;
import net.minecraft.client.util.math.MatrixStack;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.BOOKVIEW_SEPARATOR;
import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.DEF_COLOR;

public class Separator extends BookViewElement {

	public static final int DEF_WIDTH = 88;
	public static final int DEF_HEIGHT = 4;

	public Separator(int x, int y) {
		super(x, y, DEF_WIDTH, DEF_HEIGHT);
	}

	public Separator(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		DrawUtility.precisiveTexturedRect(
			matrices,
			x+this.x, y+this.y,
			width, height,
			BOOKVIEW_SEPARATOR, DEF_COLOR
		);
	}
}
