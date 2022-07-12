package net.archasmiel.thaumcraft.lib.recipegen;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.Items;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Scepter;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Staff;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Wand;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class WandcraftRecipeGenerator {

    public static void wandRecipe(Wand item) {
        if (item != null) {
            String rod = item.getRod().isStick() ? "minecraft:stick" : Thaumcraft.MOD_ID + ":wand_" + item.getRod().getRegistryName();
            String cap = Thaumcraft.MOD_ID + ":" + item.getCap().getRegistryName();

            RESOURCE_PACK.addRecipe(
                    new Identifier(
                        Thaumcraft.MOD_ID,
                        item.name()
                    ),
                    JRecipe.shaped(
                        JPattern.pattern("  c", " r ", "c  "),
                        JKeys.keys()
                            .key("c", JIngredient.ingredient().item(cap))
                            .key("r", JIngredient.ingredient().item(rod)),
                        JResult.result(Thaumcraft.MOD_ID + ":" + item.name())
                    )
            );

        }
    }

    public static void scepterRecipe(Scepter item) {
        // scepters have same rod as wands
        if (item != null) {
            String rod = item.getRod().isStick() ? "minecraft:stick" : Thaumcraft.MOD_ID + ":wand_" + item.getRod().getRegistryName();
            String cap = Thaumcraft.MOD_ID + ":" + item.getCap().getRegistryName();

            RESOURCE_PACK.addRecipe(
                    new Identifier(
                            Thaumcraft.MOD_ID,
                            item.name()
                    ),
                    JRecipe.shaped(
                            JPattern.pattern(" ca", " rc", "c  "),
                            JKeys.keys()
                                    .key("c", JIngredient.ingredient().item(cap))
                                    .key("r", JIngredient.ingredient().item(rod))
                                    .key("a", JIngredient.ingredient().item(Items.PRIMAL_CHARM.item())),
                            JResult.result(Thaumcraft.MOD_ID + ":" + item.name())
                    )
            );

        }
    }

    public static void staffRecipe(Staff item) {
        // staffs have different rod as wands
        if (item != null) {
            String rod = Thaumcraft.MOD_ID + ":staff_" + item.getRod().getRegistryName();
            String cap = Thaumcraft.MOD_ID + ":" + item.getCap().getRegistryName();

            // registering staff core recipe
            // primal staff core only crafted on infusion
            // and there's no wooden staff core ever existed
            String wand_rod = Thaumcraft.MOD_ID + ":wand_" + item.getRod().getRegistryName();
            if (!(item.getRod().isPrimal() || item.getRod().isStick())) {
                RESOURCE_PACK.addRecipe(
                        new Identifier(
                                Thaumcraft.MOD_ID,
                                item.name()
                        ),
                        JRecipe.shaped(
                                JPattern.pattern("  a", " r ", "r  "),
                                JKeys.keys()
                                        .key("a", JIngredient.ingredient().item(Items.PRIMAL_CHARM.item()))
                                        .key("r", JIngredient.ingredient().item(wand_rod)),
                                JResult.result(rod)
                        )
                );
            }

            RESOURCE_PACK.addRecipe(
                    new Identifier(
                            Thaumcraft.MOD_ID,
                            item.name()
                    ),
                    JRecipe.shaped(
                            JPattern.pattern("  c", " r ", "c  "),
                            JKeys.keys()
                                    .key("c", JIngredient.ingredient().item(cap))
                                    .key("r", JIngredient.ingredient().item(rod)),
                            JResult.result(Thaumcraft.MOD_ID + ":" + item.name())
                    )
            );



        }
    }

}
