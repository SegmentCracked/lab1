package lab1;
/*
 * add new type of decaflatte
 * created by Kaiqi Xu on 2016/3/12
 * */
public class DecafLatte extends Decaf{
	private String description;
	private Decaf decaf;
	private Milk milk;
	public DecafLatte() {
		decaf = new Decaf();
		milk =new Milk(decaf);
		description = super.getDescription()+" Latte";
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		decaf.setSize(size);
	}

	public double cost() {
		return milk.cost();
	}

}
