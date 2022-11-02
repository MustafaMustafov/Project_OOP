public class Drink extends Meal{
    private boolean isDrinkHot;
    private int size;

    public Drink(String name, double price, boolean isServed, boolean isDrinkHot, int size) {
        super(name, price, isServed);
        this.isDrinkHot = isDrinkHot;
        this.size = size;
    }

}
