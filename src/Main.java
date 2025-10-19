import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Book> allBooks = new ArrayList<>();
    static Admin admin = new Admin("admin", "1234");

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        System.out.println(" * * * MENU * * * ");
        int option = 0;
        do {
            System.out.println("1. ADMIN MENU ");
            System.out.println("2. USER MENU ");
            System.out.println("3. EXIT ");
            System.out.print("please choose one of these options : ");
            option = scanner.nextInt();
        } while (option > 3 || option < 1);
        switch (option) {
            case 1 -> AdminMenu.loginAdminMenu();
            case 2 -> userMenu();
            case 3 -> System.exit(0);
        }
    }


    public static void userMenu() {
        System.out.println(" * * * USER MENU * * * ");
        scanner.nextLine();
        int option;
        do {
            System.out.println("1. List of all books : ");
            System.out.println("2. List of my books : ");
            System.out.println("3. Check out a book : ");
            System.out.println("4. Return a book : ");
            System.out.println("5. Log out");
            System.out.print("Please select an option : ");
            option = scanner.nextInt();
        } while (option > 5 || option < 1);
        switch (option) {
            case 1 -> listOfAllBooks();
            case 2 -> listOfAllMyBooks();
            case 3 -> checkOutABook();
            case 4 -> returnABook();
            case 5 -> showMenu();
        }
    }

    public static void listOfAllBooks() {
        System.out.println(" * * * LIST OF ALL BOOKS * * * ");

        System.out.println("Here is list of all the books");
    }

    public static void listOfAllMyBooks() {
        System.out.println(" * * * LIST OF ALL MY BOOKS * * * ");

        System.out.println("Here is list of all your books");
    }

    public static void checkOutABook() {
        System.out.println(" * * * CHECK OUT A BOOK * * * ");

        System.out.println("Checking out a book");
    }

    public static void returnABook() {
        System.out.print(" * * * RETURN A BOOK * * * ");

        System.out.println("Returning book");
    }

    public static void userManagement() {
        System.out.println(" * * * USER MANAGEMENT * * * ");
        int option;
        do {
            System.out.println("1. Add a book");
            System.out.println("2. Update a book");
            System.out.println("3. Delete a book");
            System.out.println("4. List books");
            System.out.print("Please select an option : ");
            option = scanner.nextInt();
        } while (option > 4 || option < 1);
        switch (option) {
            case 1 -> userAddBook();
            case 2 -> userUpdateBook();
            case 3 -> userDeleteBook();
            case 4 -> userListBooks();
        }
    }

    public static void userListBooks() {
        System.out.println(" * * * USER LIST BOOKS * * * ");
        if (allBooks.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            userManagement();
        }
        for (int i = 0; i < allBooks.size(); i++) {
            printBook(i);
        }
    }

    public static void userAddBook() {
        System.out.println(" * * * USER ADD BOOK * * * ");
        scanner.nextLine();
        System.out.print("Enter name of the book : ");
        String name = scanner.nextLine();

        System.out.print("Enter name of the author : ");
        String author = scanner.nextLine();

        System.out.print("Enter price of the book : ");
        double price = scanner.nextDouble();

        Book newBook = new Book(name, author,price);
        allBooks.add(newBook);
        System.out.println("Book successfully added");
        System.out.println("----------------------------------------");
        userManagement();
    }

    public static void userUpdateBook() {
        System.out.println(" * * * UPDATE * * * ");
        if (allBooks.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            userManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name of the book : ");
        String name = scanner.nextLine();

        int index = findBook(name);
        if (index == -1) {
            System.out.println("Book not found ");
        }
        System.out.println("----------------------------------------");
        Book book = allBooks.get(index);
        scanner.nextLine();
        System.out.print("Enter New Book name : ");
        book.name = scanner.nextLine();

        System.out.print("Enter New Author name : ");
        book.authorName = scanner.nextLine();

        System.out.print("Enter New Price : ");
        book.price = scanner.nextDouble();

        System.out.println("Book successfully updated ");
        System.out.println("----------------------------------------");
        userManagement();
    }

    public static void userDeleteBook() {
        System.out.println(" * * * DELETE * * * ");
        if(allBooks.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            userManagement();
        }
        scanner.nextLine();
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        int index = findBook(name);
        if (index == -1) {
            System.out.println("Name not found");
        } else {
            System.out.println("Book successfully removed");
            System.out.println("----------------------------------------");
            userManagement();
        }
    }


    public static void bookManagement() {
        System.out.println(" * * * BOOK MANAGEMENT * * * ");
        int option;
        do {
            System.out.println("1. Add Book");
            System.out.println("2. Update a book ");
            System.out.println("3. Delete a book ");
            System.out.println("4. List books ");
            System.out.print("Please select an option : ");
            option = scanner.nextInt();
        } while (option > 4 || option < 1);
        switch (option) {
            case 1 -> addBook();
            case 2 -> updateBook();
            case 3 -> deleteBook();
            case 4 -> listBooks();
        }
    }

    //TODO: add Book for name add, update, delete methods
    public static void listBooks() {
        System.out.println(" * * * LIST BOOKS * * * ");
        if (allBooks.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        for (int i = 0; i < allBooks.size(); i++) {
            printBook(i);
        }
    }

    public static void addBook() {
        System.out.println(" * * * ADD * * * ");
        scanner.nextLine();
        System.out.print("Enter Name of the book : ");
        String name = scanner.nextLine();

        System.out.print("Enter Name of the author : ");
        String author = scanner.nextLine();

        System.out.print("Enter The price : ");
        double price = scanner.nextDouble();

        Book newBook = new Book(name, author, price);
        allBooks.add(newBook);
        System.out.println("Book successfully added ");
        System.out.println("----------------------------------------");
        bookManagement();
    }

    public static void updateBook() {
        System.out.println(" * * * UPDATE * * * ");
        if (allBooks.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name of the book : ");
        String name = scanner.nextLine();

        System.out.print("Enter Name of the author : ");
        String author = scanner.nextLine();

        System.out.print("Enter Price of the book : ");
        double price = scanner.nextDouble();

        int index = findBook(name);
        if (index == -1) {
            System.out.println("Book not found ");
        }
        System.out.println("----------------------------------------");
        Book book = allBooks.get(index);
        scanner.nextLine();
        System.out.print("Enter New Book name : ");
        book.name = scanner.nextLine();

        System.out.print("Enter New Author name : ");
        book.authorName = scanner.nextLine();

        System.out.print("Enter New Price : ");
        book.price = scanner.nextDouble();

        System.out.println("Book successfully updated ");
        System.out.println("----------------------------------------");
        bookManagement();
    }

    public static void deleteBook() {
        System.out.println(" * * * DELETE * * * ");
        if (allBooks.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name : ");
        String name = scanner.nextLine();
        int index = findBook(name);
        if (index == -1) {
            System.out.println("Name not found");
        } else {
            System.out.println("Book successfully removed");
            System.out.println("----------------------------------------");
            bookManagement();
        }
    }

    public static int findBook(String name) {
        for (int i = 0; i < allBooks.size(); i++) {
            if (name.equals(allBooks.get(i).name))
                return i;
        }
        return -1;
    }

    public static void printBook(int index) {
        Book book = allBooks.get(index);
        System.out.println("Name : " + book.name);
        System.out.println("Author Name : " + book.authorName);
        System.out.println("Price : " + book.price);
        System.out.println("----------------------------------------");
        bookManagement();
    }
    //TODO: complete userMenu
    //TODO: complete book management
    //crud = create read update delete
}

