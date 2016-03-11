package lab1;
/*
 * add new type of mocha
 * created by Kaiqi Xu on 2016/3/12
 * */
public class Mocha extends Espresso{
	private String description;
	private Espresso espresso;
	private Chocolate chocolate;
	public Mocha() {
		espresso=new Espresso();
		chocolate=new Chocolate(espresso);
		description="Mocha";
	}
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		espresso.setSize(size);
	}

	public double cost() {
		return chocolate.cost();
	}
}
