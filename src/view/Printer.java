package view;

import java.text.DecimalFormat;
import java.util.ArrayList;

import data.*;

public class Printer {

	//This class is only used to print the list of best/worst companies of the day
	//The methods are called from the ResultFacade
	
	/**
	 * @param investors the list of investors (worst/best) to be displayed 
	 * @param message a message of 'best' or 'worst'
	 */
	public static void investors(ArrayList<Investor> investors, String message) {
		System.out.println("======= The " + message  + " performance among investors =======");
		for (Investor investor : investors) {
			System.out.println("Name: " + investor.getName() + " | Shares: " + investor.getNumbOfShares()
			+ " | Final Budget: " + format(investor.geBudgte()));
		}
		System.out.println("=======================================================");
	}
	
	
	
	/**
	 * @param companies the list of companies (best/worst) to be displayed
	 * @param message a message of 'best' or 'worst'
	 */
	public static void companies(ArrayList<Company> companies, String message) {
		System.out.println("======= The " + message  + " performance among companies =======");
		for (Company company : companies) {
			System.out.println("Name: " + company.getName() + " | Capital: " + format(company.getCapital())
			+ " | Shares Price: " + format(company.getSharePrice()));
		}
		System.out.println("=======================================================");
	}
	
	
	/**
	 * @param value a double value with trillions of decimals digits ... not good to be displayed
	 * @return a string representing the double value with two decimal digits ... good to be displayed
	 */
	private static String format(double value) {
		return new DecimalFormat("#.00").format(value);
	}

}
