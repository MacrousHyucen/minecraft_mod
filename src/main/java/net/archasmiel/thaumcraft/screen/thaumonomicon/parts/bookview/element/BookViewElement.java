package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.element;

import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.minecraft.client.util.math.MatrixStack;

public abstract class BookViewElement extends WWidget {

	protected BookViewElement(int x, int y, int width, int height) {
		setLocation(x, y);
		setSize(width, height);
	}

	@Override
	public abstract void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY);

	@Override
	public boolean canResize() {
		return false;
	}

}
