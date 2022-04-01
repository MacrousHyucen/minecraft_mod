package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.item.groups.Books;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thaumcraft implements ModInitializer {
	public static final String MOD_ID = "thaumcraft";
	public static final String MOD_NAME = "Thaumcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(Thaumcraft.MOD_ID, Thaumcraft.MOD_ID),
			() -> new ItemStack(Books.THAUMONOMICON)
	);


	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		Register.register();

	}
}
