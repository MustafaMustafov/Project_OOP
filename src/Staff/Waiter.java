package Staff;

import Management.ObjectFileManagement;
import Restaurant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Waiter extends Employee {
    private ArrayList<Order> orders = new ArrayList<>();
    private Table[] tables = new Table[5];
    private static Scanner scan = new Scanner(System.in);

    public Waiter(String name, String userName, String password) {
        super(name, userName, password);
        this.orders = new ArrayList<>();
    }
    public Waiter(){

    }
    private void addTablesToWaiter() {
        for (int i = 0; i < tables.length; i++) {
            this.tables[i] = new Table(i+1,true);
        }
    }
    public void addMealToMenu() {
        System.out.println("Enter meal name: ");
        String mealName = scan.nextLine();
        System.out.println("Enter meal price: ");
        double mealPrice = scan.nextDouble();
        System.out.println("Enter meal type: ");
        String mealType = scan.next();
        FoodMenu.meals.add(new Meal(mealName,mealPrice,mealType,false));
    }

    public void removeMealFromMenu() {
        System.out.println("Enter meal name to remove from menu: ");
        int mealNumber = scan.nextInt();
        FoodMenu.meals.remove(FoodMenu.meals.get(mealNumber-1));
        }

    public void displayMenu() {
        System.out.println(" ====== Menu ====== ");
        System.out.println(" -- Name -- Price -- Type -- ");
        for (int i = 0; i < FoodMenu.meals.size(); i++) {
            System.out.println((i+1) + " ---> " + FoodMenu.meals.get(i).getName() + " - " + FoodMenu.meals.get(i).getPrice() + " - " + FoodMenu.meals.get(i).getType());
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
        addTablesToWaiter();
        int choice = 1;
        System.out.println(" ==== Input new order === ");
        System.out.println(" ---> Enter table number <--- ");
        int tableId = scan.nextInt();
        //ArrayList<Order> clientOrder = new ArrayList<>();
        List<Food> mealsAddedToOrder = new ArrayList<>();
        displayMenu();
        for (int i = 0; i < tables.length; i++) {
            if (i==tableId && tables[i].getIsFree()) {
                while(choice!=0) {
                    System.out.println("Choose from menu to add to the order! ");
                    choice = scan.nextInt();
                    mealsAddedToOrder.add(FoodMenu.meals.get(choice));
                }
                orders.add(new Order(new Table(tableId,false),mealsAddedToOrder,Status.ACTIVE));
                break;
            }
        }
    }

    public void addMealToOrder() {
        ArrayList<Meal> mealsFromMenu = ObjectFileManagement.readObjectFromFile("Meals.csv");
        System.out.println(" ----> Which table <---- ");
        int tableId = scan.nextInt();
        System.out.println(" ---- Choose from meals ---- ");
        for (Meal m: mealsFromMenu) {
            System.out.println(m);
        }
        int choice = scan.nextInt();
        orders.get(tableId).getMeals().add(mealsFromMenu.get(choice));
    }

    public void removeMealFromOrder(int order) {
        for (Order o: orders) {
            System.out.println(orders.get(order).getMeals().toString());
        }
        System.out.println(" ----> Which meal to remove from order? <----");
        int chosenMeal = scan.nextInt();
        orders.get(order).getMeals().remove(chosenMeal);
    }

    public void editOrder() {
        displayActiveOrders();
        System.out.println(" ----> Choose which order to edit <---- ");
        int order = scan.nextInt();
        System.out.println(orders.get(order).toString());
        System.out.println(" ----> Enter a(for adding to order) / enter r(to remove from order)");
        String choice = scan.next();
        switch (choice) {
            case "a": addMealToOrder();
            break;
            case "r": removeMealFromOrder(order);
                System.out.println(" ---> Chosen meal deleted ");
                break;
            default:
                System.out.println(" ---> No such choice! ");
        }
    }

    public void changeOrderStatus() {
        for (Order o: orders) {
            System.out.println(orders.toString());
        }
        System.out.println(" ---- Choose any of orders to change status ---- ");
        int choice = scan.nextInt();
        System.out.println(" ----> Your chosen orders status is " + orders.get(choice).getStatus());
        System.out.println(" ----> You can choose (s for SERVED/ a for ACTIVE) ");
        String setStatusTo = scan.nextLine();
        switch (setStatusTo) {
            case "s": if (orders.get(choice).getStatus().equals(Status.SERVED)) {
                System.out.println("---> That order status is already - SERVED");
            } else {
                orders.get(choice).setStatus(Status.SERVED);
            }
            break;
            case "a": if (orders.get(choice).getStatus().equals(Status.ACTIVE)) {
                System.out.println("---> That order's status is already - Active");
            } else {
                orders.get(choice).setStatus(Status.ACTIVE);
            }
            break;
            default:
                System.out.println("---> No such choice for status! ");
        }
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }
}

