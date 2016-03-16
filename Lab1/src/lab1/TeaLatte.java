package lab1;
/*
 * add new type of gingertea
 * created by Kaiqi Xu on 2016/3/12
 * */
public class TeaLatte extends RedTea {
	private String description;
	private RedTea redtea;
	private Milk milk;
	public TeaLatte() {
		redtea = new RedTea();
		milk =new Milk(redtea);
		description = "Tea Latte";
	}
	public String getDescription() {
		return description;
	}

	@Override
	public void setSize(String size) {
		redtea.setSize(size);
	}

	public double cost() {
		return milk.cost();
	}
}
