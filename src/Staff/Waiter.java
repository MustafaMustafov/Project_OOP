package Staff;

import Restaurant.Food;
import Restaurant.Meal;
import Restaurant.FoodMenu;

import java.util.Scanner;

public class Waiter extends Employee {
    public static Scanner scan = new Scanner(System.in);
    public Waiter(String name, String userName, String password) {
        super(name, userName, password);
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

}

