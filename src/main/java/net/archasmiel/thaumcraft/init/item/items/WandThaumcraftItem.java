package net.archasmiel.thaumcraft.init.item.items;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.ThaumcraftItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;


import static net.archasmiel.thaumcraft.Thaumcraft.*;
import static net.archasmiel.thaumcraft.lib.gen.WandcraftDataGen.wandModel;


public class WandThaumcraftItem extends ThaumcraftItem {

    private final String rod, cap, type;


    public WandThaumcraftItem(Item item, String name, String rod, String cap, String type) {
        super(item, name);
        this.rod = rod;
        this.cap = cap;
        this.type = type;
    }

    @Override
    public void model() {
        String gen_name = String.format("%s_%s_%s", type, rod.split("rod_")[1], cap.split("cap_")[1]);
        String EN_US_name = String.format("%s %s capped %s", rod.split("rod_")[1], cap.split("cap_")[1], type);


        // lang translation testing
        // normal text here
        EN_US_lang.item(
                new Identifier("thaumcraft:" + gen_name),
                EN_US_name
        );

        // TODO
        // charset error
        RU_RU_lang.item(
                new Identifier("thaumcraft:" + gen_name),
                "Тестовое название"
        );


        // same charset error
        // new String("", charset)   - only gets more weird
        // new TranslationText()     - doesn't fit here
        ZN_CN_lang.item(
                new Identifier("thaumcraft:" + gen_name),
                "基础学"
        );




        RESOURCE_PACK.addModel(
                wandModel(rod, cap),

                new Identifier("thaumcraft:item/" + String.format("%s_%s_%s", type, rod.split("rod_")[1], cap.split("cap_")[1]))

        );


        // identifier of model
        // String.format("thaumcraft:item/%s_%s_%s", type, rod.split("rod_")[1], cap.split("cap_")[1]);

    }

    @Override
    public void register() {
        // auto-gen registry name
        String gen_name = String.format("%s_%s_%s", type, rod.split("rod_")[1], cap.split("cap_")[1]);

        if (color() == 0x000000)
            setItem( Register.registerItem(gen_name, item()) );
        else
            setItem( Register.registerItem(gen_name, item(), color()) );

        setRegistered(true);
    }

    @Override
    public void load() {
        model();
        register();
    }

}
