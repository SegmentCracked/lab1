package lab1;
/*
 * add new type of decafcappuccino
 * created by Kaiqi Xu on 2016/3/12
 * */
public class DecafCappuccino extends Decaf{
	private String description;
	private Decaf decaf;
	private WhipCream whipcream;
	public DecafCappuccino() {
		decaf = new Decaf();
		whipcream =new WhipCream(decaf);
		description = super.getDescription()+" Cappuccino";
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		decaf.setSize(size);
	}

	public double cost() {
		return whipcream.cost();
	}
}
