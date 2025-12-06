import java.util.ArrayList;

public class UserRepo {

    private static ArrayList<User> users = new ArrayList<>();

    public static void print(int index) {
        User user = users.get(index);
        System.out.println("Name : " + user.getName());
        System.out.println("Family : " + user.getFamily());
        System.out.println("Age : " + user.getAge());
        System.out.println("----------------------------------------");
    }

    public static int find(String name) {
        for (int i = 0; i < users.size(); i++) {
            if (name.equals(users.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public static void add(User newUser) {
        users.add(newUser);
    }

    public static boolean isEmpty() {
        return users.isEmpty();
    }

    public static User remove(int index) {
        return users.remove(index);
    }

    public static User get(int index) {
        return users.get(index);
    }

    public static int size() {
        return users.size();
    }
}