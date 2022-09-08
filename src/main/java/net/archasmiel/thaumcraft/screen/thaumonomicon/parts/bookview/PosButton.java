package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview;

import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic.BookView;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic.BookViewButton;
import net.minecraft.text.TranslatableText;

public class PosButton extends BookViewButton {

	private final boolean flipRight;

	public PosButton(TranslatableText name, Texture texture, int x, int y, int width, int height, boolean flipRight) {
		super(name, texture);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.flipRight = flipRight;
	}

	@Override
	public InputResult onClick(int x, int y, int button) {
		if (this.getParent() instanceof BookGUI gui) {
			BookView view = gui.getCurrentView();
		}

		return InputResult.PROCESSED;
	}

}
