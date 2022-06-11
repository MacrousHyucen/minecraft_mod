package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.init.block.Functional;
import net.archasmiel.thaumcraft.init.item.ItemRegister;
import net.archasmiel.thaumcraft.lang.Translations;
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

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, MOD_ID),
			() -> new ItemStack(THAUMONOMICON.getItem())
	);

	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("thaumcraft:resources");
	public static Translations THAUMCRAFT_LANG = new Translations(MOD_ID);





	@Override
	public void onInitialize() {

		Functional.register();
		ItemRegister.register();

		THAUMCRAFT_LANG.register();

		RRPCallback.BEFORE_VANILLA.register(a -> a.add(RESOURCE_PACK));

	}
}
