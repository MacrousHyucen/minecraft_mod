package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.init.block.Functional;
import net.archasmiel.thaumcraft.init.item.ItemRegister;
import net.archasmiel.thaumcraft.lang.GenTranslations;
import net.archasmiel.thaumcraft.lang.LangTranslations;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.archasmiel.thaumcraft.init.item.ItemRegister.THAUMONOMICON;


public class Thaumcraft implements ModInitializer {
	public static final String MOD_ID = "thaumcraft";
	public static final String MOD_NAME = "Thaumcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	// Supported languages, which will be loaded to THAUMCRAFT_LANGTRANS
	public static final String[] supportedLanguages = {"en_us", "ru_ru", "zh_cn"};

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, MOD_ID),
			() -> new ItemStack(THAUMONOMICON.getItem())
	);

	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("thaumcraft:resources");
	public static GenTranslations THAUMCRAFT_LANG = new GenTranslations(MOD_ID);
	public static LangTranslations THAUMCRAFT_LANGTRANS = new LangTranslations(MOD_ID);

	public static String[] primaryAspects = {"aer", "ignis", "aqua", "terra", "ordo", "perditio"};



	private void readLanguages() {
		for (String i: supportedLanguages){
			THAUMCRAFT_LANGTRANS.readLanguage(i);
		}

		// testing of read translations
		System.out.println(THAUMCRAFT_LANGTRANS.getTranslation("en_us", "block.thaumcraft.arcane_workbench"));
		System.out.println(THAUMCRAFT_LANGTRANS.getTranslation("ru_ru", "block.thaumcraft.arcane_workbench"));
		System.out.println(THAUMCRAFT_LANGTRANS.getTranslation("zh_cn", "block.thaumcraft.arcane_workbench"));
	}

	@Override
	public void onInitialize() {

		readLanguages();

		Functional.register();
		ItemRegister.register();
		THAUMCRAFT_LANG.register();


		RRPCallback.BEFORE_VANILLA.register(a -> a.add(RESOURCE_PACK));

	}
}
