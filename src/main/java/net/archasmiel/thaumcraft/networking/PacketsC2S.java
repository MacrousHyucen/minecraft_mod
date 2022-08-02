package net.archasmiel.thaumcraft.networking;

import net.archasmiel.thaumcraft.recipe.Recipes;
import net.archasmiel.thaumcraft.recipe.VisCraftingRecipe;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.collection.DefaultedList;

import java.util.Map;
import java.util.Optional;

public class PacketsC2S {



    public static void register() {
        ServerPlayNetworking.registerGlobalReceiver(PacketIDs.RECIPE_SYNC_SERVER, (server, player, handler, buf, responseSender) ->
            server.execute(() -> {
                ItemStack temp;
                DefaultedList<ItemStack> items = DefaultedList.of();
                for (int i = 0 ; i < 9 ; i++) {
                    temp = buf.readItemStack();
                    items.add(temp);
                }

                Optional<VisCraftingRecipe> opt = server.getRecipeManager().getFirstMatch(Recipes.VIS_RECIPE_TYPE, () -> items, player.world);

                PacketByteBuf buffer = PacketByteBufs.create();
                if (opt.isPresent()) {
                    buffer.writeVarInt(opt.get().getRecipeVis().size());
                    for (Map.Entry<String, Float> entry: opt.get().getRecipeVis().entrySet()) {
                        buffer.writeString(entry.getKey());
                        buffer.writeFloat(entry.getValue());
                    }
                } else {
                    buffer.writeVarInt(-1);
                }
                responseSender.sendPacket(PacketIDs.RECIPE_SYNC_CLIENT, buffer);
            })
        );
    }

}
