package net.archasmiel.thaumcraft.networking;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

import static net.archasmiel.thaumcraft.screen.arcane_workbench.ArcaneWorkbenchScreen.curRecipeVis;

public class PacketsS2C {



    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(PacketIDs.RECIPE_SYNC_CLIENT, (client, handler, buf, responseSender) -> {
            curRecipeVis = Maps.newHashMap();

            int respSize = buf.readVarInt();
            for (int i = 0 ; i < respSize ; i++) {
                String key = buf.readString();
                Float value = buf.readFloat();
                curRecipeVis.put(key, value);
            }
        });
    }

}
