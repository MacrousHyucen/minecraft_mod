package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.block.Blocks;
import net.archasmiel.thaumcraft.blockentity.BlockEntities;
import net.archasmiel.thaumcraft.item.Items;
import net.archasmiel.thaumcraft.generation.lang.GeneratedTranslations;
import net.archasmiel.thaumcraft.generation.lang.LanguageTranslations;
import net.archasmiel.thaumcraft.recipe.Recipes;
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
	public static ItemGroup MOD_GROUP_GENERAL = FabricItemGroupBuilder
			.create(new Identifier(MOD_ID, "general"))
			.icon(() -> new ItemStack(Items.THAUMONOMICON)).build();

	public static ItemGroup MOD_GROUP_GENERATED = FabricItemGroupBuilder
			.create(new Identifier(MOD_ID, "generated"))
			.icon(() -> new ItemStack(Blocks.ARCANE_WORKBENCH)).build();




	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("thaumcraft:resources");

	// Supported languages, which will be loaded to THAUMCRAFT_LANGTRANS
	public static final String[] supportedLanguages = {"en_us", "ru_ru", "zh_cn"};
	public static LanguageTranslations THAUMCRAFT_INPUTLANG = new LanguageTranslations(MOD_ID);
	public static GeneratedTranslations THAUMCRAFT_OUTPUTLANG = new GeneratedTranslations(MOD_ID);


	public static String[] primaryAspects = {"aer", "ignis", "aqua", "terra", "ordo", "perditio"};
	public static String[] primaryAspectsColor = {"§e", "§c", "§b", "§a", "§f", "§8"};







	@Override
	public void onInitialize() {

		// loading all translations from lang
		for (String i: supportedLanguages)
			THAUMCRAFT_INPUTLANG.readLanguage(i);

		Blocks.register();
		Items.register();

		BlockEntities.register();
		Recipes.register();

		// registering languages via arrp
		for (String i: supportedLanguages)
			THAUMCRAFT_OUTPUTLANG.registerLanguage(i);

		RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));

	}
}
