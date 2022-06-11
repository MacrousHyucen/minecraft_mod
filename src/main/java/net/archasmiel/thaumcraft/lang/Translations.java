package net.archasmiel.thaumcraft.lang;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.devtech.arrp.json.lang.JLang;
import net.minecraft.util.Identifier;

import java.util.HashMap;

import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class Translations {

    private final String modID;
    private final HashMap<String, JLang> translations = new HashMap<>();





    public Translations(String modID) {
        this.modID = modID;
    }





    public JLang getTranslation(String name) {
        return translations.containsKey(name) ? translations.get(name) : new JLang();
    }

    public void addTranslation(String name, JLang lang) {
        translations.put(name, lang);
    }

    public void register() {
        for (String i: translations.keySet()){
            RESOURCE_PACK.addLang(new Identifier(modID, i), translations.get(i));
            Thaumcraft.LOGGER.info("Registered lang " + i);
        }
    }

}
