package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview;

import io.github.cottonmc.cotton.gui.widget.WWidget;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.DrawUtility;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.WLockedPlainPanel;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic.BookView;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.button.BackButton;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.button.PosButton;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.*;

public class BookGUI extends WLockedPlainPanel {

	public static final TranslatableText BACK_NAME = new TranslatableText("gui.thaumcraft.back_button");
	public static final TranslatableText LEFT_NAME = new TranslatableText("gui.thaumcraft.left_button");
	public static final TranslatableText RIGHT_NAME = new TranslatableText("gui.thaumcraft.right_button");

	private final PosButton leftButton;
	private final PosButton rightButton;
	private final BackButton backButton;

	private BookView currentView;

	public BookGUI(Integer sizeX, Integer sizeY) {
		this(sizeX, sizeY, new BookView());
	}

	public BookGUI(Integer sizeX, Integer sizeY, BookView view) {
		setLocation(0, 0);
		setSize(sizeX, sizeY);

		setCurrentView(view);
		leftButton = new PosButton(LEFT_NAME, BOOKVIEW_LEFT_BUTTON, 23, height-21, 12, 8, false);
		rightButton = new PosButton(RIGHT_NAME, BOOKVIEW_RIGHT_BUTTON, width-35, height-21, 12, 8, true);
		backButton = new BackButton(BACK_NAME, BOOKVIEW_BACK_BUTTON, 21, 10, 14, 8);
		this.add(leftButton);     // left button
		this.add(rightButton);    // right button
		this.add(backButton);     // back button
	}

	public BookView getCurrentView() {
		return currentView;
	}

	public void setCurrentView(BookView currentView) {
		this.currentView = currentView;
	}

	private void add(WWidget widget) {
		this.add(widget, this.x+widget.getX(), this.y+widget.getY(), widget.getWidth(), widget.getHeight());
	}

	@Override
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		DrawUtility.precisiveTexturedRect(
			matrices,
			x+this.x, y+this.y,
			width, height,
			BOOKVIEW_BACKGROUND, DEF_COLOR
		);

		if (currentView != null) {
			currentView.paint(matrices, x, y, mouseX, mouseY);
		}

		backButton.paint(matrices, x, y, mouseX, mouseY);
		leftButton.paint(matrices, x, y, mouseX, mouseY);
		rightButton.paint(matrices, x, y, mouseX, mouseY);
	}

}
