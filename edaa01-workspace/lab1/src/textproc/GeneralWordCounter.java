package textproc;

import java.util.*;

public class GeneralWordCounter implements TextProcessor {
    Map<String, Integer> words;
    Set<String> stopwords;

    public GeneralWordCounter(Set<String> stopwords) {
        this.words = new TreeMap<>();
        this.stopwords = stopwords;
    }


    @Override
    public void process(String w) {
        if(!stopwords.contains(w))
            words.put(w, (words.getOrDefault(w, 0)) + 1);
    }

    @Override
    public void report() {
/*
        for (String w : this.words.keySet()) {
            int count = this.words.get(w);

            if(count >= 200)
                System.out.println(w + ": " + count);
        }
*/
        Set<Map.Entry<String, Integer>> wordSet = this.words.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        wordList.sort(new WordCountComparator());

        for(int i = 0; i < 5; i++) {
            Map.Entry<String, Integer> entry = wordList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
