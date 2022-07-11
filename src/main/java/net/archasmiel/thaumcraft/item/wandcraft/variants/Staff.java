package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.abilities.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.WandWeapon;
import net.archasmiel.thaumcraft.lib.generation.WandcraftDataGenerator;
import net.archasmiel.thaumcraft.lib.recipegen.WandcraftRecipeGenerator;
import net.archasmiel.thaumcraft.materials.CapMaterials;
import net.archasmiel.thaumcraft.materials.RodMaterials;
import net.archasmiel.thaumcraft.register.Register;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import static net.archasmiel.thaumcraft.Thaumcraft.*;
import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class Staff extends WandAbstract implements WandWeapon, FociWear {

    public Staff(Settings settings, RodMaterials rod, CapMaterials cap) {
        super(
            settings,
            String.format("%s_%s_%s", "staff", rod.getMaterialName(), cap.getMaterialName()),
            rod,
            cap,
            0.00f,
            2.50f,
            "staff"
        );
        load();
    }




    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        if (group == MOD_GROUP_GENERATED) {
            ItemStack staff = new ItemStack(this, 1);
            NbtCompound nbt = staff.getNbt() != null ? staff.getNbt() : new NbtCompound();
            for (String i: primaryAspects) {
                nbt.putFloat(i, this.getCapacity());
            }
            staff.setNbt(nbt);
            stacks.add(staff);
        }
    }






    @Override
    public void model() {
        // lang translation
        WandcraftDataGenerator.wandcraftName(this);

        // model
        RESOURCE_PACK.addModel(
                WandcraftDataGenerator.staffModel(getRod().getRegistryName(), getCap().getRegistryName()),
                new Identifier("thaumcraft:item/" + name())
        );

        // recipe
        WandcraftRecipeGenerator.staffRecipe(this);
    }

    @Override
    public void register() {
        setItem(Register.registerItem(name(), this));
    }
}
