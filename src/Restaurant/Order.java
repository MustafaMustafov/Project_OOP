package Restaurant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int tableId;
    private String orderTime;                 //replaced with method
    private List<Food> foods;


    public Order(int tableId, List<Food> foods) {
        this.tableId = tableId;
        this.foods = new ArrayList<>();
        setOrderTime();                         //when order is created the timer will be set!!!
    }
    public Order(){
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

    public List<Food> getMeals() {
        return foods;
    }

    public void setMeals(List<Food> foods) {
        this.foods = foods;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTable(int tableId) {
        this.tableId = tableId;
    }
}
