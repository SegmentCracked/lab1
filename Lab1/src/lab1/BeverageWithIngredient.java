package lab1;

public class BeverageWithIngredient extends Beverage {
	private Beverage drink;
	protected String description;

	public BeverageWithIngredient(Beverage drink) {
		this.drink = drink;
	}
	
	public String getDescription(){
		return description;
	}

	@Override
	public void setSize(String size) {
		drink.setSize(size);
	}

	public double cost() {
		return drink.cost();
	}
}
