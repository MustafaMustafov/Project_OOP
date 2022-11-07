import Management.ObjectFileManagement;
import Restaurant.Drink;
import Restaurant.Meal;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Meal m = new Meal("Garlic bread",2.1,"Starter", false);
        Meal m1 = new Meal("Green salad",2.9,"Starter", false);
        Meal m2 = new Meal("Grilled mushrooms",3.1,"Starter", false);
        Meal m3 = new Meal("Vegetable soup",3.5,"Starter", false);
        Meal m4 = new Meal("Onion rings",3.5,"Starter", false);
        Meal m5 = new Meal("Pasta salad",3.9,"Starter", false);
        Meal m6 = new Meal("Cornish pasty",3.9,"Starter", false);
        Meal m7 = new Meal("Chicken wings",4.1,"Starter", false);
        Meal m8 = new Meal("Meatballs",4.4,"Starter", false);
        Meal m9 = new Meal("Spaghetti",6,"Main", false);
        Meal m10 = new Meal("Meatloaf",7.2,"Main", false);
        Meal m11 = new Meal("Grilled chicken",7.5,"Main", false);
        Meal m12 = new Meal("Lasagna",8.5,"Main", false);
        Meal m13= new Meal("Steak",8.9,"Main", false);
        Meal m14 = new Meal("Lamb chops",9.2,"Main", false);
        Meal m15 = new Meal("King prawns",9.9,"Main", false);
        Meal m16 = new Meal("Frutti del Mare",9.9,"Main", false);
        Meal m17 = new Meal("Apple pie;3",3,"Dessert", true);
        Meal m18 = new Meal("Backberry pie",3.1,"Dessert", true);
        Meal m19 = new Meal("Pumpkin pie",3.3,"Dessert", true);
        Meal m20 = new Meal("Chocolate cake",3.5,"Dessert", true);
        Meal m21 = new Meal("Ice cream;3.7",3.7,"Dessert", true);
        Meal m22= new Meal("Fruit salad",4,"Dessert", true);
        ArrayList<Meal> meals = new ArrayList<>();
        Collections.addAll(meals, m, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20, m21, m22);
        for (Meal meal :meals ){
            System.out.println(meal);
        }
        ObjectFileManagement.writeObjectToFile(Collections.singletonList(meals));

        System.out.println("-----------------");
        Drink d = new Drink("Water", 1);
        Drink d1 = new Drink("Coffee expresso", 2);
        Drink d2 = new Drink("Juice", 1.8);
        Drink d3 = new Drink("Tonic", 1.5);
        Drink d4 = new Drink("Refreshment", 2);
        Drink d5 = new Drink("Cola bottle /250 ml/", 1.7);
        Drink d6 = new Drink("Bitter", 1.85);
        Drink d7 = new Drink("Corona beer", 2.5);
        Drink d8 = new Drink("Heineken beer", 2.2);
        Drink d9 = new Drink("Budweiser", 2.7);
        Drink d10 = new Drink("wine / glass 250 ml/", 2.7);
        Drink d11 = new Drink("Red wine bottle /750 ml/", 25);
        Drink d12 = new Drink("white wine bottle /750ml/", 22);
        Drink d13 = new Drink("Rakiya / 50 ml/", 2.5);
        Drink d14 = new Drink("Yeni Raki / 50 ml /", 3);
        Drink d15 = new Drink("Whiskey Label 5 / 50 ml/", 5);
        Drink d16 = new Drink("Whiskey Four roses / 50 ml /", 6.5);
        Drink d17 = new Drink("Jim beam / 50 ml /", 5);
        Drink d18 = new Drink("Irish SEXTON / 50 ml/ ", 15);
        ArrayList<Drink> drinks = new ArrayList<>();
        Collections.addAll(drinks, d, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17);
        for (Drink drink :drinks ){
            System.out.println(drink);
        }
        ObjectFileManagement.writeObjectToFile(Collections.singletonList(drinks));
    }



}