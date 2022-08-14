package net.archasmiel.thaumcraft.generation.lang;

import java.util.HashMap;

public class Language {

    private final HashMap<String, String> translation;





    public Language() {
        translation = new HashMap<>();
    }





    public boolean hasEntry(String entry) {
        return translation.containsKey(entry);
    }

    public String get(String entry) {
        return hasEntry(entry) ? translation.get(entry) : "";
    }

    public void put(String entry, String value) {
        translation.put(entry, value);
    }

}
