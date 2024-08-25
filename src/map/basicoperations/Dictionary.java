package map.basicoperations;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map<String, String> definition;

    public Dictionary() {
        this.definition = new HashMap<>();
    }

    public void addDictionary(String word, String definition) {
        this.definition.put(word, definition);
    }

    public void removeDictionary(String word) {
        if (!definition.isEmpty()) {
            definition.remove(word);
        } else {
            System.out.println("The dictionary is empty");
        }
    }

    public void displayDictionary() {
        System.out.println(definition);
    }

    public String searchWord(String word) {
        String searchWord = null;
        if (!definition.isEmpty()) {
            searchWord = definition.get(word);
        }
        return searchWord;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        dictionary.addDictionary("Java: ", " Object-oriented programming language");
        dictionary.addDictionary("TypeScript: ", " Superset of the JavaScript language that adds static typing.");
        dictionary.addDictionary("Kotlin: ", " Modern programming language for the JVM");

        System.out.println("Showing all Words of dictionary: ");
        dictionary.displayDictionary();
        System.out.println("------------------------");


        System.out.println("Removing contacts: ");
        dictionary.removeDictionary("TypeScript: ");
        System.out.println("----------------------------");

        System.out.println("Showing all words now that some only they are removed : ");
        dictionary.displayDictionary();
        System.out.println("---------------------------------");

        System.out.println("Searching for word: ");
        System.out.println("The word is " + dictionary.searchWord("Java: "));


    }
}
