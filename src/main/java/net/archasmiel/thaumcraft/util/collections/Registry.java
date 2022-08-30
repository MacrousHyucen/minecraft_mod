package net.archasmiel.thaumcraft.util.collections;

import net.archasmiel.thaumcraft.screen.thaumonomicon.lib.Identified;

import java.util.*;

public class Registry<T extends Identified> {

    public static class Entry<T extends Identified> {

        private final String key;
        private final T value;



        public Entry(String key, T value) {
            this.key = key;
            this.value = value;
        }

        public Entry(T value) {
            this.key = value.getId();
            this.value = value;
        }



        public String getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

    }




    private final List<Entry<T>> entries;



    public Registry() {
        entries = new ArrayList<>();
    }


    public boolean containsKey(String key) {
        for (Entry<T> entry: entries)
            if (key.equals(entry.key))
                return true;
        return false;
    }




    public void registerAll(List<T> values) {
        for (T value: values)
            register(value.getId(), value);
    }

    @SafeVarargs
    public final void registerAll(T... values) {
        for (T value: values)
            register(value.getId(), value);
    }



    public void register(T value) {
        register(value.getId(), value);
    }

    public void register(String key, T value) {
        if (containsKey(key))
            throw new IllegalStateException("Already registered key '" + key + "'");
        entries.add(new Entry<>(key, value));
    }



    public T getById(String key) {
        for (Entry<T> entry: entries)
            if (entry.key.equals(key))
                return entry.value;
        throw new IllegalStateException("Not registered key '" + key + "'");
    }



    public List<String> keyList() {
        return entries.stream().map(e -> e.key).toList();
    }

    public List<Entry<T>> entryList() {
        return entries;
    }

    public List<T> valueList() {
        return entries.stream().map(e -> e.value).toList();
    }

}
