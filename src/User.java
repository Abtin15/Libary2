public class User extends SecurityUser {

    private static int baseCode = 234;

    private String name;
    private String family;
    private int age;
    private String address;
    private String gender;
    private int code;

    public User(String username, String password, String name, String family, int age, String address, String gender) {
        super(username, password);
        this.name = name;
        this.family = family;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.code = baseCode++;
    }

    public User(String username, String password, String name, String family, int age) {
        super(username, password);
        this.name = name;
        this.family = family;
        this.age = age;
        this.code = baseCode++;
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

    public int getCode() {
        return code;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User other = (User) obj;

        return age == other.age &&
                code == other.code &&
                username.equals(other.username) &&
                name.equals(other.name) &&
                family.equals(other.family);
    }
}