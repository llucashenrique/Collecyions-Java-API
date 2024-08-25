package map.ordering;


import java.util.*;

public class LibraryOnline {

    private Map<String, Books> booksMap;

    public LibraryOnline() {
        this.booksMap = new HashMap<>();
    }

    public void addBook(String link, Books book) {
        booksMap.put(link, book);
    }

    public void removeBook(String title) {
        List<String> keysRemove = new ArrayList<>();
        for (Map.Entry<String, Books> entry : booksMap.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                keysRemove.add(entry.getKey());
            }
        }
        for (String key : keysRemove) {
            booksMap.remove(key);
        }
    }

    public Map<String, Books> displayBooksOrderedByPrice() {
        List<Map.Entry<String, Books>> booksToOrderByPrice = new ArrayList<>(booksMap.entrySet());

        Collections.sort(booksToOrderByPrice, new ComparatorByPrice());

        Map<String, Books> sortedBooksByPrice = new LinkedHashMap<>();

        for (Map.Entry<String, Books> entry : booksToOrderByPrice) {
            sortedBooksByPrice.put(entry.getKey(), entry.getValue());
        }
        return sortedBooksByPrice;
    }

    public Map<String, Books> displayBooksOrderedByAuthor() {
        List<Map.Entry<String, Books>> booksToOrderByAuthor = new ArrayList<>(booksMap.entrySet());

        Collections.sort(booksToOrderByAuthor, new ComparatorByAuthor());

        Map<String, Books> sortedBooksByAuthor = new LinkedHashMap<>();

        for (Map.Entry<String, Books> entry : booksToOrderByAuthor) {
            sortedBooksByAuthor.put(entry.getKey(), entry.getValue());
        }
        return sortedBooksByAuthor;
    }

    public Map<String, Books> searchBooksByAuthor(String author) {
        Map<String, Books> booksByAuthor = new LinkedHashMap<>();
        for (Map.Entry<String, Books> entry : booksMap.entrySet()) {
            Books book = entry.getValue();
            if (book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.put(entry.getKey(), book);
            }
        }
        return booksByAuthor;
    }

    public List<Books> gettingBookMoreExpensive() {
        List<Books> booksMoreExpensive = new ArrayList<>();
        double priceMoreHighest = Double.MIN_VALUE;

        if (!booksMap.isEmpty()) {
            for (Books book : booksMap.values()) {
                if (book.getPrice() > priceMoreHighest) {
                    priceMoreHighest = book.getPrice();
                }
            }
        } else {
            throw new NoSuchElementException("The Library is empty");
        }

        for (Map.Entry<String, Books> entry : booksMap.entrySet()) {
            if (entry.getValue().getPrice() == priceMoreHighest) {
                Books bookWithPriceMoreHighest = booksMap.get(entry.getKey());
                booksMoreExpensive.add(bookWithPriceMoreHighest);
            }
        }
        return booksMoreExpensive;
    }

    public List<Books> gettingCheapestBook() {
        List<Books> cheapestBook = new ArrayList<>();
        double priceCheapestBook = Double.MAX_VALUE;

        if (!booksMap.isEmpty()) {
            for (Books book : booksMap.values()) {
                if (book.getPrice() < priceCheapestBook) {
                    priceCheapestBook = book.getPrice();
                }
            }
        } else {
            throw new NoSuchElementException("The Library is empty");
        }

        for (Map.Entry<String, Books> entry : booksMap.entrySet()) {
            if (entry.getValue().getPrice() == priceCheapestBook) {
                Books bookWithPriceCheapestBook = booksMap.get(entry.getKey());
                cheapestBook.add(bookWithPriceCheapestBook);
            }
        }
        return cheapestBook;
    }

    public static void main(String[] args) {
        LibraryOnline libraryOnline = new LibraryOnline();

        libraryOnline.addBook("https://amzn.to/3EclT8Z", new Books("1984", "George Orwell", 50d));
        libraryOnline.addBook("https://amzn.to/47Umiun", new Books("A Revolução dos Bichos", "George Orwell", 7.05d));
        libraryOnline.addBook("https://amzn.to/3L1FFI6", new Books("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        libraryOnline.addBook("https://amzn.to/3OYb9jk", new Books("Malorie", "Josh Malerman", 5d));
        libraryOnline.addBook("https://amzn.to/45HQE1L", new Books("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        libraryOnline.addBook("https://amzn.to/45u86q4", new Books("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        System.out.println("Books ordered by price: ");
        System.out.println(libraryOnline.displayBooksOrderedByPrice());
        System.out.println("--------------------------------------");

        System.out.println("Books ordered by author: ");
        System.out.println(libraryOnline.displayBooksOrderedByAuthor());
        System.out.println("---------------------------------------");

        System.out.println("Searching Books by Author: ");
        System.out.println(libraryOnline.searchBooksByAuthor("Agatha Christie"));
        System.out.println("---------------------------------------");

        System.out.println("Getting Cheapest Book: ");
        System.out.println(libraryOnline.gettingCheapestBook());
        System.out.println("---------------------------------------");

        System.out.println("Getting more expensive Book: ");
        System.out.println(libraryOnline.gettingBookMoreExpensive());
        System.out.println("---------------------------------------");

        System.out.println("Removing some book... ");
        libraryOnline.removeBook("E Não Sobrou Nenhum");
        System.out.println("---------------------------------------");

        System.out.println("Showing all books now that some books were removing: ");
        System.out.println(libraryOnline.booksMap);
    }
}
