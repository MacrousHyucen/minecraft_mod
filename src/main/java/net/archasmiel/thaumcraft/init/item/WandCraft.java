package net.archasmiel.thaumcraft.init.item;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;

public class WandCraft {

    public static final Item WAND_ITEM = Register.registerItem(
            "wand",
            new Item(new FabricItemSettings().group(Thaumcraft.MOD_GROUP).maxCount(1))
    );



    public static void register() {
        Thaumcraft.LOGGER.info("Loading testing");
    }


}
