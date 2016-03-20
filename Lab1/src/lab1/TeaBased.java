package lab1;
/**
 * created by Zheyu Lu 2016/3/16
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TeaBased implements SizeFactor {
	private ArrayList<Size> sizeList;

	@Override
	public double sizeCost(String size) {
		sizeList = new ArrayList();
		sizeList.add(new Size("small", 0.2));
		sizeList.add(new Size("medium", 0.5));
		sizeList.add(new Size("large", 0.7));
		sizeList.add(new Size("grande", 0.9));
		for (int i = 0; i < sizeList.size(); i++) {
			if (sizeList.get(i).getSize().toLowerCase().equals(size)) {
				return sizeList.get(i).getCost();
			}
		}
		/*
		 * if (size.toLowerCase().equals("small")) { return 0.2; } else if
		 * (size.toLowerCase().equals("medium")) { return 0.5; } else if
		 * (size.toLowerCase().equals("large")){ return 0.7; } else { return
		 * 0.9; }
		 */
		return 0;
	}
}