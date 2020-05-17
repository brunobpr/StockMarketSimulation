package model;

import java.util.ArrayList;

import data.Company;
import data.FakeData;
import data.Investor;

public class Generator {

	// This is the Lazy Singleton class intended to generate a list of investors and
	// companies
	private static Generator instance = null;
	// Fakedata is the class from where the random data is extractred.
	FakeData fakeData = new FakeData();

	// Constructor
	private Generator() {
	}

	/**
	 * @return a ArrayList of 100 investors with random data
	 */
	public ArrayList<Investor> investors() {
		ArrayList<Investor> listOfInvestor = new ArrayList<Investor>();
		System.out.println("Generating fake investors...");
		for (int i = 0; i < 100; i++) {
			// New InvestorBuilder object with Unique ID in the constructors
			Investor.InvestorBuilder builder = new Investor.InvestorBuilder(fakeData.uniqueID());
			// Setting random name
			builder.setName(fakeData.firstName() + " " + fakeData.lastName());
			// Setting random budget
			builder.setBudget(fakeData.budget());
			// Addint to array list
			listOfInvestor.add(builder.build());
			System.out.println(builder.build());
		}
		return listOfInvestor;
	}

	/**
	 * @return a ArrayList of 100 companies with random data
	 */
	public ArrayList<Company> companies() {
		ArrayList<Company> listOfCompany = new ArrayList<Company>();
		System.out.println("Generating fake Companies...");
		for (int i = 0; i < 100; i++) {
			// New CompanyBuilder object with Unique ID in the constructors
			Company.CompanyBuilder builder = new Company.CompanyBuilder(fakeData.uniqueID());
			// Setting random name
			builder.setName(fakeData.companyName());
			// Setting random number of shares
			builder.setNumOfShares(fakeData.numOfShare());
			// Setting random shares price
			builder.setSharePrice(fakeData.sharePrice());
			// Adding to the array
			listOfCompany.add(builder.build());
			System.out.println(builder.build());
		}
		return listOfCompany;
	}

	// Returns the instance of the Generator class
	public static Generator getInstance() {
		if (instance == null) {
			instance = new Generator();
		}
		return instance;
	}

}