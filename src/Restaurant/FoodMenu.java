package Restaurant;

import java.util.ArrayList;

public abstract class FoodMenu {
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

    public static void main(String[] args) {
        ArrayList<Meal> meals = loadList("Meals.csv");
        ArrayList<Drink> drinks = loadList("Drinks.csv");
        readList(meals);
        System.out.println("------------");
        readList(drinks);
    }
}