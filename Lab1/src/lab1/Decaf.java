package lab1;

/**
 * Created by Mengxiao Lin on 2016/3/10.
 */
public class Decaf extends CoffeeBeverage{
    private String description;

    public Decaf() {
        description = "Decaf";
    }

    public String getDescription() {
        return description;
    }

    public double cost() {
        return super.cost() + 0.5;
    }
}
