package lab1;
/*
 * add new type of latte
 * created by Kaiqi Xu on 2016/3/12
 * */
public class Latte extends Espresso{
	private String description;
	private Espresso espresso;
	private Milk milk;
	public Latte() {
		espresso=new Espresso();
		milk=new Milk(espresso);
		description="Latte";
	}
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		espresso.setSize(size);
	}

	public double cost() {
		return milk.cost();
	}
}
