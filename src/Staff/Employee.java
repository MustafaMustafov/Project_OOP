package Staff;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private String userName;
    private String password;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "-> " + "name='" + name;
    }
}
