package Staff;

import Restaurant.Food;
import Restaurant.Meal;
import Restaurant.Order;
import Restaurant.Status;

import java.util.ArrayList;
import java.util.Scanner;

public class Chef extends Employee {
    private static Scanner scan = new Scanner(System.in);
//    private ArrayList<Order> orders;

    public Chef(String name, String userName, String password) {
        super(name,userName,password);
        getOrders();
//        this.orders = new ArrayList<>();
    }

    public Chef(){

    }

    @Override
    public ArrayList<Order> getOrders() {
        return super.getOrders();
    }

    public void displayOrders() {
        System.out.println(" ==== Active Orders ==== ");
        for (int i = 0; i < getOrders().size() ; i++) {
            if (getOrders().get(i).getStatus().equals(Status.ACTIVE)) {
                System.out.println("---> Table with id " + getOrders().get(i).getTable().getTableId() + " has ACTIVE order");
                System.out.println(i + getOrders().get(i).toString());
            }
        }
        System.out.println();
    }

    public void updateOrderStatus() {
        System.out.println(" Enter meal name: ");
        String mealName = scan.nextLine();
        for (int i = 0; i < getOrders().size(); i++) {
            for (Food f : getOrders().get(i).getMeals()) {
                if (f.getName().equalsIgnoreCase(mealName)) {
                    System.out.println("Enter status (1-Cooked / 2 - isCooking):: ");
                    if (scan.nextInt() == 1) {
//                    f.getName()
                    }
                }
            }
        }
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }
}
