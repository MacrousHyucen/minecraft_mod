package net.archasmiel.thaumcraft.init.item.items;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.ThaumcraftItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.*;
import static net.archasmiel.thaumcraft.lib.gen.WandcraftDataGen.wandModel;








public class WandThaumcraftItem extends ThaumcraftItem {

    private final String rod, cap, type;
    private final String rodName, capName;
    private final String genName;







    public WandThaumcraftItem(Item item, String rod, String cap, String type) {

        super(item, String.format("%s_%s_%s", type, rod.split("rod_")[1], cap.split("cap_")[1]));

        this.rodName = rod.split("rod_")[1];
        this.capName = cap.split("cap_")[1];
        this.genName = this.name();

        this.rod = rod;
        this.cap = cap;
        this.type = type;

    }







    @Override
    public void model() {

        // translation
        for (String lang: supportedLanguages) {
            THAUMCRAFT_LANG.addTranslation(
                    lang,
                    THAUMCRAFT_LANG.getTranslation(lang).item(
                            new Identifier(MOD_ID, genName),
                            String.format(
                                    "§e%s %s %s",
                                    THAUMCRAFT_LANGTRANS.getTranslation(
                                            lang,
                                            String.format("%s.%s.%s", "wand_cap", MOD_ID, capName)
                                    ),
                                    THAUMCRAFT_LANGTRANS.getTranslation(
                                            lang,
                                            String.format("%s.%s.%s", "wand_rod", MOD_ID, rodName)
                                    ),
                                    THAUMCRAFT_LANGTRANS.getTranslation(
                                            lang,
                                            String.format("%s.%s.%s", "wand_type", MOD_ID, type)
                                    )
                            )
                    )
            );
        }

        // model
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
