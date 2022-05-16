package net.archasmiel.thaumcraft.lib.register;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.lib.ItemDataGen;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class Material {

    public static Item register(String name) {

        if (name.contains("shard") && !name.contains("balanced")){
            ItemDataGen.simpleItemModel("generated", name, "shard");
        } else {
            ItemDataGen.simpleItemModel("generated", name);
        }

        return Register.registerItem(
                name,
                new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
        );
    }

    public static Item register(String name, int maxCount) {


        if (name.contains("shard") && !name.contains("balanced")){
            ItemDataGen.simpleItemModel("generated", name, "shard");
        } else {
            ItemDataGen.simpleItemModel("generated", name);
        }

        return Register.registerItem(
                name,
                new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(maxCount))
        );
    }

    public static Item register(String name, int color, int maxCount) {

        if (name.contains("shard") && !name.contains("balanced")){
            ItemDataGen.simpleItemModel("generated", name, "shard");
        } else {
            ItemDataGen.simpleItemModel("generated", name);
        }

        return Register.registerItem(
                name,
                new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(maxCount)),
                color
        );
    }

}
