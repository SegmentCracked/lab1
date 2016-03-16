package lab1;
/*
 * add new type of flowertea
 * created by Kaiqi Xu on 2016/3/12
 * */
public class FlowerTea extends GreenTea{
	private String description;
	private GreenTea greentea;
	private Jasmine jasmine;
	public FlowerTea() {
		greentea = new GreenTea();
		jasmine =new Jasmine(greentea);
		description = "Flower Tea";
	}
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		greentea.setSize(size);
	}

	public double cost() {
		return jasmine.cost();
	}
}
