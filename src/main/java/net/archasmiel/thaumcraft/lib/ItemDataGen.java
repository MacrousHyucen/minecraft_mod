package net.archasmiel.thaumcraft.lib;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.minecraft.util.Identifier;

public class ItemDataGen {

    public static final RuntimeResourcePack RESOURCE_PACK = Thaumcraft.RESOURCE_PACK;


    public static void simpleItemModel(String type, String modelName, String textureName) {
        RESOURCE_PACK.addModel(
                new JModel()
                        .parent("item/" + type)
                        .textures(
                                new JTextures().layer0("thaumcraft:item/" + textureName)
                        ),

                new Identifier("thaumcraft:item/" + modelName)
        );
    }


    public static void simpleItemBlockModel(String blockName) {
        RESOURCE_PACK.addModel(
                new JModel().parent("thaumcraft:block/" + blockName),

                new Identifier("thaumcraft:item/block/" + blockName)
        );
    }

}
