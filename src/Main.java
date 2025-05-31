import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

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

            }
        // TODO: add admin menu method
        
        // TODO: add user menu method
    }
    public static void adminMenu() {
        System.out.println(" * * * ADMIN * * * ");

    }
}