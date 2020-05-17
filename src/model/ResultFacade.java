package model;

import java.util.ArrayList;

import data.Company;
import data.Investor;
import view.Printer;

public class ResultFacade {

	// The use of the Facade in this project helped to implement the options of
	// results display through the Menu, the facade allowed an easy interaction
	// between the user input and the different options of results

	public static enum Trader {
		COMPANY, INVESTOR;
	}

	public static enum Performance {
		BEST, WORST;
	}

	public static void getResult(Trader trader, Performance performance, TradeSimulation tradeSimulation) {

		// All the methos of the class ResultSorter returns ArrayList of Investors/Companies
		// with High/Low performance
		// The ArrayList is sent to the Printer according to the type of object and
		// performance
		// All the method of the Printer class receives a ArrayList and a string message
		switch (trader) {
		case COMPANY:
			//get the list of companies that participated on the trading day
			ArrayList<Company> companies = tradeSimulation.getCompanies();
			switch (performance) {
			case BEST:
				// Print the BEST COMPANIES
				Printer.companies(ResultSorter.bestCompanies(companies), "best");
				break;
			case WORST:
				// Print the WORST COMPANIES
				Printer.companies(ResultSorter.worstCompanies(companies), "worst");
			}
			break;
		case INVESTOR:
			//get the list of investors that participated on the trading day
			ArrayList<Investor> investors = tradeSimulation.getInvestors(); 
			switch (performance) {
			case BEST:
				// Print the BEST INVESTORS
				Printer.investors(ResultSorter.bestInvestor(investors), "best");
				break;
			case WORST:
				// Print the WORST INVESTORS
				Printer.investors(ResultSorter.worstInvestor(investors), "worst");
				break;
			}
			break;
		}

	}

}
