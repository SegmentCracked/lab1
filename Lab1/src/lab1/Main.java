package lab1;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
	private static void outputOrderCost(double totalCost) {
		DecimalFormat df = new DecimalFormat(".0");
		String valueStr = df.format(totalCost);
		if (valueStr.equals(".0")) valueStr = "0.0";
		System.out.println("The total cost of your order is: " + valueStr);
	}

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

		int i;
		for (i = 0; i < disArr.length; i++)
			if (disArr[i].equals("small") || disArr[i].equals("medium")
					|| disArr[i].equals("large"))
				break;

		if (i >= disArr.length) {
			throw new ArgumentMissingException("Must set a size!");
		}

		String beveStr;
		if (i == 2) {
			beveStr = disArr[0] + " " + disArr[1];
		} else {
			beveStr = disArr[0];
		}
		Beverage order;
		if (beveStr.equals("espresso")) {
			order = new CoffeeBeverage();
			order = new Espresso();
			((CoffeeBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("houseblend")) {
			order = new CoffeeBeverage();
			order = new HouseBlend();
			((CoffeeBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("mocha")) {
			order = new Espresso();
			((CoffeeBeverage) order).setSize(disArr[i]);
			order = new Chocolate(order);
		} else if (beveStr.equals("latte")) {
			order = new Espresso();
			((CoffeeBeverage) order).setSize(disArr[i]);
			order = new Milk(order);
		} else if (beveStr.equals("cappuccino")) {
			order = new Espresso();
			((CoffeeBeverage) order).setSize(disArr[i]);
			order = new WhipCream(order);
		} else if (beveStr.equals("green tea")) {
			order = new GreenTea();
			((TeaBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("red tea")) {
			order = new RedTea();
			((TeaBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("white tea")) {
			order = new WhiteTea();
			((TeaBeverage) order).setSize(disArr[i]);
		} else if (beveStr.equals("flower tea")) {
			order = new GreenTea();
			((TeaBeverage) order).setSize(disArr[i]);
			order = new Jasmine(order);
		} else if (beveStr.equals("ginger tea")) {
			order = new GreenTea();
			((TeaBeverage) order).setSize(disArr[i]);
			order = new Ginger(order);
		} else if (beveStr.equals("tea latte")) {
			order = new RedTea();
			((TeaBeverage) order).setSize(disArr[i]);
			order = new Milk(order);
		} else if (beveStr.equals("decaf mocha")) {
			order = new DecafMocha();
			((CoffeeBeverage) order).setSize(disArr[i]);
			order = new Chocolate(order);
		} else {
			throw new IllegalInputException(beveStr);
		}

		for (i++; i < disArr.length; i++) {
			if (disArr[i].equals("chocolate")) {
				order = new Chocolate(order);
			} else if (disArr[i].equals("ginger")) {
				order = new Ginger(order);
			} else if (disArr[i].equals("milk")) {
				order = new Milk(order);
			} else if (disArr[i].equals("jasmine")) {
				order = new Jasmine(order);
			} else if (disArr[i].equals("whip")) {
				i++;
				order = new WhipCream(order);
			} else {
				throw new IllegalInputException(disArr[i]);
			}
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
