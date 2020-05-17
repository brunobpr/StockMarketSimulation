package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import data.*;

public class TradeSimulation {
	private ArrayList<Investor> listOfInvestor;
	private ArrayList<Company> listOfCompany;
	int counter = 0;
	private int outOfBudget = 0;
	private int outOfBusiness = 0;

	Random random = new Random();

	public TradeSimulation() {
	}

	public int start(ArrayList<Investor> investors, ArrayList<Company> companies) {
		this.listOfInvestor = investors;
		this.listOfCompany = companies;
		while (outOfBudget < 100 && outOfBusiness < 100) {
				Investor investor = listOfInvestor.get(random.nextInt(100));
				Company company = listOfCompany.get(random.nextInt(100));
				buy(investor, company);			
		}	
		return counter;
	}

	public void buy(Investor investor, Company company) {
		if (company.getNumOfShares() > 0) {
			if (investor.geBudgte() > company.getSharePrice()) {
				if (investor.geBudgte() * 0.15 > company.getSharePrice()) {
					trade(investor, company);
				} else {
					saveInvestment(investor, company.getSharePrice());
				}
			} else {
				budgetChecker(investor);
			}
		} else {
			System.out.println(company.getName() + " is out of businness");
			outOfBusiness++;
		}
	}

	private void saveInvestment(Investor investor, double badPrice) {
		for (Company company : listOfCompany) {
			if (company.getSharePrice() < badPrice) {
				System.out.println(investor.getName() + " made a best investment saving " + (badPrice - company.getSharePrice()) +"USD");
				trade(investor, company);
				return;
			}
		}
	}

	private void trade(Investor investor, Company company) {

		double value = company.getSharePrice();
		System.out.println(investor.getName() + " bought " + value + " from " + company.getName() + " and now has " + investor.geBudgte() +"USD available!");
		company.sell();
		investor.buy(value);
		counter++;
	}

	private boolean budgetChecker(Investor investor) {
		for (int i = 0; i < listOfCompany.size(); i++) {
			if (investor.geBudgte() > listOfCompany.get(i).getSharePrice()) {
				return true;
			}
		}
		System.out.println(investor.getName() + " is out of money with " + investor.getNumbOfShares() + " shares!");
		System.out.println(outOfBudget);
		outOfBudget++;
		return false;
	}

	public ArrayList<Investor> getInvestors() {
			return listOfInvestor;
	}

	public ArrayList<Company> getCompanies() {
		return listOfCompany;
	}

}
