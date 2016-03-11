package lab1;
/**
 * Created by Kaiqi Xu on 2016/3/10.
 */
public class CoffeeBased implements SizeFactor {

	@Override
	public double sizeCost(String size) {
		if (size.toLowerCase().equals("small")) {
			return 0.4;
		} else if (size.toLowerCase().equals("medium")) {
			return 0.7;
		} else if (size.toLowerCase().equals("large")){
			return 1.0;
		} else {//grant
			return 1.3;
		}
	}

}
