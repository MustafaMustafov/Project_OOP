package Restaurant;

public class Meal extends Food {
    private String type;
    private boolean isServed;

    public Meal(String name, double price, String type, boolean isServed) {
        super(name, price);
        this.type = type;
        this.isServed = isServed;
    }

    public String getType() {
        return type;
    }
}
