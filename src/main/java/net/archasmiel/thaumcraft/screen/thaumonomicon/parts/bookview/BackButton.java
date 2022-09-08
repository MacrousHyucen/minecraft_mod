package net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview;

import io.github.cottonmc.cotton.gui.widget.data.InputResult;
import io.github.cottonmc.cotton.gui.widget.data.Texture;
import net.archasmiel.thaumcraft.screen.thaumonomicon.ThaumonomiconGUI;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.bookview.basic.BookViewButton;
import net.archasmiel.thaumcraft.sounds.Sounds;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.text.TranslatableText;

public class BackButton extends BookViewButton {

	public BackButton(TranslatableText name, Texture texture, int x, int y, int width, int height) {
		super(name, texture);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public InputResult onClick(int x, int y, int button) {
		if (this.getParent().getHost() instanceof ThaumonomiconGUI gui) {
			gui.setRootPanel(gui.getResearchGUI());

			MinecraftClient.getInstance().getSoundManager()
				.play(PositionedSoundInstance.master(Sounds.PAGE_FLIP, 1.0F));
		}

		return InputResult.PROCESSED;
	}

}
