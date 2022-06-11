package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.init.block.Functional;
import net.archasmiel.thaumcraft.init.item.ItemRegister;
import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.lang.JLang;
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

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, MOD_ID),
			() -> new ItemStack(THAUMONOMICON.getItem())
	);

	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("thaumcraft:resources");
	public static final JLang EN_US_lang = new JLang();
	public static final JLang RU_RU_lang = new JLang();
	public static final JLang ZN_CN_lang = new JLang();




	// Registering all items and blocks
	public void register() {
		Functional.register();
		ItemRegister.register();

	}



	@Override
	public void onInitialize() {

		register();

		RESOURCE_PACK.addLang(new Identifier("thaumcraft:en_us"), EN_US_lang);
		RESOURCE_PACK.addLang(new Identifier("thaumcraft:ru_ru"), RU_RU_lang);
		RESOURCE_PACK.addLang(new Identifier("thaumcraft:zh_cn"), ZN_CN_lang);
		RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));

	}
}
