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
            case 1 -> userManagement();
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
        if (BookRepo.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        for (int i = 0; i < BookRepo.size(); i++) {
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

        if (BookRepo.existingByName(name)) {
            System.out.println("Another book name exists by this name");
        } else {
            Book newBook = new Book(name, author, price);
            BookRepo.add(newBook);
            System.out.println("Book successfully added ");
        }

        System.out.println("----------------------------------------");
        bookManagement();
    }

    public static void updateBook() {
        System.out.println(" * * * UPDATE * * * ");
        if (BookRepo.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name of the book : ");
        String name = scanner.nextLine();

        int index = BookRepo.find(name);
        if (index == -1) {
            System.out.println("Book not found ");
        }
        System.out.println("----------------------------------------");
        Book book = BookRepo.get(index);
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
        if (BookRepo.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            bookManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name : ");
        String name = scanner.nextLine();
        int index = BookRepo.find(name);
        if (index == -1) {
            System.out.println("Name not found");
        } else {
            BookRepo.remove(index);
            System.out.println("Book successfully removed");
            System.out.println("----------------------------------------");
            bookManagement();
        }
    }

    public static void userManagement() {
        System.out.println(" * * * USER MANAGEMENT * * * ");
        int option;
        do {
            System.out.println("1. Add User");
            System.out.println("2. Update a user ");
            System.out.println("3. Delete a user ");
            System.out.println("4. List users ");
            System.out.println("5. Back ");
            System.out.print("Please select an option : ");
            option = scanner.nextInt();
        } while (option > 5 || option < 1);
        switch (option) {
            case 1 -> addUser();
            case 2 -> updateUser();
            case 3 -> deleteUser();
            case 4 -> listUsers();
            case 5 -> showAdminMenu();
        }
    }

    public static void listUsers() {
        System.out.println(" * * * LIST USERS * * * ");
        if (UserRepo.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            userManagement();
        }
        for (int i = 0; i < UserRepo.size(); i++) {
            UserRepo.print(i);
        }
        userManagement();
    }

    public static void addUser() {
        System.out.println(" * * * ADD * * * ");
        scanner.nextLine();
        System.out.print("Enter Name of the user : ");
        String name = scanner.nextLine();

        System.out.print("Enter Family of user : ");
        String family = scanner.nextLine();

        System.out.print("Enter The age of user : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter username of user : ");
        String username = scanner.nextLine();

        System.out.print("Enter password of user : ");
        String password = scanner.nextLine();

        User newUser = new User(username, password, name, family, age);
        UserRepo.add(newUser);
        System.out.println("User successfully added ");
        System.out.println("----------------------------------------");
        userManagement();
    }

    public static void updateUser() {
        System.out.println(" * * * UPDATE * * * ");
        if (UserRepo.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            userManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name of the user : ");
        String name = scanner.nextLine();

        int index = UserRepo.find(name);
        if (index == -1) {
            System.out.println("User not found ");
        }
        System.out.println("----------------------------------------");
        User user = UserRepo.get(index);
        System.out.print("Enter New User name : ");
        user.setName(scanner.nextLine());

        System.out.print("Enter new user family : ");
        user.setFamily(scanner.nextLine());

        System.out.print("Enter New Age : ");
        user.setAge(scanner.nextInt());

        System.out.println("User successfully updated ");
        System.out.println("----------------------------------------");
        userManagement();
    }

    public static void deleteUser() {
        System.out.println(" * * * DELETE USER * * * ");
        if (UserRepo.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            userManagement();
        }
        scanner.nextLine();
        System.out.print("Enter Name of user: ");
        String name = scanner.nextLine();
        int index = BookRepo.find(name);
        if (index == -1) {
            System.out.println("Name not found");
        } else {
            UserRepo.remove(index);
            System.out.println("User successfully removed");
            System.out.println("----------------------------------------");
            userManagement();
        }
    }
}