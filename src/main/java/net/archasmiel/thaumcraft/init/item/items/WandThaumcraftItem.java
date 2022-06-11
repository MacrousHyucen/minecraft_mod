package net.archasmiel.thaumcraft.init.item.items;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.ThaumcraftItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;


import static net.archasmiel.thaumcraft.Thaumcraft.*;
import static net.archasmiel.thaumcraft.lib.gen.WandcraftDataGen.wandModel;








public class WandThaumcraftItem extends ThaumcraftItem {

    private final String rod, cap, type;
    private final String genName;







    public WandThaumcraftItem(Item item, String rod, String cap, String type) {

        super(item, String.format("%s_%s_%s", type, rod.split("rod_")[1], cap.split("cap_")[1]));

        this.genName = this.name();
        this.rod = rod;
        this.cap = cap;
        this.type = type;

    }







    @Override
    public void model() {

        String EN_US_name = String.format("%s %s capped %s", rod.split("rod_")[1], cap.split("cap_")[1], type);
        String RU_RU_name = "Тестовое название";
        String ZH_CN_name = "基础学";


        // lang translation testing
        // TODO
        // add translations from lang file and compose them
        THAUMCRAFT_LANG.addTranslation(
                "en_us",
                THAUMCRAFT_LANG.getTranslation("en_us").item(
                        new Identifier("thaumcraft:" + genName),
                        EN_US_name
                )
        );


        THAUMCRAFT_LANG.addTranslation(
                "ru_ru",
                THAUMCRAFT_LANG.getTranslation("ru_ru").item(
                        new Identifier("thaumcraft:" + genName),
                        RU_RU_name
                )
        );

        THAUMCRAFT_LANG.addTranslation(
                "zh_cn",
                THAUMCRAFT_LANG.getTranslation("zh_cn").item(
                        new Identifier("thaumcraft:" + genName),
                        ZH_CN_name
                )
        );



        RESOURCE_PACK.addModel(
                wandModel(rod, cap),
                new Identifier("thaumcraft:item/" + genName)
        );

    }

    @Override
    public void register() {

        if (color() == 0x000000)
            setItem( Register.registerItem(genName, item()) );
        else
            setItem( Register.registerItem(genName, item(), color()) );

        setRegistered(true);
    }

    @Override
    public void load() {
        model();
        register();
    }

}
