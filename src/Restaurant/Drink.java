package Restaurant;

public class Drink extends Food {


    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return getName() + "," + getPrice();
    }
}
