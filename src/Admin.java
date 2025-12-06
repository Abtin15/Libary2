public class Admin extends SecurityUser {

    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
