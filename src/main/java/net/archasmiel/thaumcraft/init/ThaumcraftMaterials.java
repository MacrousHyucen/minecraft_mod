package net.archasmiel.thaumcraft.init;

import java.util.function.Supplier;

import net.archasmiel.thaumcraft.init.item.Materials;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.Lazy;


public enum ThaumcraftMaterials implements ToolMaterial {
    // 0 - wood/gold, 1 - stone, 2 - iron, 3 - diamond, 4 - netherite

    THAUMIUMIUM(3, 400, 7.0F, 3.0F, 18,
            Ingredient.ofItems(Materials.THAUMIUM_INGOT)
    ),
    ELEMENTAL(3, 1561, 8.0F, 4.0F, 18,
            Ingredient.ofItems(Items.DIAMOND)
    ),
    VOID(3, 150, 7.0F, 4.0F, 18,
            Ingredient.ofItems(Materials.VOID_METAL_INGOT)
    ),



    WOOD(0, 59, 2.0F, 0.0F, 15, Ingredient.fromTag(ItemTags.PLANKS)),
    STONE(1, 131, 4.0F, 1.0F, 5, Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),
    IRON(2, 250, 6.0F, 2.0F, 14, Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND(3, 1561, 8.0F, 3.0F, 10, Ingredient.ofItems(Items.DIAMOND)),
    GOLD(0, 32, 12.0F, 0.0F, 22, Ingredient.ofItems(Items.GOLD_INGOT)),
    NETHERITE(4, 2031, 9.0F, 4.0F, 15, Ingredient.ofItems(Items.NETHERITE_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;

    ThaumcraftMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Ingredient repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
