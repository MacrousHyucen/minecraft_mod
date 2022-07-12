package net.archasmiel.thaumcraft.generation;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.generation.wandcraft.WandcraftRecipeGenerator;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Scepter;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Staff;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Wand;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.*;
import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class WandcraftGeneration {

    public static void generateWandData(Wand wand) {
        // lang translation
        ThaumcraftRegistry.wandcraftName(Thaumcraft.MOD_ID, supportedLanguages, THAUMCRAFT_INPUTLANG, THAUMCRAFT_OUTPUTLANG, wand);

        // model
        RESOURCE_PACK.addModel(
                ThaumcraftRegistry.wandModel(Thaumcraft.MOD_ID, wand.getRod().getRegistryName(), wand.getCap().getRegistryName()),
                new Identifier("thaumcraft:item/" + wand.name())
        );

        // recipe
        WandcraftRecipeGenerator.wandRecipe(Thaumcraft.MOD_ID, wand);
    }

    public static void generateScepterData(Scepter scepter) {
        // lang translation
        ThaumcraftRegistry.wandcraftName(Thaumcraft.MOD_ID, supportedLanguages, THAUMCRAFT_INPUTLANG, THAUMCRAFT_OUTPUTLANG, scepter);

        // model
        RESOURCE_PACK.addModel(
                ThaumcraftRegistry.scepterModel(Thaumcraft.MOD_ID, scepter.getRod().getRegistryName(), scepter.getCap().getRegistryName()),
                new Identifier("thaumcraft:item/" + scepter.name())
        );

        // recipe
        WandcraftRecipeGenerator.scepterRecipe(Thaumcraft.MOD_ID, scepter);
    }

    public static void generateStaffData(Staff staff) {
        // translation
        ThaumcraftRegistry.wandcraftName(Thaumcraft.MOD_ID, supportedLanguages, THAUMCRAFT_INPUTLANG, THAUMCRAFT_OUTPUTLANG, staff);

        // model
        RESOURCE_PACK.addModel(
                ThaumcraftRegistry.staffModel(Thaumcraft.MOD_ID, staff.getRod().getRegistryName(), staff.getCap().getRegistryName()),
                new Identifier("thaumcraft:item/" + staff.name())
        );

        // recipe
        WandcraftRecipeGenerator.staffRecipe(Thaumcraft.MOD_ID, staff);
    }

}
