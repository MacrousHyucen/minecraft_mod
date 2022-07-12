package net.archasmiel.thaumcraft.generation.lang;


import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.archasmiel.thaumcraft.Thaumcraft;
import net.minecraft.util.JsonHelper;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

public class LanguageTranslations {

    private final String modID;
    private final HashMap<String, Language> languages = new HashMap<>();

    private static final Pattern TOKEN_PATTERN = Pattern.compile("%(\\d+\\$)?[\\d.]*[df]");




    public LanguageTranslations(String modID) {
        this.modID = modID;
    }




    public String getTranslation(String lang, String langEntry) {
        if (languages.containsKey(lang)){
            return languages.get(lang).get(langEntry);
        }

        Thaumcraft.LOGGER.info("Translation for " + langEntry + " not found in " + lang);
        return "";
    }

    public void putLanguage(String langName, Language language) {
        languages.put(langName, language);
    }

    public void readLanguage(String langName) {

        Gson GSON = new Gson();

        Language currentLang = getLanguage(langName);

        InputStream inputStream = net.minecraft.util.Language.class.getResourceAsStream(
                "/assets/" + modID + "/lang/" + langName + ".json"
        );

        JsonObject jsonObject = GSON.fromJson(
                new InputStreamReader(
                        Objects.requireNonNull(inputStream),
                        StandardCharsets.UTF_8
                ),
                JsonObject.class
        );

        BiConsumer<String, String> entryConsumer = ImmutableMap.builder()::put;



        for (Map.Entry<String, JsonElement> stringJsonElementEntry : jsonObject.entrySet()) {
            String string = TOKEN_PATTERN.matcher(JsonHelper.asString(
                    stringJsonElementEntry.getValue(),
                    stringJsonElementEntry.getKey())
            ).replaceAll("%$1s");

            currentLang.put(stringJsonElementEntry.getKey(), string);

            entryConsumer.accept(stringJsonElementEntry.getKey(), string);
        }

        languages.put(langName, currentLang);
    }

    public Language getLanguage(String langName) {
        if (languages.containsKey(langName)){
            return languages.get(langName);
        }

        return new Language();
    }





}
