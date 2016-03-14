package lab1;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
	/**
	 * Output the total cost to System.out
	 * @param totalCost
     */
	private static void outputOrderCost(double totalCost) {
		DecimalFormat df = new DecimalFormat(".0");
		String valueStr = df.format(totalCost);
		if (valueStr.equals(".0")) valueStr = "0.0";
		System.out.println("The total cost of your order is: " + valueStr);
	}

	/**
	 * Split arguments into array of String[] by ";"
	 * @param args
	 * @return a array of String[]. Each item is a list of arguments.
     */
	public static String[][] argumentSplit(String []args){
		ArrayList<Integer> semicolonPosition=new ArrayList<>();
		for (int i=0;i<args.length;++i){
			if (args[i].equals(";")) semicolonPosition.add(i);
		}
		semicolonPosition.add(args.length);
		String ret[][]=new String[semicolonPosition.size()][];
		int j=0;
		for (int i=0;i<semicolonPosition.size();++i){
			ret[i]=new String[semicolonPosition.get(i)-j];
			for (int k=0;j<semicolonPosition.get(i);++j,++k){
				ret[i][k]=args[j];
			}
			j=semicolonPosition.get(i)+1;
		}
		return ret;
	}

	/**
	 * Find size argument in the arguments.
	 * @param disArr
	 * @return the index of size argument.
	 * @throws ArgumentMissingException
     */
	private static int getSizeArgumentPosition(String disArr[]) throws ArgumentMissingException{
		int i;
		for (i = 0; i < disArr.length; i++)
			if (disArr[i].equals("small") || disArr[i].equals("medium")
					|| disArr[i].equals("large") || disArr[i].equals("grande"))
				break;

		if (i >= disArr.length) {
			throw new ArgumentMissingException("Must set a size!");
		}
		return i;
	}

	/**
	 * Parse the arguments into an OrderItem
	 * @param args a array of arguments
	 * @return an OrderItem object of the command
	 * @throws IllegalInputException
	 * @throws ArgumentMissingException
     */
	public static OrderItem getOrderFromArgument(String[] args) throws IllegalInputException, ArgumentMissingException{
		//evaluate the amount
		int amount;
		int argumentStartPos;
		try {
			amount = Integer.valueOf(args[0]);
			argumentStartPos = 1;
		} catch (NumberFormatException e) {
			amount = 1;
			argumentStartPos = 0;
		}
		String[] disArr = new String[args.length - argumentStartPos];
		for (int j = 0; j < disArr.length; j++) {
			disArr[j] = args[j + argumentStartPos].toLowerCase();
		}
		int sizeArgPos= getSizeArgumentPosition(disArr);
		String beveStr;
		if (sizeArgPos == 2) {
			beveStr = disArr[0] + " " + disArr[1];
		} else {
			beveStr = disArr[0];
		}

		Beverage order= null;
		try {
			order = BeverageFactory.getInstance().createBeverage(beveStr);
			order.setSize(disArr[sizeArgPos]);
			for (int i = sizeArgPos + 1; i < disArr.length; i++) {
				BeverageWithIngredient orderTmp=IngredientFactory.getInstance().createIngredient(disArr[i], order);
				i+=orderTmp.getNameSpaceCount();
				order=orderTmp;
			}
		} catch (BeverageNotFoundException e) {
			throw new IllegalInputException(beveStr);
		} catch (Exception e){
			System.out.println("Fatal error while finding beverage: ");
			e.printStackTrace();
			System.exit(1);
		}
		/**
		 * How do I get the description of each order instead of doing this
		 * stupid thing forever (except for printing the args)?
		 */
		if (order instanceof BeverageWithIngredient) {
			((BeverageWithIngredient) order).getDescription();
		} else if (order instanceof Espresso) {
			((Espresso) order).getDescription();
		}
		// and so on...
		return new OrderItem(order,amount);
	}
	public static void main(String[] args) {
		String request[][]=argumentSplit(args);
		OrderItem orderItems[]=new OrderItem[request.length];
		double totalCost=0;
		try {
			for (int i = 0; i < request.length; ++i) {
				orderItems[i]=getOrderFromArgument(request[i]);
				totalCost+=orderItems[i].cost();
			}
		}catch (IllegalInputException e){
			System.out.println("Illegal input: "+e.getInputStr());
			return ;
		} catch (ArgumentMissingException e){
			System.out.println(e.getMessage());
			return ;
		}
		outputOrderCost(totalCost);
	}
}
