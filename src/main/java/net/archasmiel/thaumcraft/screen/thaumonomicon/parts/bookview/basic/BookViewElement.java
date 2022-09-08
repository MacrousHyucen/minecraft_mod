package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic;

import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.minecraft.client.util.math.MatrixStack;

public class BookViewElement {

	public static class Builder {
		private final BookViewElement element;

		public Builder() {
			element = new BookViewElement();
		}

		public Builder texture(Texture texture) {
			element.texture = texture;
			return this;
		}

		public Builder x(int x) {
			element.x = x;
			return this;
		}

		public Builder y(int y) {
			element.y = y;
			return this;
		}

		public Builder pos(int x, int y) {
			return this.x(x).y(y);
		}

		public Builder sizex(int sizeX) {
			element.sizeX = sizeX;
			return this;
		}

		public Builder sizey(int sizeY) {
			element.sizeY = sizeY;
			return this;
		}

		public Builder size(int sizeX, int sizeY) {
			return this.sizex(sizeX).sizey(sizeY);
		}

		public BookViewElement build() {
			if (element.texture == null) {
				throw new IllegalStateException("Texture is null");
			}

			return element;
		}
	}



	private Texture texture;
	private int x;
	private int y;
	private int sizeX;
	private int sizeY;



	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {

	}



	public Texture getTexture() {
		return texture;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
}
