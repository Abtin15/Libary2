import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        System.out.println(" * * * MENU * * * ");
        int option;
        do {
            System.out.println("1. ADMIN MENU ");
            System.out.println("2. USER MENU ");
            System.out.println("3. EXIT ");
            System.out.print("please choose one of these options : ");
            option = scanner.nextInt();
        } while (option > 3 || option < 1);
        switch (option) {
            case 1 -> AdminMenu.loginAdminMenu();
            case 2 -> UserMenu.loginUserMenu();
            case 3 -> System.exit(0);
        }
    }
}