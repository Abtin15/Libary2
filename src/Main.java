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
            System.out.println(" 3. EXIT ");
            System.out.print("please choose one of these options : ");
            option = scanner.nextInt();
        } while (option > 3 || option < 1);
        switch (option) {
            case 1 -> loginAdminMenu();
        }
        // TODO: add admin menu method

        // TODO: add user menu method
    }
// TODO: rename this method to loginAdminMenu
    public static void loginAdminMenu() {
        System.out.println(" * * * ADMIN MENU * * * ");
        scanner.nextLine();
        System.out.print("Enter username : ");
        String username = scanner.nextLine();
        System.out.print("Enter password : ");
        String password = scanner.nextLine();
//TODO: if username and password is correct go to adminMenu else print error and go to main menu
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
            System.out.print("Enter username : ");
            String username = scanner.nextLine();
            System.out.print("Enter password : ");
            String password = scanner.nextLine();
            System.out.print("Enter your name");
            String name = scanner.nextLine();
            System.out.print("Enter your last name : ");
            String family = scanner.nextLine();
            System.out.print(" Enter your age : ");
            int age = scanner.nextInt();
            System.out.print("Enter your address : ");
            String address = scanner.nextLine();
            System.out.print("Enter your Gender : ");
            String gender = scanner.nextLine();
    }
}
