package map.ordering;

import list.search.Book;

import java.util.Comparator;
import java.util.Map;

public class Books  {

    private String title;
    private String author;
    private double price;

    public Books( String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Author: " + author + ", Title: " + title +  ", Price: " + price+ " \n";
    }
}

class ComparatorByPrice implements Comparator<Map.Entry<String, Books>> {
    @Override
    public int compare(Map.Entry<String, Books> b1, Map.Entry<String, Books> b2) {
        return Double.compare(b1.getValue().getPrice(), b2.getValue().getPrice());
    }
}

    class ComparatorByAuthor implements Comparator<Map.Entry<String, Books>> {
        @Override
        public int compare(Map.Entry<String, Books> a1, Map.Entry<String, Books> a2) {
            return a1.getValue().getAuthor().compareToIgnoreCase(a2.getValue().getAuthor());
        }
    }
