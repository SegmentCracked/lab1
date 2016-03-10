package lab1;
/*add new type of coffee*/
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
