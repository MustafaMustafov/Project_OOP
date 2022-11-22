package Restaurant;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Order implements Serializable {
    private static Timer timer = new Timer();
    private Table table;
    private String orderTime;
    private ArrayList<Food> foods;
    private Enum<Status> status;


    public Enum<Status> getStatus() {
        return status;
    }

    public Order(Table table, ArrayList<Food> foods, Enum<Status> status) {
        this.table = table;
        this.foods = foods;
        this.status = Status.ACTIVE;
        setOrderTime();
        callTimerTask();
    }

    public void callTimerTask() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Check table with id --> " + getTable().getTableId());
            }
        }, 10000, 50000);
    }
    public void setStatus(Enum<Status> status) {
        this.status = status;
    }

    public ArrayList<Food> getFoods() {
        ArrayList<Food> newList = new ArrayList<>(FoodMenu.getMeals());
        newList.addAll(FoodMenu.getDrinks());
        return newList;
    }

    public Order(){
        this.foods = new ArrayList<>();
    }


    public void setOrderTime() {
        Date thisTime = new Date();
        SimpleDateFormat setTime = new SimpleDateFormat("|dd.MM.yyyy | hh:mm|");
        this.orderTime =  setTime.format(thisTime);
    }

    public ArrayList<Food> getMeals() {
        return foods;
    }

    public Table getTable() {
        return table;
    }

    public String toString() {

        return "| orderTime-> " + orderTime + " | \n" +
                "   | table-> " + table + " | \n" +
                "   | foods-> "  + foods +" | \n" +
                "   | status-> " + status + " | \n" +
        "--------------------------------------------------";
    }
}
