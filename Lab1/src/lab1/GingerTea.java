package lab1;
/*
 * add new type of gingertea
 * created by Kaiqi Xu on 2016/3/12
 * */
public class GingerTea extends GreenTea{
	private String description;
	private GreenTea greentea;
	private Ginger ginger;
	public GingerTea() {
		greentea = new GreenTea();
		ginger =new Ginger(greentea);
		description = "Ginger Tea";
	}
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		greentea.setSize(size);
	}

	public double cost() {
		return ginger.cost();
	}
}
