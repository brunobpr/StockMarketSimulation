package model;

import java.util.ArrayList;

import data.Company;
import data.Investor;

public class TradeObserver implements Observer  {
	private ArrayList<Company> companies;
	private int numbOfSharesSold = 0;
	
	public TradeObserver(ArrayList<Company> companies) {
		this.companies = companies;
	}
	
	
	@Override
	public void addCompany(Company company) {
		companies.add(company);
	}
	
	@Override
	public void removeCompany(Company company) {
		companies.remove(company);
	}
	
	@Override
	public void update() {
		numbOfSharesSold++;
		notifyCompanies();
	}
	
	@Override
	public void notifyCompanies() {
		if(numbOfSharesSold == 10) {
			return;
		}
		for(Company company : companies) {
			if(company.getSharesSold() < 0) {
				company.setSharePrice( company.getSharePrice() - (company.getSharePrice() * 0.02));
				System.out.println(company.getName() + " lost value!");
			}
		}
		numbOfSharesSold = 0;
	}
}
