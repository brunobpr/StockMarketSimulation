package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import data.*;

public class TradeSimulation {
	private ArrayList<Investor> listOfInvestor;
	private ArrayList<Company> listOfCompany;
	int counter = 0; // How many trades were made
	private int outOfBudget = 0; // How many investors without enough money
	private int outOfBusiness = 0; // How many companies without any share
	// Random number
	Random random = new Random();

	public TradeSimulation() {
	}

	/**
	 * This method is called from the controller
	 * 
	 * @param investors
	 *            list of 100 fake investors
	 * @param companies
	 *            list of 100 fake companies
	 * @return the number of trades executed during the day
	 */
	public int start(ArrayList<Investor> investors, ArrayList<Company> companies) {
		this.listOfInvestor = investors;
		this.listOfCompany = companies;
		// Keep trading until has investors with money and companies with shares to sell
		while (outOfBudget <= 100 && outOfBusiness <= 100) {
			// Pick a random investor and company
			Investor investor = listOfInvestor.get(random.nextInt(100));
			Company company = listOfCompany.get(random.nextInt(100));
			// Send them to the negotiation table
			negotiate(investor, company);
		}
		return counter;
	}

	/**
	 * @param investor
	 *            the investors trying to buy the share
	 * @param company
	 *            the company that may own the share
	 */
	public void negotiate(Investor investor, Company company) {
		// Companies are not allowed to sell imaginary shares - no scammers here
		if (company.getNumOfShares() > 0) {
			// Investors can only buy share if they have enough money
			if (investor.geBudgte() > company.getSharePrice()) {
				// But for sake of a good investment, only 15pc of the budget can be used
				if (investor.geBudgte() * 0.15 > company.getSharePrice()) {
					// If the green light is given, let them trade
					trade(investor, company);
				} else {
					// If the investor can't speend more than 15pc of the budget
					// Show them a company with more affordable share price,
					saveInvestment(investor, company.getSharePrice());
				}
			} else {
				// If the Investors don't have enough money to buy a share
				// Can they still trade?
				budgetChecker(investor);
			}
		} else {
			// If the Company doesn't have shares to sell, shut the doors.
			System.out.println(company.getName() + " sold all the shares!");
			outOfBusiness++;
		}
	}

	/**
	 * @param investor
	 *            The investor who is ready to buy the share
	 * @param company
	 *            The company ready to sell the share
	 */
	private void trade(Investor investor, Company company) {
		// How much it will costs?
		double value = company.getSharePrice();
		System.out.println(investor.getName() + " bought " + value + " from " + company.getName() + " and now has "
				+ investor.geBudgte() + "USD available!");
		// Sign the contract and let the authorities know (update the observer)
		company.sell();
		// Sign the contract and pay for the share
		investor.buy(value);
		counter++;
	}

	/**
	 * @param investor
	 *            The investor trying to save some money.
	 * @param badPrice
	 *            The price of the share he/she can't buy
	 */
	private void saveInvestment(Investor investor, double badPrice) {
		// Find a new company
		Company company = listOfCompany.get(random.nextInt(100));
		while (company.getSharePrice() > badPrice) {
			// Look for companies until find a better price
			company = listOfCompany.get(random.nextInt(100));
		}
		System.out.println(
				investor.getName() + " made a best investment saving " + (badPrice - company.getSharePrice()) + " USD");
		// I saved you some money, go ahead and but the share
		trade(investor, company);
		return;
	}
	
	/**
	 * @param investor
	 *            The investor who needs to be investisgated by the CAA (Could't Afford Association)
	 * @return if the investors is still in the game
	 */
	private boolean budgetChecker(Investor investor) {
		for (int i = 0; i < listOfCompany.size(); i++) {
			// Go through the the list of companies and check if the investor still has
			// money
			if (investor.geBudgte() > listOfCompany.get(i).getSharePrice()) {
				// If finds a company with affordable share price, let the investor in the game
				return true;
			}
		}
		// If the investors cant afford any company's share, say bye to him/her
		System.out.println(investor.getName() + " is out of money with " + investor.getNumbOfShares() + " shares!");
		// Increment the counter of losers
		outOfBudget++;
		return false;
	}

	/**
	 * @return the list of investors who participate of the trading day
	 */
	public ArrayList<Investor> getInvestors() {
		return listOfInvestor;
	}

	/**
	 * @return the list of companies that participated of the trading day
	 */
	public ArrayList<Company> getCompanies() {
		return listOfCompany;
	}

}
