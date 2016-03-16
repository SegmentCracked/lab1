package lab1;

public class BeverageWithIngredient extends Beverage {
	private Beverage drink;
	protected String description;
	private int nameSpaceCount = 0;

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
	protected void setNameSpaceCount(int v){
		nameSpaceCount=v;
	}
	public int getNameSpaceCount() {
		return nameSpaceCount;
	}

	public double cost() {
		return drink.cost();
	}
}
