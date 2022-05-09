package net.archasmiel.thaumcraft.test;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class ThaumcraftModelProvider implements ModelResourceProvider {

    public static final WandBaseModel WAND_MODEL = new WandBaseModel();
    public static final Identifier WAND_MODEL_BLOCK = new Identifier("thaumcraft:block/wand");
    public static final Identifier WAND_MODEL_ITEM = new Identifier("thaumcraft:item/wand");



    @Override
    public @Nullable UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext context) {
        if(identifier.equals(WAND_MODEL_BLOCK) || identifier.equals(WAND_MODEL_ITEM)) {
            return WAND_MODEL;
        } else {
            return null;
        }
    }

}
