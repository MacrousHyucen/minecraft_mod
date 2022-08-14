package net.archasmiel.thaumcraft.networking;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.util.Identifier;

public class PacketIDs {

    // Client
    public static final Identifier RECIPE_SYNC_CLIENT = new Identifier(Thaumcraft.MOD_ID, "recipe-sync-client");





    // Server
    public static final Identifier RECIPE_SYNC_SERVER = new Identifier(Thaumcraft.MOD_ID, "recipe-sync-server");





    private PacketIDs() {

    }

    public static void register() {
        // Registering Identifiers for client and server sides
    }

}
