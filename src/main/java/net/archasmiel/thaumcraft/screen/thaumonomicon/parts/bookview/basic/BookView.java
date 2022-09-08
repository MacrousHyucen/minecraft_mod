package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic;

import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;

public class BookView {

	public static class Builder {
		private final BookView view;

		public Builder() {
			view = new BookView();
		}

		public Builder add(BookViewElement element) {
			view.addElement(element);
			return this;
		}

		public BookView build() {
			return view;
		}
	}

	private final List<BookViewElement> elements;

	public BookView() {
		elements = new ArrayList<>();
	}

	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		elements.forEach(e -> e.paint(matrices, x, y, mouseX, mouseY));
	}

	public void addElement(BookViewElement element) {
		elements.add(element);
	}

	public void removeElement(BookViewElement element) {
		elements.remove(element);
	}

}
