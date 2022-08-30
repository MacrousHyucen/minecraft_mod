package net.archasmiel.thaumcraft.networking;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.util.Identifier;

public class PacketIDs {

    // Client
    public static final Identifier RECIPE_SYNC_CLIENT = new Identifier(Thaumcraft.MOD_ID, "recipe-c");
    public static final Identifier THAUMONOMICON_DATA_CLIENT = new Identifier(Thaumcraft.MOD_ID, "thaumonomicon-data-c");


    // Server
    public static final Identifier THAUMONOMICON_DATA_SERVER = new Identifier(Thaumcraft.MOD_ID, "thaumonomicon-data-s");



    private PacketIDs() {

    }

    public static void register() {
        // Registering identifiers for client and server sides
    }

}
