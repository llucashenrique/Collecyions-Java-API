package set.basicoperation;

import java.util.HashSet;
import java.util.Set;

public class SingleWords {

    private Set<String> singleWordSet;

    public SingleWords() {
        this.singleWordSet = new HashSet<>();
    }

    public void addSingleWord(String word) {
       singleWordSet.add(word);
    }

    public void removeSingleWord(String word) {
        if (!singleWordSet.isEmpty()) {
            if (singleWordSet.contains(word)) {
               singleWordSet.remove(word);
            } else {
                System.out.println("The word is not in the set");
            }
        } else {
            System.out.println("The set is empty");
        }
    }

    public boolean checkWord(String word) {
        return this.singleWordSet.contains(word);
    }

    public void displaySingleWord() {
        if (!singleWordSet.isEmpty()) {
            System.out.println(singleWordSet);
        } else {
            System.out.println("The set is empty");
        }
    }


    public static void main(String[] args) {
        SingleWords setLanguage = new SingleWords();

        setLanguage.addSingleWord("Java");
        setLanguage.addSingleWord("Phyton");
        setLanguage.addSingleWord("JavaScript");
        setLanguage.addSingleWord("Phyton");
        setLanguage.addSingleWord("C++");
        setLanguage.addSingleWord("Ruby");


        setLanguage.displaySingleWord();


        setLanguage.removeSingleWord("Phyton");
        setLanguage.displaySingleWord();

        setLanguage.removeSingleWord("Swift");

        System.out.println("The language 'Java' there are in set?  " + setLanguage.checkWord("Java"));
        System.out.println("The language 'Phyton' there are in set?  " + setLanguage.checkWord("Phyton"));


        setLanguage.displaySingleWord();

    }
}
