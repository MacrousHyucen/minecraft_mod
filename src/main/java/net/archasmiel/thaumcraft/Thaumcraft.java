package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.Books;
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

	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("thaumcraft:test");

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, MOD_ID),
			() -> new ItemStack(Books.THAUMONOMICON)
	);




	// archasmiel, can we have json gen methods methods?
	// archasmiel: no, we have json gen methods at home
	// json gen methods at home:
	public static String createItemModelJson(String id, String type) {

		if ("generated".equals(type) || "handheld".equals(type)) {
			//The two types of items. "handheld" is used mostly for tools and the like, while "generated" is used for everything else.
			return "{\n" +
					"  \"parent\": \"item/" + type + "\",\n" +
					"  \"textures\": {\n" +
					"    \"layer0\": \"thaumcraft:item/" + id.split("/")[1] + "\"\n" +
					"  }\n" +
					"}";
		} else if ("block".equals(type)) {
			//However, if the item is a block-item, it will have a different model json than the previous two.
			return "{\n" +
					"  \"parent\": \"thaumcraft:block/" + id.split("/")[1] + "\"\n" +
					"}";
		} else if ("item/block".equals(type)) {
			//However, if the item is a block-item, it will have a different model json than the previous two.
			return "{\n" +
					"  \"parent\": \"thaumcraft:block/" + id.split("/")[2] + "\"\n" +
					"}";
		} else if ("shard".equals(type)) {
			//However, if the item is a block-item, it will have a different model json than the previous two.
			return """
					{
					  "parent": "item/generated",
					  "textures": {
					    "layer0": "thaumcraft:item/shard"
					  }
					}""";
		} else if ("shard_balanced".equals(type)) {
			//However, if the item is a block-item, it will have a different model json than the previous two.
			return """
					{
					  "parent": "item/generated",
					  "textures": {
					    "layer0": "thaumcraft:item/shard_balanced"
					  }
					}""";
		}
		else {
			//If the type is invalid, return an empty json string.
			return "";
		}

		// Wall Of Shame
		// this DEFINITELY MUST BE ERASED from existence
	}



	@Override
	public void onInitialize() {

		Register.register();

		RRPCallback.AFTER_VANILLA.register(a -> a.add(RESOURCE_PACK));

	}
}
