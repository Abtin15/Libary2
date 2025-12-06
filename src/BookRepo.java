import java.util.ArrayList;

public class BookRepo {

    private static ArrayList<Book> books = new ArrayList<>();

    public static void printBook(int index) {
        Book book = books.get(index);
        System.out.println("Name : " + book.getName());
        System.out.println("Author : " + book.getAuthor());
        System.out.println("Price : " + book.getPrice());
        System.out.println("----------------------------------------");
    }

    public static int find(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (name.equals(books.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public static void add(Book newBook) {
        books.add(newBook);
    }

    public static boolean isEmpty() {
        return books.isEmpty();
    }

    public static Book remove(int index) {
        return books.remove(index);
    }

    public static Book get(int index) {
        return books.get(index);
    }

    public static int size() {
        return books.size();
    }

    public static boolean existingByName(String name) {
        return find(name) != -1;
    }
}