package net.archasmiel.thaumcraft.networking.c2s;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import static net.archasmiel.thaumcraft.networking.PacketIDs.THAUMONOMICON_DATA_SERVER;

public class PacketsC2S {

    private PacketsC2S() {

    }

    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(THAUMONOMICON_DATA_SERVER, ThaumonomiconC2SDataWrite::receive);
    }

}
