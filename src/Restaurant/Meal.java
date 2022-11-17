package Restaurant;

public class Meal extends Food {
    private String type;
    private Enum<MealStatus> mealStatus;

    public Meal(String name, double price, String type, Enum<MealStatus> mealStatus) {
        super(name, price);
        this.type = type;
        this.mealStatus = MealStatus.COOKING;
    }

    public String getType() {
        return type;
    }


    public Enum<MealStatus> getMealStatus() {
        return mealStatus;
    }

    public void setMealStatus(Enum<MealStatus> mealStatus) {
        this.mealStatus = mealStatus;
    }

    @Override
    public String toString() {
        return "Name:" + getName() + "," + "Price: "+getPrice() + "," + "Type:"+getType() + "," + "Status: "+mealStatus;
    }
}
