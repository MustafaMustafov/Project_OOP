package Restaurant;

public class Meal extends Food {
    private String type;
    private boolean isCooked;

    public Meal(String name, double price, String type, boolean isCooked) {
        super(name, price);
        this.type = type;
        this.isCooked = false;
    }

    public String getType() {
        return type;
    }

    public void setCooked(boolean cooked) {
        isCooked = cooked;
    }

    public boolean isCooked() {
        return isCooked;
    }

    @Override
    public String toString() {
        return "Name:" + getName() + "," + "Price: "+getPrice() + "," + "Type:"+getType() + "," + "Cooked: "+isCooked();
    }
}
