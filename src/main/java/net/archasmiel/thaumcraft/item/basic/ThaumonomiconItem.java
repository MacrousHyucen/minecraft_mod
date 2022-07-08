package net.archasmiel.thaumcraft.item.basic;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.archasmiel.thaumcraft.gui.thaumonomicon.ThaumonomiconGui;
import net.archasmiel.thaumcraft.lib.generation.ItemDataGeneration;
import net.archasmiel.thaumcraft.register.Register;
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
        ItemDataGeneration.simpleItemModel("generated", name(), name());
    }

    @Override
    public void register() {
        setItem(Register.registerItem(name(), this));
    }









    @Environment(EnvType.CLIENT)
    private void drawScreen(PlayerEntity user, Hand hand) {

        if (user.getWorld().isClient() && hand == Hand.MAIN_HAND) {
            MinecraftClient.getInstance().setScreenAndRender(new CottonClientScreen(new ThaumonomiconGui()));

            // testing sound
            MinecraftClient.getInstance()
                .getSoundManager().play(PositionedSoundInstance
                .master(SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, 1.0F));
        }

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        drawScreen(user, hand);
        return super.use(world, user, hand);
    }


}
