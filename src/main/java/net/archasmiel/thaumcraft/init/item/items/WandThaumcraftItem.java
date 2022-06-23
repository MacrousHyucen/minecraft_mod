package net.archasmiel.thaumcraft.init.item.items;

import net.archasmiel.thaumcraft.init.Register;
import net.archasmiel.thaumcraft.init.item.ThaumcraftItem;
import net.archasmiel.thaumcraft.item.wandcraft.WandAbstract;
import net.minecraft.util.Identifier;

import static net.archasmiel.thaumcraft.Thaumcraft.*;
import static net.archasmiel.thaumcraft.lib.gen.WandcraftDataGen.wandModel;








public class WandThaumcraftItem extends ThaumcraftItem {

    private WandAbstract wandItem;

    public WandAbstract getWandItem() {
        return wandItem;
    }
    public void setWandItem(WandAbstract wandItem) {
        this.wandItem = wandItem;
    }





    public WandThaumcraftItem(WandAbstract item) {

        super(
            item,
            String.format(
                "%s_%s_%s",
                item.getType(),
                item.getRod().getMaterialName(),
                item.getCap().getMaterialName()
            )
        );

        this.setWandItem(item);
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
                                            String.format("%s.%s.%s", "wand_cap", MOD_ID, wandItem.getCap().getMaterialName())
                                    ),
                                    THAUMCRAFT_INPUTLANG.getTranslation(
                                            lang,
                                            String.format("%s.%s.%s", "wand_rod", MOD_ID, wandItem.getRod().getMaterialName())
                                    ),
                                    THAUMCRAFT_INPUTLANG.getTranslation(
                                            lang,
                                            String.format("%s.%s.%s", "wand_type", MOD_ID, wandItem.getType())
                                    )
                            )
                    )
            );
        }

        // model
        RESOURCE_PACK.addModel(
            wandModel(wandItem.getRod().getRegistryName(), wandItem.getCap().getRegistryName()),
            new Identifier("thaumcraft:item/" + name())
        );

    }

    public void register() {

        if (color() == 0x000000)
            setItem( Register.registerItem(name(), item()) );
        else
            setItem( Register.registerItem(name(), item(), color()) );

        setRegistered(true);
    }

    public void load() {
        model();
        register();
    }

}
