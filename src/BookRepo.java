import java.util.ArrayList;

public class BookRepo {
    public static ArrayList<Book> allBooks = new ArrayList<>();

    public static void printBook(int index) {
        Book book = allBooks.get(index);
        System.out.println("Name : " + book.getName());
        System.out.println("Author : " + book.getAuthor());
        System.out.println("Price : " + book.getPrice());
        System.out.println("----------------------------------------");
    }

    public static int findBook(String name) {
        for (int i = 0; i < allBooks.size(); i++) {
            if (name.equals(allBooks.get(i).getName()))
                return i;
        }
        return -1;
    }
}
