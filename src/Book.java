public class Book {

    private static int baseCode = 145;
    private String name;
    private double price;

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

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", publishYear=" + publishYear +
                ", author='" + author + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Book other = (Book) obj;

        return code == other.code &&
                publishYear == other.publishYear &&
                (title != null && title.equals(other.title));
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + publishYear;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}

