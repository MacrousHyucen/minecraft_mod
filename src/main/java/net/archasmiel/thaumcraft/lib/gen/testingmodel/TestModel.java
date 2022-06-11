package net.archasmiel.thaumcraft.lib.gen.testingmodel;

import com.mojang.datafixers.util.Pair;
import net.archasmiel.thaumcraft.Thaumcraft;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.*;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

@Environment(EnvType.CLIENT)
public class TestModel implements UnbakedModel, BakedModel, FabricBakedModel {


    private static final SpriteIdentifier[] SPRITE_IDS = new SpriteIdentifier[]{
            new SpriteIdentifier(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, new Identifier("minecraft:block/furnace_front_on")),
            new SpriteIdentifier(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE, new Identifier("minecraft:block/furnace_top"))
    };
    private final Sprite[] SPRITES = new Sprite[2];


    private Mesh mesh;








    @Override
    public Collection<Identifier> getModelDependencies() {
        return Collections.emptyList();
    }

    @Override
    public Collection<SpriteIdentifier> getTextureDependencies(Function<Identifier, UnbakedModel> unbakedModelGetter, Set<Pair<String, String>> unresolvedTextureReferences) {
        return Arrays.asList(SPRITE_IDS);
    }

    @Nullable
    @Override
    public BakedModel bake(ModelLoader loader, Function<SpriteIdentifier, Sprite> textureGetter, ModelBakeSettings rotationContainer, Identifier modelId) {

        for (int i = 0 ; i < 2 ; ++i){
            SPRITES[i] = textureGetter.apply(SPRITE_IDS[i]);

        }



        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
        MeshBuilder builder = Objects.requireNonNull(renderer).meshBuilder();
        QuadEmitter emitter = builder.getEmitter();

        for (Direction dir: Direction.values()) {
            int spriteIDx = dir == Direction.UP || dir == Direction.DOWN ? 1 : 0;

            emitter.square(dir, 0.5f, 0.5f, 1.0f, 1.0f, 0.0f);
            // TODO
            // make this stuff cut textures
            QuadEmitter curTex = emitter.spriteBake(0, SPRITES[spriteIDx], QuadEmitter.BAKE_LOCK_UV);

            // UV info print
            // Thaumcraft.LOGGER.info(String.format("%f %f", curTex.spriteU(0, 0), curTex.spriteV(0, 0)));
            // Thaumcraft.LOGGER.info(String.format("%f %f", curTex.spriteU(1, 0), curTex.spriteV(1, 0)));
            // Thaumcraft.LOGGER.info(String.format("%f %f", curTex.spriteU(2, 0), curTex.spriteV(2, 0)));
            // Thaumcraft.LOGGER.info(String.format("%f %f", curTex.spriteU(3, 0), curTex.spriteV(3, 0)));

            // holy god it is atlas itself!
            // emitter.sprite(0, 0, 0.0f, 0.0f);
            // emitter.sprite(1, 0, 1.0f, 0.0f);
            // emitter.sprite(2, 0, 0.0f, 1.0f);
            // emitter.sprite(3, 0, 1.0f, 1.0f);

            emitter.spriteColor(0, -1, -1, -1, -1);
            emitter.emit();
        }

        mesh = builder.build();


        Thaumcraft.LOGGER.info(modelId.toString());

        return this;
    }






    @Override
    public List<BakedQuad> getQuads(BlockState state, Direction face, Random random) {
        return Collections.emptyList();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return true; // we want the block to have a shadow depending on the adjacent blocks
    }

    @Override
    public boolean isBuiltin() {
        return false;
    }

    @Override
    public boolean hasDepth() {
        return false;
    }

    @Override
    public boolean isSideLit() {
        return false;
    }

    @Override
    public Sprite getParticleSprite() {
        return SPRITES[1]; // Block break particle, let's use furnace_top
    }

    @Override
    public ModelTransformation getTransformation() {
        return null;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return null;
    }





    @Override
    public boolean isVanillaAdapter() {
        return false; // False to trigger FabricBakedModel rendering
    }

    @Override
    public void emitBlockQuads(BlockRenderView blockRenderView, BlockState blockState, BlockPos blockPos, Supplier<Random> supplier, RenderContext renderContext) {
        renderContext.meshConsumer().accept(mesh);
    }

    @Override
    public void emitItemQuads(ItemStack itemStack, Supplier<Random> supplier, RenderContext renderContext) {

    }













}
