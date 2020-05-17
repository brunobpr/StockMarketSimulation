package view;

import java.text.DecimalFormat;
import java.util.ArrayList;

import data.Investor;

public class Printer {

	public static void investors(ArrayList<Investor> investors, String message) {
		System.out.println("======= The " + message  + " performance among investors =======");
		for (Investor investor : investors) {
			System.out.println("Name: " + investor.getName() + " | Shares: " + investor.getNumbOfShares() + " | Final Budget: " + format(investor.geBudgte()));
		}
		System.out.println("=======================================================");
	}
	
	
	private static String format(double value) {
		return new DecimalFormat("#.00").format(value);
	}

}
