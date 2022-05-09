package net.archasmiel.thaumcraft;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.Books;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Thaumcraft implements ModInitializer {
	public static final String MOD_ID = "thaumcraft";
	public static final String MOD_NAME = "Thaumcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static final ItemGroup MOD_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, MOD_ID),
			() -> new ItemStack(Books.THAUMONOMICON)
	);

	public static final List<String> restrictedIDs = new ArrayList<>();
	private void addRestrictedIDs() {
		restrictedIDs.add("block/table");
		restrictedIDs.add("block/arcane_workbench");
		restrictedIDs.add("block/deconstruction_table");

		restrictedIDs.add("item/block/wand");
		restrictedIDs.add("block/wand");
		restrictedIDs.add("item/wand");
	}

	public static boolean isRestricted(String id){
		return restrictedIDs.contains(id);
	}

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
	}

	@Override
	public void onInitialize() {
		addRestrictedIDs();

		Register.register();
	}
}
