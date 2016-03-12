package lab1;

public abstract class Beverage {
	protected SizeFactor sizeFactor;

	public double cost() {
		return 0;
	}

	public abstract void setSize(String size);
}
