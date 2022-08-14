package net.archasmiel.thaumcraft.networking;

import net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreen;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class PacketsS2C {

    private PacketsS2C() {

    }

    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(PacketIDs.RECIPE_SYNC_CLIENT, (client, handler, buf, responseSender) -> {
            ArcaneWorkbenchScreen.clearCurrRecipeVis();

            int respSize = buf.readVarInt();
            for (int i = 0 ; i < respSize ; i++) {
                String key = buf.readString();
                Float value = buf.readFloat();
                ArcaneWorkbenchScreen.addCurrRecipeVis(key, value);
            }
        });
    }

}
