package net.archasmiel.thaumcraft.item.groups;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.item.Thaumonomicon;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

import static net.archasmiel.thaumcraft.init.Group.books;

public class Books {

    public static final Item THAUMONOMICON = Register.registerItem(
            books, "thaumonomicon",
            new Thaumonomicon(new FabricItemSettings().group(Thaumcraft.MOD_GROUP))
    );

    public static final Item THAUMONOMICON_CHEAT = Register.registerItem(
            books, "thaumonomicon_cheat",
            new Item(new FabricItemSettings().group(ItemGroup.INVENTORY))
    );



    public static void register() {}


}
