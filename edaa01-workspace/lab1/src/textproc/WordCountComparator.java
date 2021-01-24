package textproc;

import java.util.*;

public class WordCountComparator implements Comparator<Map.Entry<String,Integer>> {

    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        int value = o2.getValue() - o1.getValue();
        if(value == 0) {
            return o1.getKey().compareTo(o2.getKey());
        }
        return value;
    }
}
