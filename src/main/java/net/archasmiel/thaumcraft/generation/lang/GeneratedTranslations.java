package net.archasmiel.thaumcraft.generation.lang;

import net.archasmiel.thaumcraft.Thaumcraft;
import net.devtech.arrp.json.lang.JLang;
import net.minecraft.util.Identifier;

import java.util.HashMap;

import static net.archasmiel.thaumcraft.Thaumcraft.RESOURCE_PACK;

public class GeneratedTranslations {

    private final String modID;
    private final HashMap<String, JLang> translations = new HashMap<>();





    public GeneratedTranslations(String modID) {
        this.modID = modID;
    }





    public JLang getTranslation(String name) {
        return translations.containsKey(name) ? translations.get(name) : new JLang();
    }

    public void addTranslation(String name, JLang lang) {
        translations.put(name, lang);
    }

    public void registerLanguage(String lang) {
        RESOURCE_PACK.addLang(new Identifier(modID, lang), translations.get(lang));
        Thaumcraft.LOGGER.info("Registered " + modID + " lang data for " + lang);
    }

}
