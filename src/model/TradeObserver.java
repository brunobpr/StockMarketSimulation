package model;

import java.util.ArrayList;

import data.Company;
import data.Investor;

public class TradeObserver {
	private ArrayList<Company> companies;
	private int numbOfSharesSold = 0;
	
	public TradeObserver(ArrayList<Company> companies) {
		this.companies = companies;
	}
	
	public void addObserver(Company company) {
		companies.add(company);
	}
	
	public void removeObserver(Company company) {
		companies.remove(company);
	}
	
	public void update() {
		numbOfSharesSold++;
		notifyCompanies();
	}
	
	public void notifyCompanies() {
		if(numbOfSharesSold < 10) {
			return;
		}
		for(Company company : companies) {
			if(company.getSharesSold() == -1) {
				company.setSharePrice( company.getSharePrice() - (company.getSharePrice() * 0.02));
				System.out.println(company.getName() + " lost value!");
			}
		}
		numbOfSharesSold = 0;
	}
}
