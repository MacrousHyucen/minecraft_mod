package net.archasmiel.thaumcraft.generation;

import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.MOD_ID;
import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;
import static net.archasmiel.thaumcraft.generation.ThaumcraftRegistry.wandcraftModel;
import static net.archasmiel.thaumcraft.generation.ThaumcraftRegistry.wandcraftName;

public class WandcraftGeneration {

    private WandcraftGeneration() {

    }



    public static void generateWandcraftData(WandAbstract item) {
        // lang translation
        wandcraftName(MOD_ID, item);

        // model
        RESOURCE_PACK.addModel(
                wandcraftModel(
                        MOD_ID,
                        item.getType(),
                        item.getRod().getRegistryName(),
                        item.getCap().getRegistryName()
                ),
                new Identifier("thaumcraft:item/" + item.name())
        );
    }

}
