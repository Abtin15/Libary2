import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Admin admin = new Admin("admin", "1234");

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int option = 0;
        System.out.println(" * * * MENU * * * ");
        do {
            System.out.println("1. ADMIN MENU ");
            System.out.println("2. USER MENU ");
            System.out.println("3. EXIT ");
            System.out.print("please choose one of these options : ");
            option = scanner.nextInt();
        } while (option > 3 || option < 1);
        switch (option) {
            case 1 -> loginAdminMenu();
            case 2 -> userMenu();
        }

        // TODO: add user menu method
    }

    public static void loginAdminMenu() {
        System.out.println(" * * * ADMIN MENU * * * ");
        scanner.nextLine();
        System.out.print("Enter username : ");
        String username = scanner.nextLine();
        System.out.print("Enter password : ");
        String password = scanner.nextLine();
        if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
            System.out.println("Login Successful");
            showAdminMenu();
        } else {
            System.out.println("Invalid username or password");
            showMenu();
        }
    }

    //TODO: refactor this method with userMenu like the PDF
    public static void userMenu() {
        System.out.println(" * * * USER MENU * * * ");
        scanner.nextLine();
            System.out.println("List of all books : ");
            System.out.println("List of my books : ");
            System.out.println("Check out a book : ");
            System.out.println("Return a book : ");
            System.out.println("Log out");
            System.out.print("Please select an option : ");
    }

    // TODO: complete this method
    public static void showAdminMenu(){
        System.out.println(" * * * ADMIN MENU * * * ");
        scanner.nextLine();
        System.out.println("User List : ");
        System.out.println("Book Management : ");
        System.out.println("Logout");
        System.out.print("Please select an option : ");
    }
}
