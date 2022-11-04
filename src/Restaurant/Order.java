package Restaurant;

import Staff.Waiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
    private Waiter waiter;
    private String orderTime;                 //replaced with method
    private List<String> meals;
    private String table;

    public Order(Waiter waiter, List<String> meals, String table) {
        this.waiter = waiter;
        this.meals = meals;
        this.table = table;
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

    public List<String> getMeals() {
        return meals;
    }

    public void setMeals(List<String> meals) {
        this.meals = meals;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
