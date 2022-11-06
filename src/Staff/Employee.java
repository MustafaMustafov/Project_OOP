package Staff;

public class Employee {
    private String name;
    private String userName;
    private String password;

    public Employee() {
    }

    public Employee(String name, String userName, String password) {
        this.name = name;
        this.userName = userName ;
        this.password = password;
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
