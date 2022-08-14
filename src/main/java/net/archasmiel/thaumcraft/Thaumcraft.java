package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.block.Blocks;
import net.archasmiel.thaumcraft.blockentity.BlockEntities;
import net.archasmiel.thaumcraft.item.Items;
import net.archasmiel.thaumcraft.networking.PacketIDs;
import net.archasmiel.thaumcraft.networking.PacketsC2S;
import net.archasmiel.thaumcraft.recipe.Recipes;
import net.archasmiel.thaumcraft.screen.ScreenHandlers;
import net.archasmiel.thaumcraft.translation.Translations;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Thaumcraft implements ModInitializer {

	public static final String MOD_ID = "thaumcraft";
	public static final String MOD_NAME = "Thaumcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	// groups
	public static final ItemGroup MOD_GROUP_GENERAL = FabricItemGroupBuilder
			.create(new Identifier(MOD_ID, "general"))
			.icon(() -> new ItemStack(Items.THAUMONOMICON)).build();

	public static final ItemGroup MOD_GROUP_GENERATED = FabricItemGroupBuilder
			.create(new Identifier(MOD_ID, "generated"))
			.icon(() -> new ItemStack(Blocks.ARCANE_WORKBENCH)).build();


	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("thaumcraft:resources");
	public static final Translations TRANSLATIONS = new Translations(RESOURCE_PACK, MOD_ID, LOGGER, "en_us", "ru_ru", "zh_cn");





	@Override
	public void onInitialize() {

		TRANSLATIONS.loadInput();

		Blocks.register();
		Items.register();

		BlockEntities.register();
		ScreenHandlers.register();
		Recipes.register();

		PacketIDs.register();
		PacketsC2S.register();

		TRANSLATIONS.pushOutput();
		RRPCallback.BEFORE_VANILLA.register(a -> a.add(RESOURCE_PACK));

	}
}
