package net.archasmiel.thaumcraft.recipe;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Recipes {



    public static void register() {
        Registry.register(
            Registry.RECIPE_SERIALIZER,
            new Identifier(Thaumcraft.MOD_ID, ArcaneWorkbenchRecipe.Serializer.ID),
            ArcaneWorkbenchRecipe.Serializer.INSTANCE
        );
        Registry.register(
                Registry.RECIPE_TYPE,
                new Identifier(Thaumcraft.MOD_ID, ArcaneWorkbenchRecipe.Type.ID),
                ArcaneWorkbenchRecipe.Type.INSTANCE
        );
    }

}
