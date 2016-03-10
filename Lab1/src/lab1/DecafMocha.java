package lab1;
/*
 * add new type of coffee-decaf mocha
 * created by Zheyu Lu on 2016/3/10
 * */
public class DecafMocha extends Decaf {
	private String description;
	private Chocolate chocolate=new Chocolate(new Decaf());
	public DecafMocha() {
		description = super.getDescription()+" Mocha";
	}
	
	public String getDescription() {
		return description;
	}

	public double cost() {
		return super.cost() + chocolate.cost();
	}
}
