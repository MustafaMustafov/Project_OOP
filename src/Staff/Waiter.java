package Staff;

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
        Order order = new Order();
        System.out.println("Enter meal name to remove from menu: ");
        int mealNumber = (scan.nextInt() - 1);
        order.getFoods().remove(order.getFoods().get((mealNumber)));
    }

    public void displayMenu() {
        Order order = new Order();
        System.out.println(" ============== Menu ============== ");
        for (int i = 0; i < order.getFoods().size(); i++) {
            System.out.println((i + 1) + "-->" + order.getFoods().get(i) +
                    "\n----------------------------------------------");
        }
    }


    public void displayActiveOrders() {
        System.out.println(" ==== Active Orders ==== ");
        for (int i = 0; i < getOrders().size(); i++) {
            if (getOrders().get(i).getStatus().equals(Status.ACTIVE)) {
                System.out.println("--> Table with id " + getOrders().get(i).getTable().getTableId() + " has ACTIVE order");
                System.out.println((i + 1) + ". " + getOrders().get(i).toString());
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
        try {
            int choice = -1;
            System.out.println(" ==== Input new order === ");
            System.out.println(" ---> Enter table number <--- ");
            int chosenTable = scan.nextInt();
            table.setTableId(chosenTable);

            chooseFood(table, order, choice, chosenTable);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Entered number is out of menu!");
        }
    }

    private void chooseFood(Table table, Order order, int choice, int chosenTable) {
        if (checkTableStatus(chosenTable)) {
            displayMenu();
            ArrayList<Food> addFoodToOrder = new ArrayList<>();
            while (choice != 0) {
                System.out.println("Choose from menu to add to the order! Or push 0 for exit!");
                choice = scan.nextInt();
                if (choice != 0) {
                    addFoodToOrder.add(order.getFoods().get(choice - 1));
                }
            }
            getOrders().add(new Order(new Table(table.getTableId(), false), addFoodToOrder, Status.ACTIVE));
        } else {
            System.out.println("Table is busy!");
        }
    }


    public void addMealToOrder(int order) {
        try {
            System.out.println(" ---- Choose from meals ---- ");
            int mealNumber = 0;
            for (Meal m : FoodMenu.getMeals()) {
                mealNumber++;
                System.out.println(mealNumber + "-> " + m);
            }
            int choice = (scan.nextInt() - 1);
            getOrders().get(order).getMeals().add(FoodMenu.getMeals().get(choice));
            System.out.println(FoodMenu.getMeals().get(choice));
            System.out.println(getOrders().get(order).getFoods().toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Chosen meal does not exist!");
        }
    }

    public void removeMealFromOrder(int order) {
        System.out.println(getOrders().get(order).getMeals().toString());
        System.out.println(" ----> Which meal to remove from order? <----");
        int chosenMeal = 0;
        try {
            chosenMeal = (scan.nextInt() - 1);
            getOrders().get(order).getMeals().remove(chosenMeal);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Order number " + chosenMeal + " does not exist!");
        }
    }

    public void editOrder() {
        displayActiveOrders();
        System.out.println(" ----> Choose which order to edit <---- ");
        try {
            int order = (scan.nextInt() - 1);
            System.out.println(getOrders().get(order).toString());
            System.out.println(" ----> Enter 'A'(for adding to order) / enter 'R' (to remove from order)");
            String choice = scan.next().toLowerCase();
            switch (choice) {
                case "a":
                    addMealToOrder(order);
                    break;
                case "r":
                    removeMealFromOrder(order);
                    System.out.println(" ---> Chosen meal deleted ");
                    break;
                default:
                    System.out.println(" ---> No such choice! ");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong input!");
        }
    }

    private void readOrders() {
        int count = 0;
        for (Order order : getOrders()) {
            count++;
            System.out.println(count + " " + order);
        }

    }

    public void changeOrderStatus() {
        readOrders();
        System.out.println(" ---- Choose any of orders to change status ---- ");
        try {
        int choice = (scan.nextInt() - 1);
        System.out.println(" ----> Your chosen order's status: " + getOrders().get(choice).getStatus());
        System.out.println(" ----> You can choose 'S' (for SERVED) or Active by pressing 'A' ");
            String setStatusTo = scan.next().toLowerCase();
            switch (setStatusTo) {
                case "s":
                    getOrders().get(choice).setStatus(Status.SERVED);
                    System.out.println("---> That order status is already - SERVED");
                    break;
                case "a":
                    getOrders().get(choice).setStatus(Status.ACTIVE);
                    System.out.println("---> That order's status is already - Active");
                    break;
                default:
                    System.out.println("---> No such choice for status! ");
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Wrong order number!");
        }
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }
}

