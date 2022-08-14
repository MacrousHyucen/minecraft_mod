package net.archasmiel.thaumcraft.translation;

import net.archasmiel.thaumcraft.generation.lang.GeneratedTranslations;
import net.archasmiel.thaumcraft.generation.lang.LanguageTranslations;
import net.devtech.arrp.api.RuntimeResourcePack;
import org.slf4j.Logger;

public class Translations {

    private final String[] supportedLanguages;
    private final LanguageTranslations inputLang;
    private final GeneratedTranslations outputLang;

    public Translations(RuntimeResourcePack resourcePack, String modId, Logger logger, String... supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
        inputLang = new LanguageTranslations(modId, logger);
        outputLang = new GeneratedTranslations(resourcePack, modId, logger);
    }





    public String[] getSupportedLanguages() {
        return supportedLanguages;
    }

    public LanguageTranslations getInput() {
        return inputLang;
    }

    public GeneratedTranslations getOutput() {
        return outputLang;
    }

    public void loadInput() {
        for (String i: supportedLanguages)
            inputLang.readLanguage(i);
    }

    public void pushOutput() {
        for (String i: supportedLanguages)
            outputLang.registerLanguage(i);
    }

}
