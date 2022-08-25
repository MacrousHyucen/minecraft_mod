package net.archasmiel.thaumcraft.screen.thaumonomicon.research.basic;

import java.util.*;

public class TabResearchMap {

    public static class Entry {

        private final ResearchBox key;
        private final List<ResearchBox> values;



        public Entry(ResearchBox key, List<ResearchBox> values) {
            this.key = key;
            this.values = values;
        }

        public Entry(ResearchBox key, ResearchBox... values) {
            this.key = key;
            this.values = Arrays.asList(values);
        }



        public ResearchBox getKey() {
            return key;
        }

        public List<ResearchBox> getValues() {
            return values;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry entry = (Entry) o;

            if (!Objects.equals(key, entry.key)) return false;
            return Objects.equals(values, entry.values);
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (values != null ? values.hashCode() : 0);
            return result;
        }
    }




    private final List<Entry> nodes;

    public TabResearchMap() {
        nodes = new ArrayList<>();
    }





    public void put(ResearchBox main, ResearchBox... aux) {
        nodes.add(new Entry(main, aux));
    }

    public void put(ResearchBox main, List<ResearchBox> aux) {
        nodes.add(new Entry(main, aux));
    }

    public List<ResearchBox> get(ResearchBox key) {
        Optional<Entry> opt = nodes.stream().filter(e -> e.getKey().equals(key)).findFirst();
        if (opt.isPresent()) {
            return opt.get().getValues();
        }
        throw new IllegalArgumentException("Not found key='" + key + "' in research map!");
    }

    public void clear() {
        nodes.clear();
    }

    public List<Entry> getNodes() {
        return new ArrayList<>(nodes);
    }

    public List<ResearchBox> keyList() {
        List<ResearchBox> boxes = new ArrayList<>();
        for (Entry entry: nodes) {
            boxes.add(entry.key);
        }
        return boxes;
    }

    public List<List<ResearchBox>> valuesList() {
        List<List<ResearchBox>> boxes = new ArrayList<>();
        for (Entry entry: nodes) {
            boxes.add(entry.values);
        }
        return boxes;
    }

}
