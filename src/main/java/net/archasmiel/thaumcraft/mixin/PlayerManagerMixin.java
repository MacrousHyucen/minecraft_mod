package net.archasmiel.thaumcraft.mixin;

import net.archasmiel.thaumcraft.networking.PacketIDs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.parts.researchview.Tab;
import net.archasmiel.thaumcraft.util.server.IEntityDataSaver;
import net.archasmiel.thaumcraft.util.collections.Pair;
import net.archasmiel.thaumcraft.util.thaumonomicon.ThaumonomiconPosData;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {

    @Inject(method = "onPlayerConnect", at = @At("TAIL"))
    public void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player, CallbackInfo ci) {
        PacketByteBuf packetOut = PacketByteBufs.create();
        for (Tab tab: Tabs.getTabList()) {
            Pair<Float, Float> pos = ThaumonomiconPosData.getTabPos((IEntityDataSaver) player, tab.getId());
            packetOut.writeFloat(pos.getLeft());
            packetOut.writeFloat(pos.getRight());
        }
        ServerPlayNetworking.send(player, PacketIDs.THAUMONOMICON_DATA_CLIENT, packetOut);
    }

}
