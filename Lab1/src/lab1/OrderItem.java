package lab1;

/**
 * Created by Mengxiao Lin on 2016/3/11.
 */
public class OrderItem {
    private Beverage beverage;
    private int amount;

    public OrderItem(Beverage beverage, int amount) {
        this.beverage = beverage;
        this.amount = amount;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    public void setBeverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public double cost(){
        return beverage.cost()*amount;
    }
}
