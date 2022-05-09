package net.archasmiel.thaumcraft.mixin;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ModelLoader.class)
public class ModelLoaderMixin {

    @Inject(method = "loadModelFromJson", at = @At(value = "INVOKE", target = "Lnet/minecraft/resource/ResourceManager;getResource(Lnet/minecraft/util/Identifier;)Lnet/minecraft/resource/Resource;"), cancellable = true)
    public void loadModelFromJson(Identifier id, CallbackInfoReturnable<JsonUnbakedModel> cir) {
        //First, we check if the current item model that is being registered is from our mod. If it isn't, we continue.
        if (!Thaumcraft.MOD_ID.equals(id.getNamespace())) return;
        if (Thaumcraft.isRestricted(id.getPath())) return;
        //Here, we can do different checks to see if the current item is a block-item, a tool, or other.
        //This can be done in a lot of different ways, like putting all our items in a Set or a List and checking if the current item is contained inside.
        //For this tutorial, we only have 1 item, so we will not be doing that, and we will be going with "generated" as default item type.
        String modelJson = "";

        if (id.getPath().contains("shovel") || id.getPath().contains("sword") || id.getPath().contains("axe") || id.getPath().contains("hoe") || id.getPath().contains("pickaxe")) {
            modelJson = Thaumcraft.createItemModelJson(id.getPath(), "handheld");
        } else if (id.getPath().contains("item")) {
            modelJson = Thaumcraft.createItemModelJson(id.getPath(), "generated");
        }

        if (id.getPath().contains("item/block")) {
            modelJson = Thaumcraft.createItemModelJson(id.getPath(), "item/block");
        } else if (id.getPath().contains("block")) {
            modelJson = Thaumcraft.createItemModelJson(id.getPath(), "block");
        }

        if (id.getPath().contains("shard_balanced")) {
            modelJson = Thaumcraft.createItemModelJson(id.getPath(), "shard_balanced");
        } else if (id.getPath().contains("shard")) {
            modelJson = Thaumcraft.createItemModelJson(id.getPath(), "shard");
        }



        System.out.println(id.getPath());
        if ("".equals(modelJson)) return;
        //We check if the json string we get is valid before continuing.
        JsonUnbakedModel model = JsonUnbakedModel.deserialize(modelJson);
        model.id = id.toString();
        cir.setReturnValue(model);
    }

}
