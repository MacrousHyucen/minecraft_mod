package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic;

import io.github.cottonmc.cotton.gui.client.ScreenDrawing;
import io.github.cottonmc.cotton.gui.widget.WWidget;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Utility;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

import static net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Textures.DEF_COLOR;

public abstract class BookViewButton extends WWidget {

	private final TranslatableText name;
	private final Texture texture;

	protected BookViewButton(TranslatableText name, Texture texture) {
		this.name = name;
		this.texture = texture;
	}

	@Override
	public void paint(MatrixStack matrices, int x, int y, int mouseX, int mouseY) {
		Utility.precisiveTexturedRect(matrices, x + this.x, y + this.y, width, height, texture, DEF_COLOR);
	}

	@Override
	public void renderTooltip(MatrixStack matrices, int x, int y, int tX, int tY) {
		drawBorder(matrices, x, y);
		drawText(matrices, x, y, tX, tY);
	}

	private void drawText(MatrixStack matrices, int x, int y, int tX, int tY) {
		float scale = 0.5f;
		int intent = 2;

		x += 3;
		y -= 7;
		TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
		int width = (int) (textRenderer.getWidth(name)*scale + 2*intent);
		int height = (int) (8*0.5f);
		ScreenDrawing.coloredRect(matrices, x+tX, y+tY, width, height+2*intent, 0xDD000000);

		x += intent;
		y += intent;
		matrices.push();
		matrices.scale(scale, scale, 1.0f);
		MinecraftClient.getInstance().textRenderer
			.drawWithShadow(matrices, name.asOrderedText(), (x+tX)/scale, (y+tY)/scale, DEF_COLOR);
		matrices.pop();
	}

	private void drawBorder(MatrixStack matrices, int x, int y) {
		int scale = 1;
		Utility.precisiveTexturedRect(matrices, x+this.x-scale , y+this.y-scale, width+2*scale, height+2*scale, texture, DEF_COLOR, 0.5f);
	}

	@Override
	public boolean canResize() {
		return false;
	}

}
