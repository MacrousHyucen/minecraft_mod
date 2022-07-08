package net.archasmiel.thaumcraft.item.wandcraft.variants;

import net.archasmiel.thaumcraft.item.wandcraft.abilities.FociWear;
import net.archasmiel.thaumcraft.item.wandcraft.abilities.VisCraft;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.archasmiel.thaumcraft.lib.generation.WandDataGeneration;
import net.archasmiel.thaumcraft.lib.recipegen.WandRecipeGenerator;
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

public class Wand extends WandAbstract implements VisCraft, FociWear {

    public Wand(Settings settings, RodMaterials rod, CapMaterials cap) {
        super(
            settings,
            String.format("%s_%s_%s", "wand", rod.getMaterialName(), cap.getMaterialName()),
            rod,
            cap,
            0.00f,
            1.00f,
            "wand"
        );
        load();
    }




    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        if (group == MOD_GROUP_GENERATED) {
            ItemStack wand = new ItemStack(this, 1);
            NbtCompound nbt = wand.getNbt() != null ? wand.getNbt() : new NbtCompound();
            for (String i: primaryAspects) {
                nbt.putFloat(i, this.getCapacity());
            }
            wand.setNbt(nbt);
            stacks.add(wand);
        }
    }






    @Override
    public void model() {
        // lang translation
        for (String lang: supportedLanguages) {
            THAUMCRAFT_OUTPUTLANG.addTranslation(
                lang,
                THAUMCRAFT_OUTPUTLANG.getTranslation(lang).item(
                    new Identifier(MOD_ID, name()),
                    String.format(
                        "§e%s %s %s",
                        THAUMCRAFT_INPUTLANG.getTranslation(
                                lang,
                                String.format("%s.%s.%s", "wand_cap", MOD_ID, this.getCap().getMaterialName())
                        ),
                        THAUMCRAFT_INPUTLANG.getTranslation(
                                lang,
                                String.format("%s.%s.%s", "wand_rod", MOD_ID, this.getRod().getMaterialName())
                        ),
                        THAUMCRAFT_INPUTLANG.getTranslation(
                                lang,
                                String.format("%s.%s.%s", "wand_type", MOD_ID, this.getType())
                        )
                    )
                )
            );
        }

        // model
        RESOURCE_PACK.addModel(
                WandDataGeneration.wandModel(getRod().getRegistryName(), getCap().getRegistryName()),
                new Identifier("thaumcraft:item/" + name())
        );

        // recipe
        WandRecipeGenerator.wandRecipe(this);
    }

    @Override
    public void register() {
        setItem(Register.registerItem(name(), this));
    }
}
