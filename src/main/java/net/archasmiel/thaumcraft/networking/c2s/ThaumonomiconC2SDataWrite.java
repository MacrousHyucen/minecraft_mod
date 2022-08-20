package net.archasmiel.thaumcraft.networking.c2s;

import net.archasmiel.thaumcraft.util.IEntityDataSaver;
import net.archasmiel.thaumcraft.util.ThaumonomiconPosData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class ThaumonomiconC2SDataWrite {

    private ThaumonomiconC2SDataWrite() {

    }

    public static void receive(MinecraftServer minecraftServer, ServerPlayerEntity serverPlayerEntity,
                               ServerPlayNetworkHandler serverPlayNetworkHandler, PacketByteBuf packetByteBuf,
                               PacketSender packetSender) {

        String tabId = packetByteBuf.readString();
        float posX = packetByteBuf.readFloat();
        float posY = packetByteBuf.readFloat();
        ThaumonomiconPosData.setTabPos((IEntityDataSaver) serverPlayerEntity, tabId, posX, posY);
    }
}
