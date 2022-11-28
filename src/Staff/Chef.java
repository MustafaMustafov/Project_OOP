package Staff;

import Management.ObjectFileManagement;
import Management.TextFileManagement;
import Restaurant.*;

import java.util.ArrayList;
import java.util.Scanner;

import static Restaurant.MealStatus.COOKING;

public class Chef extends Employee implements Displayable {
    private static final Scanner scan = new Scanner(System.in);

    public Chef(String name, String userName, String password) {
        super(name, userName, password);
        getOrders();
    }

    public Chef() {
        super("Unknown", "Unknown", "unknown");
    }

    @Override
    public ArrayList<Order> getOrders() {
        String chefName = TextFileManagement.readFromFile("ChefOrderList.txt");
        return ObjectFileManagement.readObjectFromFile(chefName + "OrderList.csv");
    }

    public void displayOrders() {
        int count = 0;
        System.out.println(" ==== Active Orders ==== ");
        for (int i = 0; i < getOrders().size(); i++) {
            ArrayList<Food> tempFoodList = getOrders().get(i).getOrderFoods();
            if (getOrders().get(i).getStatus().equals(Status.ACTIVE)) {
                count=0;
                System.out.println("---> Table " + getOrders().get(i).getTable().getTableId() + " has ACTIVE " +
                        "order" + " --> № " + (i + 1) + " <---");
                for (Food f : tempFoodList) {
                    if (f.getClass().equals(Meal.class)) {
                        count++;
                        if (((Meal) f).getMealStatus().equals(COOKING)) {
                            System.out.println((tempFoodList.indexOf(f)+1) + ". " + f);
                        }
                    }
                }

            }
            System.out.println(count==0?"Table has not any meal for " +
                    "cooking!\n--------------------------------------":
                    "--------------------------------------");
        }
    }

    public void updateOrderStatus() {
        ArrayList<Order> currentOrderList = getOrders();
        displayOrders();
        System.out.println("Enter order: ");
        try {
            int order = (scan.nextInt() - 1), i = 1;
            for (Food f : getOrders().get(order).getOrderFoods()) {
                System.out.println(i + " ---> " + f);
                i++;
            }
            System.out.println("Enter meal to change status to COOKED: ");
            int meal = scan.nextInt() - 1;
            changeOrderStatus(currentOrderList, order, meal);
        } catch (Exception e) {
            System.out.println("Wrong choice!");
        }
        saveOrderList(currentOrderList);
    }

    public void changeOrderStatus(ArrayList<Order> currentOrderList, int order, int meal) {

        if (getOrders().get(order).getOrderFoods().get(meal).getClass().toString().equals("class Restaurant.Drink")) {
            System.out.println("Wrong choice, a drink has been selected!");
        } else {
            Meal mealToUpdate = (Meal) getOrders().get(order).getOrderFoods().get(meal);
            if (!((Meal) getOrders().get(order).getOrderFoods().get(meal)).getMealStatus().equals(MealStatus.COOKED)) {
                currentOrderList.get(order).getOrderFoods().remove(meal);
                mealToUpdate.setMealStatus(MealStatus.COOKED);
                currentOrderList.get(order).getOrderFoods().add(mealToUpdate);
            } else {
                System.out.println(getOrders().get(order).getOrderFoods().get(meal).getName() + " was already cooked," +
                        " " +
                        "please choose another one!");
            }
        }
    }

    public void saveOrderList(ArrayList<Order> currentOrderList) {
        String waiterName = TextFileManagement.readFromFile("ChefOrderList.txt");
        String fileName = waiterName + "OrderList.csv";
        ObjectFileManagement.writeObjectToFile(currentOrderList, fileName);

    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }
}
