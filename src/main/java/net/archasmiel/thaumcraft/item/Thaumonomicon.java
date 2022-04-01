package net.archasmiel.thaumcraft.item;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.archasmiel.thaumcraft.gui.thaumonomicon.ThaumonomiconGui;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Thaumonomicon extends Item {


    public Thaumonomicon(Settings settings) {
        super(settings);
    }

    private void drawScreen(World world) {
        if (world.isClient) MinecraftClient.getInstance().setScreenAndRender(new CottonClientScreen(new ThaumonomiconGui()));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        drawScreen(world);
        return super.use(world, user, hand);
    }


}
