package lab1;
/*
 * add new type of coffee-decaf mocha
 * created by Zheyu Lu on 2016/3/10
 * */
public class DecafMocha extends CoffeeBeverage {
	private String description;
	
	public DecafMocha() {
		description = "Decaf Mocha";
	}
	
	public String getDescription() {
		return description;
	}

	public double cost() {
		return super.cost() + 1.0;
	}
}
