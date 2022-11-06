package Restaurant;

public class Drink extends Meal {
    private boolean isDrinkHot;
    private int size;

    public Drink(String name, double price, boolean isServed, boolean isDrinkHot, int size) {
        super(name, price, isServed);
        this.isDrinkHot = isDrinkHot;
        this.size = size;
    }

    public boolean isDrinkHot() {
        return isDrinkHot;
    }

    public void setDrinkHot(boolean drinkHot) {
        isDrinkHot = drinkHot;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
