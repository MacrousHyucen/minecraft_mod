package net.archasmiel.thaumcraft.mixin;

import net.archasmiel.thaumcraft.util.server.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class ThaumonomiconDataSaverMixin implements IEntityDataSaver {

    private static final String POS_TAG = "thaumcraft.thaumonomicon_pos_data";
    private NbtCompound persistentData;




    @Override
    public NbtCompound getPersistentData() {
        if (this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectedWrite(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if (persistentData != null) {
            nbt.put(POS_TAG, persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectedRead(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains(POS_TAG, 10)) {
            persistentData = nbt.getCompound(POS_TAG);
        }
    }
}
