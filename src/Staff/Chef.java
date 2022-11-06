package Staff;

import Restaurant.Food;
import Restaurant.Meal;
import Restaurant.Order;

import java.util.ArrayList;
import java.util.Scanner;

public class Chef extends Employee {
    private static Scanner scan = new Scanner(System.in);
    private ArrayList<Order> orders;

    public Chef(String name) {
        super(name);
        this.orders = new ArrayList<>();
    }

    public void displayOrders() {
        System.out.println(" ==== Display Orders ==== ");
        for (int i = 0; i < orders.size(); i++) {
            if (this.orders.get(i).getStatus().equals("ACTIVE")) {
                System.out.println("| Meal name:" + orders.get(i).getMeals() + "|" +
                        " Table: " + orders.get(i).getTable() + "|");
            }
        }
        System.out.println();
    }

    public void updateOrderStatus() {
        System.out.println(" Enter meal name: ");
        String mealName = scan.nextLine();
        for (int i = 0; i < orders.size(); i++) {
            for (Food f : this.orders.get(i).getMeals()) {
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
