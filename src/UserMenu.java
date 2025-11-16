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
            default -> Main.showMenu();
        }
    }

    public static void listOfAllBooks() {
        System.out.println(" * * * LIST OF ALL BOOKS * * * ");

        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("There are no books in the library.");
        } else {
            for (int i = 0; i < BookRepo.allBooks.size(); i++) {
                Book book = BookRepo.allBooks.get(i);
                System.out.println((i + 1) + ". " + book.getName() + " by " + book.getAuthor() + " - $" + book.getPrice());
            }

            System.out.println("----------------------------------------");
            userMenu();
        }
    }

    public static void listOfAllMyBooks() {
        System.out.println(" * * * LIST OF ALL MY BOOKS * * * ");

        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("You haven't borrowed any books yet.");
        } else {
            for (int i = 0; i < BookRepo.allBooks.size(); i++) {
                Book book = BookRepo.allBooks.get(i);
                System.out.println((i + 1) + ". " + book.getName() + " by " + book.getAuthor());
            }
        }

        System.out.println("----------------------------------------");
        userMenu();
    }

    public static void checkOutABook() {
        System.out.println(" * * * CHECK OUT A BOOK * * * ");

        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("No books are available to check out.");
            System.out.println("----------------------------------------");
            userMenu();
            return;
        }

        for (int i = 0; i < BookRepo.allBooks.size(); i++) {
            System.out.println((i + 1) + ". " + BookRepo.allBooks.get(i).getName());
        }

        System.out.print("Enter the number of the book you want to borrow: ");
        int choice = scanner.nextInt() - 1;

        if (choice < 0 || choice >= BookRepo.allBooks.size()) {
            System.out.println("Invalid choice.");
        } else {
            Book selectedBook = BookRepo.allBooks.get(choice);
            BookRepo.allBooks.add(selectedBook);
            System.out.println("You borrowed: " + selectedBook.getName());
        }

        System.out.println("----------------------------------------");
        userMenu();
    }

    public static void returnABook() {
        System.out.print(" * * * RETURN A BOOK * * * ");

        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("You don’t have any books to return.");
            System.out.println("----------------------------------------");
            userMenu();
            return;
        }

        for (int i = 0; i < BookRepo.allBooks.size(); i++) {
            System.out.println((i + 1) + ". " + BookRepo.allBooks.get(i).getName());
        }

        System.out.print("Enter the number of the book to return: ");
        int choice = scanner.nextInt() - 1;

        if (choice < 0 || choice >= BookRepo.allBooks.size()) {
            System.out.println("Invalid choice.");
        } else {
            Book returnedBook = BookRepo.allBooks.remove(choice);
            System.out.println("You returned: " + returnedBook.getName());
        }

        System.out.println("----------------------------------------");
        userMenu();
    }

    public static void userListBooks() {
        System.out.println(" * * * USER LIST BOOKS * * * ");
        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            userMenu();
        }
        for (int i = 0; i < BookRepo.allBooks.size(); i++) {
            BookRepo.printBook(i);
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
        BookRepo.allBooks.add(newBook);
        System.out.println("Book successfully added");
        System.out.println("----------------------------------------");
        userMenu();
    }

    public static void userUpdateBook() {
        System.out.println(" * * * UPDATE * * * ");
        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("List is empty ");
            System.out.println("----------------------------------------");
            userMenu();
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
        scanner.nextLine();
        System.out.print("Enter New Book name : ");
        book.setName(scanner.nextLine());

        System.out.print("Enter New Author name : ");
        book.setAuthor(scanner.nextLine());

        System.out.print("Enter New Price : ");
        book.setPrice(scanner.nextDouble());

        System.out.println("Book successfully updated ");
        System.out.println("----------------------------------------");
        userMenu();
    }

    public static void userDeleteBook() {
        System.out.println(" * * * DELETE * * * ");
        if (BookRepo.allBooks.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("----------------------------------------");
            userMenu();
        }
        scanner.nextLine();
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        int index = BookRepo.findBook(name);
        if (index == -1) {
            System.out.println("Name not found");
        } else {
            System.out.println("Book successfully removed");
            System.out.println("----------------------------------------");
            userMenu();
        }
    }
}
