package map.ordering;

import list.search.Book;

import java.util.Comparator;
import java.util.Map;

public class Events {

    private String name;

    private String attraction;

    public Events(String name, String attraction) {
        this.name = name;
        this.attraction = attraction;
    }

    public String getName() {
        return name;
    }

    public String getAttraction() {
        return attraction;
    }

    @Override
    public String toString() {
        return " Name: "+ name + " " + attraction;
    }
}


