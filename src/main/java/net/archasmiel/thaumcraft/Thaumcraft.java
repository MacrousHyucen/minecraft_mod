package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.lib.lang.GeneratedTranslations;
import net.archasmiel.thaumcraft.lib.lang.LangTranslations;
import net.archasmiel.thaumcraft.register.BlockRegister;
import net.archasmiel.thaumcraft.register.ItemRegister;
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
	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, MOD_ID),
			() -> new ItemStack(ItemRegister.THAUMONOMICON.getItem())
	);



	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("thaumcraft:resources");

	// Supported languages, which will be loaded to THAUMCRAFT_LANGTRANS
	public static final String[] supportedLanguages = {"en_us", "ru_ru", "zh_cn"};
	public static LangTranslations THAUMCRAFT_INPUTLANG = new LangTranslations(MOD_ID);
	public static GeneratedTranslations THAUMCRAFT_OUTPUTLANG = new GeneratedTranslations(MOD_ID);


	public static String[] primaryAspects = {"aer", "ignis", "aqua", "terra", "ordo", "perditio"};
	public static String[] primaryAspectsColor = {"§e", "§c", "§b", "§a", "§f", "§8"};

	@Override
	public void onInitialize() {

		for (String i: supportedLanguages)
			THAUMCRAFT_INPUTLANG.readLanguage(i);

		BlockRegister.register();
		ItemRegister.register();

		for (String i: supportedLanguages)
			THAUMCRAFT_OUTPUTLANG.registerLanguage(i);

		RRPCallback.BEFORE_VANILLA.register(a -> a.add(RESOURCE_PACK));

	}
}
