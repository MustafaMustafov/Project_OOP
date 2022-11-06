package Restaurant;

public class Food extends Meal {
    private String type;

    public Food(String name,double price, boolean isServed, String type) {
        super(name, price, isServed);
        this.type = type;
    }
}
