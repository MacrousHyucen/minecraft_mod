package net.archasmiel.thaumcraft.lang;

import java.util.HashMap;

public class Language {

    private final HashMap<String, String> translation = new HashMap<>();





    public Language() {
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
