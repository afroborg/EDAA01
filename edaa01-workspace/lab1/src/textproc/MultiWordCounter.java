package textproc;

import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
    private Map<String, Integer> words;

    public MultiWordCounter(String[] words) {
        this.words = new TreeMap<>();

        for (String w : words) {
            this.words.put(w, 0);
        }
    }

    public void process(String w) {
        if(this.words.containsKey(w))
            this.words.put(w, this.words.get(w) + 1);
    }

    public void report() {
        for (String w : this.words.keySet()) {
            System.out.println(w + ": " + this.words.get(w));
        }
    }
}
