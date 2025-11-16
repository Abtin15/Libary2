import java.util.Scanner;

public class AdminMenu {

    static Scanner scanner = new Scanner(System.in);
    static Admin admin = new Admin("admin", "1234");

    public static void showAdminMenu() {
        System.out.println(" * * * ADMIN MENU * * * ");
        int option;
        do {
            System.out.println("1. User Management ");
            System.out.println("2. Book Management ");
            System.out.println("3. Logout");
            System.out.print("Please select an option : ");
            option = scanner.nextInt();
        }
        while (option > 3 || option < 1);
        switch (option) {
            case 1 -> System.out.println("User List : ");
            case 2 -> bookManagement();
            case 3 -> Main.showMenu();
        }
    }

    public static void loginAdminMenu() {
        System.out.println(" * * * ADMIN MENU * * * ");
        System.out.print("Enter username : ");
        String username = scanner.nextLine();
        System.out.print("Enter password : ");
        String password = scanner.nextLine();
        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            System.out.println("Login Successful");
            showAdminMenu();
        } else {
            System.out.println("Invalid username or password");
            Main.showMenu();
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
            System.out.println("5. Back ");
            System.out.print("Please select an option : ");
            option = scanner.nextInt();
        } while (option > 5 || option < 1);
        switch (option) {
            case 1 -> addBook();
            case 2 -> updateBook();
            case 3 -> deleteBook();
            case 4 -> listBooks();
            case 5 -> showAdminMenu();
        }
    }

    public static void listBooks() {
        System.out.println(" * * * LIST BOOKS * * * ");
        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        for (int i = 0; i < BookRepo.allBooks.size(); i++) {
            BookRepo.printBook(i);
            bookManagement();
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
        BookRepo.allBooks.add(newBook);
        System.out.println("Book successfully added ");
        System.out.println("----------------------------------------");
        bookManagement();
    }

    public static void updateBook() {
        System.out.println(" * * * UPDATE * * * ");
        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name of the book : ");
        String name = scanner.nextLine();

        int index = BookRepo.findBook(name);
        if (index == -1) {
            System.out.println("Book not found ");
        }
        System.out.println("----------------------------------------");
        Book book = BookRepo.allBooks.get(index);
        System.out.print("Enter New Book name : ");
        book.setName(scanner.nextLine());

        System.out.print("Enter New Author name : ");
        book.setAuthor(scanner.nextLine());

        System.out.print("Enter New Price : ");
        book.setPrice(scanner.nextDouble());

        System.out.println("Book successfully updated ");
        System.out.println("----------------------------------------");
        bookManagement();
    }

    public static void deleteBook() {
        System.out.println(" * * * DELETE * * * ");
        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name : ");
        String name = scanner.nextLine();
        int index = BookRepo.findBook(name);
        if (index == -1) {
            System.out.println("Name not found");
        } else {
            BookRepo.allBooks.remove(index);
            System.out.println("Book successfully removed");
            System.out.println("----------------------------------------");
            bookManagement();
        }
    }
}

