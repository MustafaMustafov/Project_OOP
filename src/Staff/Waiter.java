package Staff;

import Management.ObjectFileManagement;
import Restaurant.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Waiter extends Employee {

    private static Scanner scan = new Scanner(System.in);

    public Waiter() {
    }

    public Waiter(String name, String userName, String password) {
        super(name, userName, password);

    }

    @Override
    public ArrayList<Order> getOrders() {
        return super.getOrders();
    }

    public void addMealToMenu() {
        System.out.println("Enter meal name: ");
        String mealName = scan.nextLine();
        System.out.println("Enter meal price: ");
        double mealPrice = scan.nextDouble();
        System.out.println("Enter meal type: ");
        String mealType = scan.next();
        FoodMenu.meals.add(new Meal(mealName, mealPrice, mealType, false));
    }

    public void removeMealFromMenu() {
        System.out.println("Enter meal name to remove from menu: ");
        int mealNumber = scan.nextInt();
        FoodMenu.meals.remove(FoodMenu.meals.get(mealNumber - 1));
    }

    public void displayMenu() {
        System.out.println(" ============== Menu ============== ");
        System.out.println("|----| ---- Name ---- |-Price-| --Type-- |");
        for (int i = 0; i < FoodMenu.getMeals().size(); i++) {
            System.out.println("|" + (i + 1) + "|--->|"
                    + FoodMenu.getMeals().get(i).getName()
                    + "| -> " + FoodMenu.getMeals().get(i).getPrice()
                    + " lv | " + FoodMenu.getMeals().get(i).getType() + " |");
        }
    }

    public void displayActiveOrders() {
        System.out.println(" ==== Active Orders ==== ");
        for (int i = 0; i < getOrders().size(); i++) {
            if (getOrders().get(i).getStatus().equals(Status.ACTIVE)) {
                System.out.println("--> Table with id " + getOrders().get(i).getTable().getTableId() + " has ACTIVE order");
                System.out.println((i+1)+". " + getOrders().get(i).toString());
            }
        }
        System.out.println();
    }

    private boolean checkTableStatus(int tableId) {
        boolean answer = false;
        if (getOrders().isEmpty()) {
            answer = true;
        } else {
            for (var o : getOrders()) {
                if (o.getTable().getTableId() == tableId) {
                    answer = false;
                } else {
                    answer = true;
                }
            }
        }
        return answer;
    }

    public void inputNewOrder() {
        Table table = new Table();
        Order order = new Order();
        int choice = -1;
        System.out.println(" ==== Input new order === ");
        System.out.println(" ---> Enter table number <--- ");
        int chosenTable = scan.nextInt();
        table.setTableId(chosenTable);
        displayMenu();
        chooseFood(table, order, choice, chosenTable);
    }

    private void chooseFood(Table table, Order order, int choice, int chosenTable) {
        if (checkTableStatus(chosenTable)) {
            while (choice != 0) {
                System.out.println("Choose from menu to add to the order! Or push 0 for exit!");
                choice = scan.nextInt();
                if (choice != 0) {
                    order.getFoods().add(FoodMenu.getMeals().get(choice -1));
                }
            }
            getOrders().add(new Order(new Table(table.getTableId(), false), order.getFoods(), Status.ACTIVE));
        }else{
            System.out.println("Table is busy!");
        }
    }

    public void addMealToOrder() {
        ArrayList<Meal> mealsFromMenu = ObjectFileManagement.readObjectFromFile("Meals.csv");
        System.out.println(" ----> Which table <---- ");
        int tableId = scan.nextInt();
        System.out.println(" ---- Choose from meals ---- ");
        for (Meal m : mealsFromMenu) {
            System.out.println(m);
        }
        int choice = scan.nextInt();
        getOrders().get(tableId).getMeals().add(mealsFromMenu.get(choice));
    }

    public void removeMealFromOrder(int order) {
        for (Order o : getOrders()) {
            System.out.println(getOrders().get(order).getMeals().toString());
        }
        System.out.println(" ----> Which meal to remove from order? <----");
        int chosenMeal = scan.nextInt();
        getOrders().get(order).getMeals().remove(chosenMeal);
    }

    public void editOrder() {
        displayActiveOrders();
        System.out.println(" ----> Choose which order to edit <---- ");
        int order = scan.nextInt();
        System.out.println(getOrders().get(order).toString());
        System.out.println(" ----> Enter a(for adding to order) / enter r(to remove from order)");
        String choice = scan.next();
        switch (choice) {
            case "a":
                addMealToOrder();
                break;
            case "r":
                removeMealFromOrder(order);
                System.out.println(" ---> Chosen meal deleted ");
                break;
            default:
                System.out.println(" ---> No such choice! ");
        }
    }

    public void changeOrderStatus() {
        for (Order o : getOrders()) {
            System.out.println(getOrders().toString());
        }
        System.out.println(" ---- Choose any of orders to change status ---- ");
        int choice = scan.nextInt();
        System.out.println(" ----> Your chosen orders status is " + getOrders().get(choice).getStatus());
        System.out.println(" ----> You can choose (s for SERVED/ a for ACTIVE) ");
        String setStatusTo = scan.nextLine();
        switch (setStatusTo) {
            case "s":
                if (getOrders().get(choice).getStatus().equals(Status.SERVED)) {
                    System.out.println("---> That order status is already - SERVED");
                } else {
                    getOrders().get(choice).setStatus(Status.SERVED);
                }
                break;
            case "a":
                if (getOrders().get(choice).getStatus().equals(Status.ACTIVE)) {
                    System.out.println("---> That order's status is already - Active");
                } else {
                    getOrders().get(choice).setStatus(Status.ACTIVE);
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

