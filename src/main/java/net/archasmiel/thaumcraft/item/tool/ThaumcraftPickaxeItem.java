package net.archasmiel.thaumcraft.item.tool;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.archasmiel.thaumcraft.generation.ThaumcraftRegistry;
import net.archasmiel.thaumcraft.item.tool.abilities.Repairable;
import net.archasmiel.thaumcraft.register.Register;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class ThaumcraftPickaxeItem extends PickaxeItem {

    private final String name;
    private Item item;

    public ThaumcraftPickaxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, String name) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.name = name;
        load();
    }



    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        if (entity instanceof PlayerEntity player){
            ItemStack slotItemStack = player.getInventory().getStack(slot);
            Repairable.repairTick(slotItemStack, player.getWorld().getTime());
        }
    }



    public void setItem(Item item) {
        this.item = item;
    }
    public Item item() {
        return item;
    }
    public String name() {
        return name;
    }



    public void model() {
        ThaumcraftRegistry.simpleItemModel(Thaumcraft.MOD_ID, "handheld", name, name);
    }
    public void register() {
        setItem(Register.registerItem(name(), this));
    }
    public void load() {
        model();
        register();
    }
}
