public class Book {

    private static int baseCode = 145;

    private BookStatus status;
    private String title;
    private int publishYear;
    private String author;
    private int code;

    public Book(BookStatus status, String title, int publishYear, String author) {
        this.status = status;
        this.title = title;
        this.publishYear = publishYear;
        this.author = author;
        this.code = baseCode++;

    }

    public BookStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public int getCode() {
        return code;
    }
}