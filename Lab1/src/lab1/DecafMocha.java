package lab1;
/*
 * add new type of coffee-decaf mocha
 * created by Zheyu Lu on 2016/3/10
 * */
public class DecafMocha extends Decaf {
	private String description;
	private Decaf decaf;
	private Chocolate chocolate;
	public DecafMocha() {
		decaf = new Decaf();
		chocolate =new Chocolate(decaf);
		description = super.getDescription()+" Mocha";
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		decaf.setSize(size);
	}

	public double cost() {
		return chocolate.cost();
	}
}
