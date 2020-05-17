package model;

import java.util.ArrayList;

import data.Company;
import data.Investor;
import view.Printer;

public class ResultFacade {

	public static enum Trader{
		COMPANY, INVESTOR;
	}
	public static enum Performance{
		BEST, WORST;
	}
	
		
		public static void getResult(Trader trader, Performance performance, TradeSimulation tradeSimulation) {
		
		
		switch(trader) {
			case COMPANY:
				ArrayList<Company> companies = tradeSimulation.getCompanies();
				switch(performance) {
					case BEST:
						
						break;
					case WORST:
						
				}
				break;
			case INVESTOR:
				ArrayList<Investor> investors = tradeSimulation.getInvestors();
				switch(performance) {
				case BEST:
					Printer.investors(Sorter.bestInvestor(investors), "best");
					break;
				case WORST:	
					
					break;
			}
			break;
		}
		
	}
	
	
}
