package net.archasmiel.thaumcraft.lib.gen.testingmodel;

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
    public static final Identifier TESTBLOCK_MODEL = new Identifier("thaumcraft:block/testblock");


    @Override
    public @Nullable UnbakedModel loadModelResource(Identifier identifier, ModelProviderContext modelProviderContext) {
        if(identifier.equals(TESTBLOCK_MODEL)) {
            return new TestModel();
        } else {
            return null;
        }
    }

}
