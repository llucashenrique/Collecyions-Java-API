package list.search;

import java.util.ArrayList;
import java.util.List;

public class CatalogBooks {

    private List<Book> bookList;

    public CatalogBooks() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(String title, String author, int yearPublication) {
        bookList.add(new Book(title, author, yearPublication));
    }

    public List<Book> searchAuthor(String author) {
        List<Book> booksForAuthor = new ArrayList<>();
        if (!bookList.isEmpty()) {
            for (Book l : bookList) {
                if (l.getAuthor().equalsIgnoreCase(author)) {
                    booksForAuthor.add(l);
                }
            }
        }
        return booksForAuthor;
    }


    public List<Book> yearRange(int startYear, int endYear) {
        List<Book> booksForRange = new ArrayList<>();
        if (!bookList.isEmpty()) {
            for (Book l : bookList) {
                if (l.getYearPublication() >= startYear && l.getYearPublication() <= endYear) {
                    booksForRange.add(l);
                }
            }
        }
        return booksForRange;
    }

    public Book searchBook(String title) {
        Book bookForTitle = null;
        if (!bookList.isEmpty()) {
            for (Book l : bookList) {
                if (l.getTitle().equalsIgnoreCase(title)) {
                    bookForTitle = l;
                    break;
                }
            }
        }
        return bookForTitle;
    }

    public static void main(String[] args) {
        CatalogBooks catalogBooks = new CatalogBooks();

        catalogBooks.addBook("Livro 1", "Author 1", 2021);
        catalogBooks.addBook("Livro 1", "Author 2", 2020);
        catalogBooks.addBook("Livro 2", "Author 2", 2023);
        catalogBooks.addBook("Livro 3", "Author 3", 2022);
        catalogBooks.addBook("Livro 4", "Author 4", 2021);

        System.out.println(catalogBooks.searchAuthor("Author 2"));

        System.out.println(catalogBooks.yearRange(2020, 2022));

        System.out.println(catalogBooks.searchBook("Livro 1"));

    }

}
