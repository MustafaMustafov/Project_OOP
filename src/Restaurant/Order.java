package Restaurant;

import Staff.Waiter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Waiter waiter;
    private String orderTime;                 //replaced with method
    private List<Meal> meals;
    private Table table;

    public Order(Waiter waiter, Table table, List<Meal> meals) {
        this.waiter = waiter;
        this.table = table;
        this.meals = new ArrayList<>();
        setOrderTime();                         //when order is created the timer will be set!!!
    }
    public Order(){
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public void setOrderTime() {
        //set current time when the method was run
        Date thisTime = new Date();
        SimpleDateFormat setTime = new SimpleDateFormat("|dd.MM.yyyy | hh:mm|");
        this.orderTime =  setTime.format(thisTime);
    }

    public String getOrderTime() {
        return orderTime;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
