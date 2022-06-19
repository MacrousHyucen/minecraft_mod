package net.archasmiel.thaumcraft.item.wandcraft;

import net.archasmiel.thaumcraft.init.libs.CapMaterials;
import net.archasmiel.thaumcraft.init.libs.RodMaterials;
import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Cap;
import net.archasmiel.thaumcraft.item.wandcraft.ingredients.Rod;
import net.archasmiel.thaumcraft.item.wandcraft.variants.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.variants.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Weapon;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.util.ChatMessages;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static net.archasmiel.thaumcraft.Thaumcraft.primaryAspects;

public class Wand extends WandAbstract implements VisCraft, Weapon, FociWear {

    public Wand(Settings settings, CapMaterials cap, RodMaterials rod) {
        super(settings, rod, cap, 0.00f, 1.00f);
    }

    @Override
    public void postProcessNbt(NbtCompound nbt) {
        nbt.putFloat("aer", 0);
        nbt.putFloat("ignis", 0);
        nbt.putFloat("aqua", 0);
        nbt.putFloat("terra", 0);
        nbt.putFloat("ordo", 0);
        nbt.putFloat("perditio", 0);
        super.postProcessNbt(nbt);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound nbt = stack.getNbt();
        stack.setNbt(checkWandNbt(nbt));
        nbt = stack.getNbt();

        tooltip.add(getVisFromNbt(nbt));

        super.appendTooltip(stack, world, tooltip, context);
    }

    private NbtCompound checkWandNbt(NbtCompound nbt) {
        if (nbt == null)
            nbt = new NbtCompound();
        for (String i: primaryAspects)
            if (!nbt.contains(i))
                nbt.putFloat(i, 0);
        return nbt;
    }


    private LiteralText getVisFromNbt(NbtCompound nbt) {
        HashMap<String, String> visData = new HashMap<>();

        for (String i: primaryAspects)
            if (nbt.contains(i))
                visData.put(i, String.valueOf(nbt.getFloat(i)));

        return new LiteralText(
                Formatting.YELLOW + visData.get(primaryAspects[0]) +
                Formatting.GRAY + " | " +
                Formatting.RED + visData.get(primaryAspects[1]) +
                Formatting.GRAY + " | " +
                Formatting.AQUA + visData.get(primaryAspects[2]) +
                Formatting.GRAY + " | " +
                Formatting.GREEN + visData.get(primaryAspects[3]) +
                Formatting.GRAY + " | " +
                Formatting.WHITE + visData.get(primaryAspects[4]) +
                Formatting.GRAY + " | " +
                Formatting.DARK_GRAY + visData.get(primaryAspects[5])
        );
    }

    @Override
    public boolean canWearFoci() {
        return true;
    }

    @Override
    public boolean canVisCraft() {
        return true;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }
}
