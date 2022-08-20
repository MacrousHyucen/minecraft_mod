package net.archasmiel.thaumcraft.networking.s2c;

import net.archasmiel.thaumcraft.networking.PacketIDs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class PacketsS2C {

    private PacketsS2C() {

    }

    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(PacketIDs.RECIPE_SYNC_CLIENT, ArcaneWorkbenchVisS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(PacketIDs.THAUMONOMICON_DATA_CLIENT, ThaumonomiconS2CDataRead::receive);
    }

}
