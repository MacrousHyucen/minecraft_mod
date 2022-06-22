package net.archasmiel.thaumcraft.item.wandcraft;

import net.archasmiel.thaumcraft.init.libs.CapMaterials;
import net.archasmiel.thaumcraft.init.libs.RodMaterials;
import net.archasmiel.thaumcraft.item.wandcraft.variants.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.variants.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.variants.Weapon;
import net.fabricmc.loader.impl.util.StringUtil;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

import static net.archasmiel.thaumcraft.Thaumcraft.primaryAspects;
import static net.archasmiel.thaumcraft.Thaumcraft.primaryAspectsColor;
import static net.minecraft.util.Formatting.GOLD;

public class Wand extends WandAbstract implements VisCraft, Weapon, FociWear {

    public Wand(Settings settings, RodMaterials rod, CapMaterials cap) {
        super(settings, rod, cap, 0.00f, 1.00f);
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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        // nbt get&check
        NbtCompound nbt = stack.getNbt();
        nbt = checkWandNbt(nbt);
        stack.setNbt(nbt);


        // collecting vis information
        HashMap<String, Float> visData = new HashMap<>();
        for (String i: primaryAspects)
            visData.put(i, nbt.getFloat(i));



        if (Screen.hasShiftDown()) {
            // only capacity tooltip
            tooltip.add(
                    new LiteralText("")
                    .append(new TranslatableText("gui.thaumcraft.wand_capacity").append(this.getCapacity() + " ").formatted(GOLD))
            );

            // all aspects information (6 lines)
            for (int i = 0 ; i < primaryAspects.length ; i++)
                tooltip.add(
                        new LiteralText("")
                        .append(String.format(
                                " %s%s §f× %s, ",
                                primaryAspectsColor[i],
                                StringUtil.capitalize(primaryAspects[i]),
                                uncutFloat(visData.get(primaryAspects[i]))
                        ))
                        .append("§f(" + getStringDiscount(this.getDiscount()) + "%")
                        .append(new TranslatableText("gui.thaumcraft.vis_cost"))
                        .append(")")
                );
        } else {
            // capacity and vis discount information
            tooltip.add(
                    new LiteralText("")
                    .append(new TranslatableText("gui.thaumcraft.wand_capacity").append(this.getCapacity() + " ").formatted(GOLD))
                    .append("§f(" + getStringDiscount(this.getDiscount()) + "%")
                    .append(new TranslatableText("gui.thaumcraft.vis_cost"))
                    .append(")")
            );

            // one-line information about vis
            tooltip.add(
                    Text.of(
                            String.format(
                                    "%s%s §f§l╎ %s%s §f§l╎ %s%s §f§l╎ %s%s §f§l╎ %s%s §f§l╎ %s%s",
                                    primaryAspectsColor[0], cutFloat(visData.get(primaryAspects[0])),
                                    primaryAspectsColor[1], cutFloat(visData.get(primaryAspects[1])),
                                    primaryAspectsColor[2], cutFloat(visData.get(primaryAspects[2])),
                                    primaryAspectsColor[3], cutFloat(visData.get(primaryAspects[3])),
                                    primaryAspectsColor[4], cutFloat(visData.get(primaryAspects[4])),
                                    primaryAspectsColor[5], cutFloat(visData.get(primaryAspects[5]))
                            )
                    )
            );
        }

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

    private String getStringDiscount(float discount) {
        return Integer.toString((int) ((1 + discount) * 100));
    }

    private String cutFloat(float num) {
        return String.valueOf((int) num);
    }

    private String uncutFloat(float num) {
        return String.valueOf(num);
    }
}
