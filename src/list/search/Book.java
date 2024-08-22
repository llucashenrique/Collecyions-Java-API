package list.search;

public class Book {

    private String title;

    private String author;

    private int yearPublication;

    public Book(String title, String author, int yearPublication) {
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
    }


    public int getYearPublication() {
        return yearPublication;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearPublication=" + yearPublication +
                '}';
    }
}
