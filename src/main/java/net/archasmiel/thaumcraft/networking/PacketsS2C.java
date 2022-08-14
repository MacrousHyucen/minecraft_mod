package net.archasmiel.thaumcraft.networking;

import net.archasmiel.thaumcraft.networking.c2s.ArcaneWorkbenchVisS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class PacketsS2C {

    private PacketsS2C() {

    }

    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(PacketIDs.RECIPE_SYNC_CLIENT, ArcaneWorkbenchVisS2CPacket::receive);
    }

}
