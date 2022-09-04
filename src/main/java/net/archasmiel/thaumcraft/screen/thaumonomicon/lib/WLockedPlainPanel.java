package net.archasmiel.thaumcraft.screen.thaumonomicon.lib;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.widget.WPanel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Insets;

public class WLockedPlainPanel extends WPlainPanel {

	@Override
	public InputResult onClick(int x, int y, int button) {
		// can't be clicked itself
		return InputResult.IGNORED;
	}

	@Override
	public WPanel setBackgroundPainter(BackgroundPainter painter) {
		// no painter - only custom paint
		return null;
	}

	@Override
	public boolean canResize() {
		// not resizable
		return false;
	}

	@Override
	protected void expandToFit(WWidget w) {
		// not expandable
	}


	@Override
	protected void expandToFit(WWidget w, Insets insets) {
		// not expandable
	}

}
