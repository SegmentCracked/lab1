package lab1;
/**
 * Created by Kaiqi Xu on 2016/3/10.
 */
public class TeaBased implements SizeFactor {

	@Override
	public double sizeCost(String size) {
		if (size.toLowerCase().equals("small")) {
			return 0.2;
		} else if (size.toLowerCase().equals("medium")) {
			return 0.5;
		} else if (size.toLowerCase().equals("large")){
			return 0.7;
		}
		else //grant
			return 0.9;
	}

}
