package lab1;
/*
 * add new type of cappuccino
 * created by Kaiqi Xu on 2016/3/12
 * */
public class Cappuccino extends Espresso{
	private String description;
	private Espresso espresso;
	private WhipCream whipcream;
	public Cappuccino() {
		espresso=new Espresso();
		whipcream=new WhipCream(espresso);
		description="Cappuccino";
	}
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		espresso.setSize(size);
	}

	public double cost() {
		return whipcream.cost();
	}
}
