package net.archasmiel.thaumcraft.generation;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Scepter;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Staff;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Wand;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.*;
import static net.archasmiel.thaumcraft.generation.ThaumcraftRegistry.wandcraftModel;
import static net.archasmiel.thaumcraft.generation.ThaumcraftRegistry.wandcraftName;
import static net.archasmiel.thaumcraft.generation.wandcraft.WandcraftRecipeGenerator.*;

public class WandcraftGeneration {

    public static void generateWandData(Wand item) {
        // lang translation
        wandcraftName(Thaumcraft.MOD_ID, supportedLanguages, THAUMCRAFT_INPUTLANG, THAUMCRAFT_OUTPUTLANG, item);

        // model
        RESOURCE_PACK.addModel(
                wandcraftModel(
                        Thaumcraft.MOD_ID,
                        "wand",
                        item.getRod().getRegistryName(),
                        item.getCap().getRegistryName()
                ),
                new Identifier("thaumcraft:item/" + item.name())
        );

        // recipe
        wandRecipe(Thaumcraft.MOD_ID, item);
    }

    public static void generateScepterData(Scepter item) {
        // lang translation
        wandcraftName(Thaumcraft.MOD_ID, supportedLanguages, THAUMCRAFT_INPUTLANG, THAUMCRAFT_OUTPUTLANG, item);

        // model
        RESOURCE_PACK.addModel(
                wandcraftModel(
                        Thaumcraft.MOD_ID,
                        "scepter",
                        item.getRod().getRegistryName(),
                        item.getCap().getRegistryName()
                ),
                new Identifier("thaumcraft:item/" + item.name())
        );

        // recipe
        scepterRecipe(Thaumcraft.MOD_ID, item);
    }

    public static void generateStaffData(Staff staff) {
        // translation
        wandcraftName(Thaumcraft.MOD_ID, supportedLanguages, THAUMCRAFT_INPUTLANG, THAUMCRAFT_OUTPUTLANG, staff);

        // model
        RESOURCE_PACK.addModel(
                wandcraftModel(
                        Thaumcraft.MOD_ID,
                        "staff",
                        staff.getRod().getRegistryName(),
                        staff.getCap().getRegistryName()
                ),
                new Identifier("thaumcraft:item/" + staff.name())
        );

        // recipe
        staffCoreRecipe(Thaumcraft.MOD_ID, staff);
        staffRecipe(Thaumcraft.MOD_ID, staff);
    }

}
