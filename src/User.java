public class User {

    private static int baseCode = 234;

    private String username;
    private String password;
    private String name;
    private String family;
    private int age;
    private String address;
    private String gender;
    private int code;

    public User(String username, String password, String name, String family, int age, String address, String gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.family = family;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.code = baseCode++;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }


    // TODO: WRITE getter for code field
}
