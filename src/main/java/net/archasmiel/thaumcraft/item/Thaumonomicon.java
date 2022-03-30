package net.archasmiel.thaumcraft.item;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.archasmiel.thaumcraft.gui.ThaumonomiconGui;
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

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftClient.getInstance().setScreen();
        return super.use(world, user, hand);
    }
}
