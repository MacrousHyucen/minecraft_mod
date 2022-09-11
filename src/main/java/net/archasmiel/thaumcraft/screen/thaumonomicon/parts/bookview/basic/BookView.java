package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic;

import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.element.BookViewElement;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookView {

	public static final int PAGE_SIZE = 160;

	public static class Builder {
		private final BookView view;

		public Builder() {
			view = new BookView();
		}

		public Builder add(BookPage page) {
			view.pages.add(page);
			return this;
		}

		public Builder add(BookViewElement... element) {
			BookPage.Builder newPage = new BookPage.Builder();
			Arrays.stream(element).forEach(newPage::add);
			view.pages.add(newPage.build());
			return this;
		}

		public BookView build() {
			return view;
		}
	}



	private int currentLeftPage;
	private final List<BookPage> pages;

	public BookView() {
		currentLeftPage = 0;
		pages = new ArrayList<>();
	}



	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		if (pages.size() == 0) return;

		if (currentLeftPage <= pages.size()-1) {
			pages.get(currentLeftPage).paint(matrices, x, y, mouseX, mouseY);
		}

		if (currentLeftPage+1 <= pages.size()-1) {
			pages.get(currentLeftPage+1).paint(matrices, x+PAGE_SIZE, y, mouseX, mouseY);
		}
	}

	public List<BookPage> getPages() {
		return pages;
	}



	public void flipLeft() {
		if (canFlipLeft())
			currentLeftPage -= 2;
	}

	public void flipRight() {
		if (canFlipRight())
			currentLeftPage += 2;
	}



	public boolean canFlipLeft() {
		return currentLeftPage > 0;
	}

	public boolean canFlipRight() {
		return currentLeftPage < pages.size()-1 && currentLeftPage+2 <= pages.size()-1;
	}

}
