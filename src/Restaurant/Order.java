package Restaurant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Order {
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
        //set current time when the method was run
        Date thisTime = new Date();
        SimpleDateFormat setTime = new SimpleDateFormat("|dd.MM.yyyy | hh:mm|");
        this.orderTime =  setTime.format(thisTime);
    }

    public String getOrderTime() {
        return orderTime;
    }

    public ArrayList<Food> getMeals() {
        return foods;
    }

    public void setMeals(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }


    public String toString() {

        return "--> |orderTime=" + orderTime +
                " table=" + table +
                "| foods="  + foods +
                "| status=" + status +
                '|';
    }

    public static void main(String[] args) {
        Order or = new Order();
       int count =0;
        for (Food f: or.getFoods()){
            count++;
//            if(f.getClass().getName().equals("Drinks"))
            System.out.println(count + "-->" + f);
            System.out.println("================");
            System.out.println(f.getClass().getSimpleName());
        }


    }
}
