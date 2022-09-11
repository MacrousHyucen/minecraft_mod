package net.archasmiel.thaumcraft.mixin;

import net.archasmiel.thaumcraft.networking.PacketIDs;
import net.archasmiel.thaumcraft.screen.thaumonomicon.data.Tabs;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.PacketByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class ClientWorldMixin {

	@Inject(method = "disconnect", at = @At("HEAD"))
	protected void disconnect(CallbackInfo ci) {
		Tabs.getTabs().forEach(tab -> {
			PacketByteBuf packet = PacketByteBufs.create();
			packet.writeString(tab.getId());
			packet.writeFloat(tab.getBackX()).writeFloat(tab.getBackY());
			ClientPlayNetworking.send(PacketIDs.THAUMONOMICON_DATA_SERVER, packet);
		});
	}

}
