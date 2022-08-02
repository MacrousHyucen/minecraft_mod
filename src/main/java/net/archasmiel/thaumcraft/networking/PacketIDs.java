package net.archasmiel.thaumcraft.networking;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.util.Identifier;

public class PacketIDs {

    public static final Identifier RECIPE_SYNC_CLIENT = new Identifier(Thaumcraft.MOD_ID, "recipe-sync-client");
    public static final Identifier RECIPE_SYNC_SERVER = new Identifier(Thaumcraft.MOD_ID, "recipe-sync-server");

    public static void register() {

    }

}
