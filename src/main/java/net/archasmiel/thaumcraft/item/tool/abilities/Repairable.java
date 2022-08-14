package net.archasmiel.thaumcraft.item.tool.abilities;

import net.archasmiel.thaumcraft.materials.tools.ToolMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.nbt.NbtCompound;

public class Repairable {

    private Repairable() {

    }

    private static final String NBT_DAMAGE_KEY = "Damage";
    public static final String NBT_REPAIR_COUNTER = "ThaumcraftRepairCounter";

    private static void repair(ItemStack thisItem, long currentTime) {
        NbtCompound nbt = thisItem.getNbt();
        if (nbt != null && nbt.getInt(NBT_DAMAGE_KEY) > 0){
            long timeElapsed = currentTime - nbt.getLong(NBT_REPAIR_COUNTER);
            if (timeElapsed <= 0) {
                nbt.putLong(NBT_REPAIR_COUNTER, currentTime);
                nbt.putInt(NBT_DAMAGE_KEY, nbt.getInt(NBT_DAMAGE_KEY) - 1);
            }
            if (timeElapsed >= 20) {
                nbt.putLong(NBT_REPAIR_COUNTER, currentTime);
                nbt.putInt(NBT_DAMAGE_KEY, nbt.getInt(NBT_DAMAGE_KEY) - 1);
            }
            thisItem.setNbt(nbt);
        }
    }

    public static void repairTick(ItemStack thisItem, long currentTime) {
        if (thisItem.getItem() instanceof ToolItem item &&
            item.getMaterial() instanceof ToolMaterials material &&
            material.getSelfRepairable()){
                repair(thisItem, currentTime);
        }
    }

}
