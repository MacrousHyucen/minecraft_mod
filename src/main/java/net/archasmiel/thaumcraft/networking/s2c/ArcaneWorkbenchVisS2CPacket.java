package net.archasmiel.thaumcraft.networking.s2c;

import net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreen;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class ArcaneWorkbenchVisS2CPacket {

    private ArcaneWorkbenchVisS2CPacket() {

    }

    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        ArcaneWorkbenchScreen.clearCurrRecipeVis();

        int respSize = buf.readVarInt();
        for (int i = 0 ; i < respSize ; i++) {
            String key = buf.readString();
            Float value = buf.readFloat();
            ArcaneWorkbenchScreen.addCurrRecipeVis(key, value);
        }
    }

}
