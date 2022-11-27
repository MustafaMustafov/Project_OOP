package Restaurant;

import Management.ObjectFileManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodMenu {
    private static Scanner scan = new Scanner(System.in);
    public static ArrayList<Meal> meals = loadList("Meals.csv");
    public static ArrayList<Drink> drinks = loadList("Drinks.csv");

    public static ArrayList<Meal> getMeals() {
        return meals;
    }

    public static ArrayList<Drink> getDrinks() {
        return drinks;
    }



    public static <T> ArrayList<T> loadList(String fileName) {
        ArrayList<T> newList = new ArrayList<>();
        ArrayList<T> temp = Management.ObjectFileManagement.readObjectFromFile(fileName);
        for (var l : temp) {
            newList.add(l);
        }
        return newList;
    }

    private static <T> void readList(ArrayList<T> list) {
        int count = 0;
        for (T temp : list) {
            count++;
            System.out.println(count + "-> " + temp);
        }
    }

    public void addMealToMenu() {
        try {
            System.out.println("----------------------------");
            System.out.println("Enter meal name: ");
            String mealName = scan.nextLine();
            System.out.println("Enter meal price: ");
            double mealPrice = scan.nextDouble();
            scan.nextLine();
            System.out.println("Enter meal type: ");
            String mealType = scan.next();
            FoodMenu.meals.add(new Meal(mealName, mealPrice, mealType, MealStatus.COOKING));
            ObjectFileManagement.writeObjectToFile(meals,"Meals.csv");
        }catch (Exception e){
            System.out.println("Wrong entered data!\n----------------------------");
        }
        scan.nextLine();
    }

    public void removeMealFromMenu() {
        Order order = new Order();
        System.out.println(order.getFoodsList().size());
        System.out.println("Enter meal number (1 to " +FoodMenu.meals.size() +") to remove from menu: ");
        int mealNumber = (scan.nextInt() - 1);
        try {
            if (mealNumber <= FoodMenu.meals.size()) {
                FoodMenu.meals.remove(mealNumber);
                ObjectFileManagement.writeObjectToFile(meals,"Meals.csv");
            }
        }catch (Exception e){
            System.out.println("Selected Item is not a Meal!");
        }
    }

    public static void displayMenu() {
        Order order = new Order();
        System.out.println(" ============== Menu ============== ");
        for (int i = 0; i < order.getFoodsList().size(); i++) {
            System.out.println((i + 1) + "-->" + order.getFoodsList().get(i) +
                    "\n----------------------------------------------");
        }
    }

    public static void main(String[] args) {
        ArrayList<Meal> meals = loadList("Meals.csv");
        ArrayList<Drink> drinks = loadList("Drinks.csv");
        readList(meals);
        System.out.println("------------");
        readList(drinks);
    }
}