package Staff;

import Restaurant.FoodMenu;
import Restaurant.Meal;
import Restaurant.Order;
import Restaurant.Table;

import java.util.ArrayList;
import java.util.Scanner;

public class Waiter extends Employee {
    private ArrayList<Order> orders;
    private static Scanner scan = new Scanner(System.in);

    public Waiter(String name) {
        super(name);
    }

    public void addMealToMenu() {
        System.out.println("Enter meal name: ");
        String mealName = scan.nextLine();
        System.out.println("Enter meal price: ");
        double mealPrice = scan.nextDouble();
        System.out.println("Enter meal type: ");
        String mealType = scan.nextLine();
        FoodMenu.meals.add(new Meal(mealName,mealPrice,mealType,false));
    }

    public void removeMealFromMenu() {
        System.out.println("Enter meal name to remove from menu: ");
        String mealName = scan.nextLine();
        for (int i = 0; i < FoodMenu.meals.size(); i++) {
            if (FoodMenu.meals.get(i).getName().equals(mealName)) {
                FoodMenu.meals.remove(FoodMenu.meals.get(i));
            }
        }
    }

    public void displayMenu() {
        System.out.println(" ====== Menu ====== ");
        System.out.println(" -- Name -- Price -- Type -- ");
        for (int i = 0; i < FoodMenu.meals.size(); i++) {
            System.out.println(FoodMenu.meals.get(i).getName() + " - " + FoodMenu.meals.get(i).getPrice() + " - " + FoodMenu.meals.get(i).getType());
        }
    }

    public void displayActiveOrders() {
        System.out.println(" ==== Active Orders ==== ");
        for (int i = 0; i < orders.size() ; i++) {
            if (this.orders.get(i).getStatus().equals("ACTIVE")) {
                this.orders.get(i).getTable();
            }
        }
        System.out.println();
    }

    public void inputNewOrder() {
        System.out.println(" ==== Input new order === ");
        System.out.println(" ---> Enter table number <--- ");
        int tableId = scan.nextInt();
        for (Order o : orders) {
            if (o.getTable().getTableId()==tableId && o.getStatus().equals(true)) {
                //System.out.println(orders.add(new Order(new Table(tableId,false),)));
            }
        }

    }

    public Meal addMealToOrder() {
        System.out.println(" --- Enter meal --- ");
        System.out.println(" -- Enter name -- ");
        String mealName = scan.nextLine();
        System.out.println(" -- Enter price -- ");
        double mealPrice = scan.nextDouble();
        System.out.println(" -- Enter type -- ");
        String mealType = scan.nextLine();
        return new Meal(mealName,mealPrice,mealType,false);
    }
}

