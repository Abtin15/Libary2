import java.util.Scanner;

public class UserMenu {

    static Scanner scanner = new Scanner(System.in);

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
            case 5 -> Main.showMenu();
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

    public static void userListBooks() {
        System.out.println(" * * * USER LIST BOOKS * * * ");
        if (Main.allBooks.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            Main.userManagement();
        }
        for (int i = 0; i < Main.allBooks.size(); i++) {
            Main.printBook(i);
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

        Book newBook = new Book(name, author, price);
        Main.allBooks.add(newBook);
        System.out.println("Book successfully added");
        System.out.println("----------------------------------------");
        Main.userManagement();
    }

    public static void userUpdateBook() {
        System.out.println(" * * * UPDATE * * * ");
        if (Main.allBooks.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            Main.userManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name of the book : ");
        String name = scanner.nextLine();

        int index = Main.findBook(name);
        if (index == -1) {
            System.out.println("Book not found ");
        }
        System.out.println("----------------------------------------");
        Book book = Main.allBooks.get(index);
        scanner.nextLine();
        System.out.print("Enter New Book name : ");
        book.name = scanner.nextLine();

        System.out.print("Enter New Author name : ");
        book.authorName = scanner.nextLine();

        System.out.print("Enter New Price : ");
        book.price = scanner.nextDouble();

        System.out.println("Book successfully updated ");
        System.out.println("----------------------------------------");
        Main.userManagement();
    }

    public static void userDeleteBook() {
        System.out.println(" * * * DELETE * * * ");
        if (Main.allBooks.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            Main.userManagement();
        }
        scanner.nextLine();
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        int index = Main.findBook(name);
        if (index == -1) {
            System.out.println("Name not found");
        } else {
            System.out.println("Book successfully removed");
            System.out.println("----------------------------------------");
            Main.userManagement();
        }
    }
}
