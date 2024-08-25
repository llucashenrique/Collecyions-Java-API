package map.search;

import java.util.HashMap;
import java.util.Map;

public class CountingWords {

    private Map<String, Integer> coutingWordsMap;

    public CountingWords() {
        this.coutingWordsMap = new HashMap<>();
    }


    public void addWord(String word, Integer counting) {
        coutingWordsMap.put(word, counting);
    }

    public void removeWords(String word) {
        if (!coutingWordsMap.isEmpty()) {
            coutingWordsMap.remove(word);
        } else {
            System.out.println("The Counting Words Map is Empty");
        }
    }

    public void displayWords() {
        System.out.println(coutingWordsMap);
    }

    public Integer fiendWordMoreFrequency(String word) {
        Integer wordMoreFrequency = null;
        if (!coutingWordsMap.isEmpty()) {
            wordMoreFrequency = coutingWordsMap.get(word);
        }
        return wordMoreFrequency;
    }


    public static void main(String[] args) {
        CountingWords countingWords = new CountingWords();

        countingWords.addWord("Monkey", 1);
        countingWords.addWord("Table", 2);
        countingWords.addWord("Person", 3);
        countingWords.addWord("Key", 4);

        System.out.println("Showing all Words: ");
        countingWords.displayWords();
        System.out.println("--------------------");

        System.out.println("Removing Words: ");
        countingWords.removeWords("Monkey");
        System.out.println("----------------------");

        System.out.println("Showing all words now that some only they are removed : ");
        countingWords.displayWords();
        System.out.println("-----------------------");

        System.out.println("Searching for Word: ");
        System.out.println("The word is: " + countingWords.fiendWordMoreFrequency("Table"));


    }
}

