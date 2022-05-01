package net.archasmiel.thaumcraft.init.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class ThaumcraftSword extends SwordItem {
    public ThaumcraftSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
}
