package Staff;

import Restaurant.Order;

import java.io.Serializable;
import java.util.ArrayList;

public class  Employee implements Serializable {
    private String name;
    private String userName;
    private String password;
    private ArrayList<Order> orders = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.orders = new ArrayList<>();
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public String getName() {
        return name;
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
