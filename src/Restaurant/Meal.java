package Restaurant;

public class Meal {
    private String name;
    private double price;
    private boolean isServed;

    public Meal() {

    }

    public Meal(String name, double price, boolean isServed) {
        this.name = name;
        this.price = price;
        this.isServed = isServed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isServed() {
        return isServed;
    }

    public void setServed(boolean served) {
        isServed = served;
    }

}
