package model;

import java.util.ArrayList;
import java.util.Random;

import data.*;

public class TradeSimulation {
	private Generator generator = Generator.getInstance();
	private ArrayList<Investor> listOfInvestor;
	private ArrayList<Company> listOfCompany;
	private TradeObserver observer;
	private int outOfBudget = 0;
	Random random = new Random();

	public TradeSimulation(ArrayList<Investor> investors, ArrayList<Company> companies) {
		this.listOfInvestor = investors;
		this.listOfCompany = companies;
		observer = new TradeObserver(companies);
		start();
	}

	private void start() {
		int counter = 0;

		while (outOfBudget < 100) {
			Investor investor = listOfInvestor.get(random.nextInt(listOfInvestor.size()));
			Company company = listOfCompany.get(random.nextInt(listOfCompany.size()));
			buy(investor, company);
			counter++;
		}
		System.out.println(counter);
	}

	public boolean buy(Investor investor, Company company) {

		if (company.getNumOfShares() > 0) {
			if (investor.geBudgte() > company.getSharePrice()) {
				trade(investor, company);
				return true;
			} else {
				checkBudgetLimitations(investor);
				return false;
			}
		} else {
			System.out.println(company.getName() + " is out of businness");
			observer.removeObserver(company);
			return false;
		}
	}

	private void trade(Investor investor, Company company) {
		double value = company.getSharePrice();
		System.out.println(investor.getName() + " bought " + value + " from " + company.getName());
		company.shareSold();
		investor.setBudget(investor.geBudgte() - value);
		observer.update();
	}

	private boolean checkBudgetLimitations(Investor investor) {
		for (int i = 0; i < listOfCompany.size(); i++) {
			if (investor.geBudgte() > listOfCompany.get(i).getSharePrice()) {
				return true;
			}
		}
		System.out.println(investor.getName() +" is out of money!");
		outOfBudget++;
		return false;
	}

}
