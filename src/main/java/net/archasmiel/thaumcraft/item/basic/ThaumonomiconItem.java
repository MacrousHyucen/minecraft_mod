package net.archasmiel.thaumcraft.item.basic;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.generation.ThaumcraftRegistry;
import net.archasmiel.thaumcraft.register.Register;
import net.archasmiel.thaumcraft.screen.thaumonomicon.ThaumonomiconGui;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ThaumonomiconItem extends ThaumcraftItem {


    public ThaumonomiconItem(Settings settings, String name) {
        super(settings, name);
        load();
    }







    @Override
    public void model() {
        ThaumcraftRegistry.simpleItemModel(Thaumcraft.MOD_ID, "generated", name(), name());
    }

    @Override
    public void register() {
        setItem(Register.registerItem(name(), this));
    }








    @Environment(EnvType.CLIENT)
    private void drawScreen() {
        MinecraftClient.getInstance().setScreenAndRender(new CottonClientScreen(new ThaumonomiconGui()));
        MinecraftClient.getInstance().getSoundManager().play(
            PositionedSoundInstance.master(
                SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0F
            )
        );
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient() && hand == Hand.MAIN_HAND) drawScreen();

        return TypedActionResult.success(user.getStackInHand(hand));
    }


}
