package net.archasmiel.thaumcraft.generation.lang;

import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.lang.JLang;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;

import java.util.HashMap;

public class GeneratedTranslations {

    private final RuntimeResourcePack resourcePack;
    private final Logger logger;
    private final String modID;
    private final HashMap<String, JLang> translations = new HashMap<>();





    public GeneratedTranslations(RuntimeResourcePack resourcePack, String modID, Logger logger) {
        this.resourcePack = resourcePack;
        this.logger = logger;
        this.modID = modID;
    }





    public JLang getTranslation(String name) {
        return translations.containsKey(name) ? translations.get(name) : new JLang();
    }

    public void addTranslation(String name, JLang lang) {
        translations.put(name, lang);
    }

    public void registerLanguage(String lang) {
        resourcePack.addLang(new Identifier(modID, lang), translations.get(lang));
        logger.info("Registered {} lang data for {}", modID, lang);
    }

}
