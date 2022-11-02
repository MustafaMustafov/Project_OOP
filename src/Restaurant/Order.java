package Restaurant;

import Restaurant.Meal;
import Staff.Waiter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Waiter waiter;
    private Date orderTime;
    private Map<String , Meal> meals;
    private Map<Integer, Table> tables;

    public Order(Waiter waiter, Map<String,Meal> meals, Map<Integer, Table> tables) {
        this.waiter = waiter; //TODO waiter.getName();
        this.meals = new HashMap<>();
        this.tables = new HashMap<>();
        setOrderTime(orderTime);
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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
