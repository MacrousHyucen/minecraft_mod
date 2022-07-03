package net.archasmiel.thaumcraft.lib.recipegen;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.basic.items.WandItem;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class WandRecipeGenerator {

    public static void wandRecipe(WandItem item) {
        if (item != null) {
            RESOURCE_PACK.addRecipe(
                new Identifier(
                    Thaumcraft.MOD_ID,
                    item.name()
                ),
                JRecipe.shaped(
                    JPattern.pattern("  c", " r ", "c  "),
                    JKeys.keys()
                        .key("c", JIngredient.ingredient().item(Thaumcraft.MOD_ID + ":" + item.getWandItem().getCap().getRegistryName()))
                        .key("r", JIngredient.ingredient().item(Thaumcraft.MOD_ID + ":wand_" + item.getWandItem().getRod().getRegistryName())),
                    JResult.result(Thaumcraft.MOD_ID + ":" + item.name())
                )
            );
        }
    }

}
