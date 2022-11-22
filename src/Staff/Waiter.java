package Staff;

import Management.ObjectFileManagement;
import Management.TextFileManagement;
import Management.UserManagement;
import Restaurant.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Waiter extends Employee implements Displayable{


    private static boolean flag = false;
    private static Scanner scan = new Scanner(System.in);

    public Waiter() {
    }

    public Waiter(String name, String userName, String password) {
        super(name, userName, password);
    }

    @Override
    public ArrayList<Order> getOrders() {
        String fileName = UserManagement.getName() + "OrderList.csv";
        ArrayList<Order> orders = ObjectFileManagement.readObjectFromFile(fileName);
        if (!ObjectFileManagement.readObjectFromFile(fileName).isEmpty()) {
            super.setOrders(orders);
        }
        return super.getOrders();
    }

    public void saveOrderList(ArrayList<Order> currentOrderList) {
        if (UserManagement.getUserProfession()) {
            String fileName = UserManagement.getName() + "OrderList.csv";
            ObjectFileManagement.writeObjectToFile(currentOrderList,fileName);
        }
        TextFileManagement.writeToFile(UserManagement.getName(),"ChefOrderList.txt");
    }
    public static void setFlag(boolean flag) {
        Waiter.flag = flag;
    }
    private void flagMethod() {
        setFlag(true);
    }

    public void displayOrders() {
        System.out.println(" ==== Active Orders ==== ");
        for (int i = 0; i < getOrders().size(); i++) {
            if (getOrders().get(i).getStatus().equals(Status.ACTIVE)) {
                flagMethod();
                System.out.println("--> Table with id " + getOrders().get(i).getTable().getTableId() + " has ACTIVE order");
                System.out.println((i + 1) + ". " + getOrders().get(i).toString());
            }
        }
        System.out.println();
    }

    public boolean checkTableStatus(int tableId) {
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
        ArrayList<Order> currentOrderList = getOrders();
        double sum = 0;
        if (checkTableStatus(chosenTable)) {
            FoodMenu.displayMenu();
            ArrayList<Food> addFoodToOrder = new ArrayList<>();
            while (choice != 0) {
                System.out.println("Choose from menu to add to the order! Or push 0 for exit!");
                choice = scan.nextInt();
                if (choice != 0) {
                    addFoodToOrder.add(order.getFoods().get(choice - 1));
                    sum = totalAmount(choice,order,sum);
                    System.out.println("Total amount: " + sum);
                }
            }
            currentOrderList.add(new Order(new Table(table.getTableId(), false), addFoodToOrder, Status.ACTIVE));
        } else {
            System.out.println("Table is busy!");
        }
        saveOrderList(currentOrderList);
    }

    public double totalAmount(int choice, Order order, double sum) {
        sum += order.getFoods().get(choice).getPrice();
        return sum;
    }


    private void addMealToOrder(int order) {
        ArrayList<Order> currentOrderList = getOrders();
        try {
            System.out.println(" ---- Choose from meals ---- ");
            int mealNumber = 0;
            for (Meal m : FoodMenu.getMeals()) {
                mealNumber++;
                System.out.println(mealNumber + "-> " + m);
            }
            int choice = (scan.nextInt() - 1);
            currentOrderList.get(order).getMeals().add(FoodMenu.getMeals().get(choice));
            System.out.println(FoodMenu.getMeals().get(choice));
            System.out.println(currentOrderList.get(order).getFoods().toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Chosen meal does not exist!");
        }
        saveOrderList(currentOrderList);
    }

    private void removeMealFromOrder(int order) {
        ArrayList<Order> currentOrderList = getOrders();
        System.out.println(currentOrderList.get(order).getMeals().toString());
        System.out.println(" ----> Which meal to remove from order? <----");
        int chosenMeal = 0;
        try {
            chosenMeal = (scan.nextInt() - 1);
            getOrders().get(order).getMeals().remove(chosenMeal);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Order number " + chosenMeal + " does not exist!");
        }
        saveOrderList(currentOrderList);
    }

    public void editOrder() {
        displayOrders();
        if (flag) {
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
        return;
    }

    private void readOrders() {
        int count = 0;
        for (Order order : getOrders()) {
            count++;
            System.out.println(count + " " + order);
        }

    }

    public void changeOrderStatus() {
        ArrayList<Order> currentOrderList = getOrders();
        if (!currentOrderList.isEmpty()) {
        readOrders();
        System.out.println(" ---- Choose any of orders to change status ---- ");
        try {
        int choice = (scan.nextInt() - 1);
        System.out.println(" ----> Your chosen order's status: " + getOrders().get(choice).getStatus());
        System.out.println(" ----> Served by pressing 'S' / Active by pressing 'A' / Paid by pressing 'P' <---- ");
            String setStatusTo = scan.next().toLowerCase();

            switch (setStatusTo) {
                case "s":
                    currentOrderList.get(choice).setStatus(Status.SERVED);
                    System.out.println("---> That order status is - SERVED");
                    break;
                case "a":
                    currentOrderList.get(choice).setStatus(Status.ACTIVE);
                    System.out.println("---> That order's status is - Active");
                    break;
                case "p":
                    currentOrderList.get(choice).setStatus(Status.PAID);
                    currentOrderList.remove(currentOrderList.get(choice));
                    System.out.println("---> That order's status is - Paid");
                default:
                    System.out.println("---> No such choice for status! ");
                }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Wrong order number!");
        }
    } else {
            System.out.println("No orders for changing STATUS! ");
        }
        saveOrderList(currentOrderList);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }
}

