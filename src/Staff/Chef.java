package Staff;

import Management.ObjectFileManagement;
import Management.TextFileManagement;
import Restaurant.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Chef extends Employee implements Displayable{
    private static Scanner scan = new Scanner(System.in);

    public Chef(String name, String userName, String password) {
        super(name,userName,password);
        getOrders();
    }

    public Chef(){
        super("Unknown","Unknown","unknown");
    }

    @Override
    public ArrayList<Order> getOrders() {
        String chefName = TextFileManagement.readFromFile("ChefOrderList.txt");
        return ObjectFileManagement.readObjectFromFile(chefName+"OrderList.csv");
    }
    public void displayOrders() {
        System.out.println(" ==== Active Orders ==== ");
        for (int i = 0; i < getOrders().size() ; i++) {
            if (getOrders().get(i).getStatus().equals(Status.ACTIVE)) {
                System.out.println("---> Table with id " + getOrders().get(i).getTable().getTableId() + " has ACTIVE order");
                System.out.println(i+1 + ". "  + getOrders().get(i).toString());
            }
        }
        System.out.println();
    }

    public void updateOrderStatus() {
        ArrayList<Order> currentOrderList = getOrders();
        System.out.println("Enter order: ");
        int order = scan.nextInt(), i = 1;
            for (Food f : getOrders().get(order).getMeals()) {
                System.out.println(i + " ---> " + f);
                i++;
            }
            System.out.println("Enter meal to change status to COOKED: ");
            int meal = scan.nextInt()-1;
        changeOrderStatus(currentOrderList, order, meal);
        saveOrderList(currentOrderList);
    }

    public void changeOrderStatus(ArrayList<Order> currentOrderList, int order, int meal) {
        if (getOrders().get(order).getMeals().get(meal).getClass().toString().equals("Restaurant.Drink")) {
            System.out.println("Wrong food choice!");
        } else {
            Meal mealToUpdate =(Meal) getOrders().get(order).getMeals().get(meal);
            currentOrderList.get(order).getMeals().remove(meal);
            mealToUpdate.setMealStatus(MealStatus.COOKED);
            currentOrderList.get(order).getMeals().add(mealToUpdate);
        }
    }

    public void saveOrderList(ArrayList<Order> currentOrderList) {
        String waiterName = TextFileManagement.readFromFile("ChefOrderList.txt");
        String fileName = waiterName + "OrderList.csv";
        ObjectFileManagement.writeObjectToFile(currentOrderList,fileName);

    }
    @Override
    public String getUserName() {
        return super.getUserName();
    }
}
