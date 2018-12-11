/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part A of Assignment 4
 */

import java.util.Comparator;

public class EntryComparator implements Comparator<Entry<String, Integer>> {
    public int compare(Entry<String,Integer> a, Entry<String,Integer> b) {
        return b.getValue().compareTo(a.getValue());
    }
}
