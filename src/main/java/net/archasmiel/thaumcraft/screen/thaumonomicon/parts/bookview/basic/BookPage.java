package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic;

import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.element.BookViewElement;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.List;

public class BookPage {

	public static class Builder {
		private final BookPage page;

		public Builder() {
			page = new BookPage();
		}

		public Builder add(BookViewElement element) {
			page.content.add(element);
			return this;
		}

		public BookPage build() {
			return page;
		}
	}

	private final List<BookViewElement> content;

	public BookPage() {
		content = new ArrayList<>();
	}

	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		content.forEach(e -> e.paint(matrices, x, y, mouseX, mouseY));
	}

}
