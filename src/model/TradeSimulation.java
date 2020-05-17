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

	public TradeSimulation(ArrayList<Investor> investors, ArrayList<Company> companies) {
		this.listOfInvestor = investors;
		this.listOfCompany = companies;

		start();
	}

	private void start() {
		while (outOfBudget < 100 && outOfBusiness < 100) {
			for (Investor investor : listOfInvestor) {
				Company company = listOfCompany.get(random.nextInt(100));
				buy(investor, company);
				counter++;
			}
		}
		Investor winner = listOfInvestor.get(0);
		for (Investor i : listOfInvestor) {
			if (i.getNumbOfShares() > winner.getNumbOfShares()) {
				winner = i;
			}
		}
		System.out.println(winner + " " + winner.getNumbOfShares());
		System.out.println(outOfBudget);
	}

	public void buy(Investor investor, Company company) {
		if (company.getNumOfShares() > 0) {
			if (investor.geBudgte() > company.getSharePrice()) {
				if (investor.geBudgte() * 0.25 > company.getSharePrice()) {
					trade(investor, company);
				}else {
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
		for(Company company : listOfCompany) {
			if(company.getSharePrice() < badPrice) {
					System.out.println(investor.getName() + " saved " + (badPrice - company.getSharePrice()));
					trade(investor, company);
					return;
			}
		}
	}

	private void trade(Investor investor, Company company) {

		double value = company.getSharePrice();
		System.out.println(investor.getName() + " bought " + value + " from " + company.getName());
		company.sell();
		investor.buy(value);
	}

	private boolean budgetChecker(Investor investor) {
		for (int i = 0; i < listOfCompany.size(); i++) {
			if (investor.geBudgte() > listOfCompany.get(i).getSharePrice()) {
				return true;
			}
		}
	    System.out.println(investor.getName() + " is out of money! " + outOfBudget);
		outOfBudget++;
		return false;
	}

}
