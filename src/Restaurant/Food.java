package Restaurant;

import java.io.Serializable;

public class Food implements Serializable {
    private String name;
    private double price;

    public Food() {
        this.name = "unknown";
        this.price = 0.0;
    }

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ",price=" + price + "\n" +
                '}';
    }
}
