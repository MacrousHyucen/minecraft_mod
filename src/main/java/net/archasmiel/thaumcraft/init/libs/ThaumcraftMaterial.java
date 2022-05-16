package net.archasmiel.thaumcraft.init.libs;


import net.archasmiel.thaumcraft.init.item.Materials;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;


public enum ThaumcraftMaterial implements ToolMaterial {
    // 0 - wood/gold, 1 - stone, 2 - iron, 3 - diamond, 4 - netherite

    THAUMIUMIUM(3, 400, 7.0F, 3.0F, 18,
            Ingredient.ofItems(Materials.THAUMIUM_INGOT), false
    ),
    ELEMENTAL(3, 1561, 8.0F, 4.0F, 18,
            Ingredient.ofItems(Items.DIAMOND), false
    ),
    VOID(3, 150, 7.0F, 4.0F, 18,
            Ingredient.ofItems(Materials.VOID_METAL_INGOT), true
    );

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;
    private final boolean selfRepairable;

    ThaumcraftMaterial(int miningLevel, int itemDurability,
                       float miningSpeed, float attackDamage,
                       int enchantability, Ingredient repairIngredient,
                       boolean selfRepairable) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
        this.selfRepairable = selfRepairable;
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

    public boolean getSelfRepairable() {
        return this.selfRepairable;
    }
}
