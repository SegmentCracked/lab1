package lab1;
/*
 * created by Zheyu Lu 2016/3/16
 */
public class Size {
	private String size;
	private double cost;
	Size(String size,double cost) {
		this.size=size;
		this.cost=cost;
	}
	public double getCost() {
		return this.cost;
	}
	public String getSize() {
		return this.size;
	}
}
