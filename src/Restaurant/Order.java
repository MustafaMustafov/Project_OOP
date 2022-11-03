package Restaurant;

import Staff.Waiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Waiter waiter;
//    private String orderTime;                 //replaced with method
    private Map<String , Meal> meals;
    private Map<Integer, Table> tables;

    public Order(Waiter waiter, Map<String,Meal> meals, Map<Integer, Table> tables) {
        this.waiter = waiter; //TODO waiter.getName();
        this.meals = new HashMap<>();
        this.tables = new HashMap<>();
        getOrderTime(); //when order is created the timer will be set!!!
    }
    public Order(){
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public String getOrderTime() {
        //set current time when the method was run
        Date thisTime = new Date();
        SimpleDateFormat setTime = new SimpleDateFormat("|dd.MM.yyyy | hh:mm|");
        return setTime.format(thisTime);
    }

    public Map<String, Meal> getMeals() {
        return meals;
    }

    public void setMeals(Map<String, Meal> meals) {
        this.meals = meals;
    }

    public Map<Integer, Table> getTables() {
        return tables;
    }

    public void setTables(Map<Integer, Table> tables) {
        this.tables = tables;
    }
}
