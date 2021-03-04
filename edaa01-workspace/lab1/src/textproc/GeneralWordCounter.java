package textproc;

import java.util.*;

public class GeneralWordCounter implements TextProcessor {
    Map<String, Integer> words;
    Set<String> stopwords;

    public GeneralWordCounter(Set<String> stopwords) {
        this.words = new TreeMap<>();
        this.stopwords = stopwords;
    }


    public void process(String w) {
        if(!stopwords.contains(w))
            words.put(w, (words.getOrDefault(w, 0)) + 1);
    }

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

        for(int i = 0; i < 20; i++) {
            Map.Entry<String, Integer> entry = wordList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
    public List<Map.Entry<String, Integer>> getWordList() {
    	return new ArrayList<>(this.words.entrySet());
    }
}
