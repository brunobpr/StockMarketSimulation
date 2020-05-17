package model;

import java.util.ArrayList;

import data.Company;
import data.Investor;

public enum TradeObserver implements Observer  {
	
	//The implemantion of this Observer is differently from the one I've seen
	//I did that because all the companies are created dynamicaly 
	//So there was no way to add the companies with add(company1), add(company2), add(company3) and so on...
	//The solution I found was to create a singleton observer that is going to be used by all 100 comapanies.
	//When a new company is created it gets the instance of the observer and adds itself to the list of companies being watched
	instance;
	
	//ArrayList of companies being watched
	private ArrayList<Company> companies;
	//The numbOfShareSold is the attribute the observer is paying attention
	private int numbOfSharesSold = 0;
	
	private TradeObserver() {
		companies = new ArrayList<Company>();
	}
	
	
	/* This method is used by the company class to add any new company created
	 * @see model.Observer#addCompany(data.Company)
	 */
	@Override
	public void addCompany(Company company) {
		companies.add(company);
	}
	
	/* This method is used by the company class to remove any compony that sold all the shares
	 * @see model.Observer#removeCompany(data.Company)
	 */
	@Override
	public void removeCompany(Company company) {
		companies.remove(company);
	}
	
	/* This method is called from the Company class for every share sold
	 * @see model.Observer#update()
	 */
	@Override
	public void update() {
		numbOfSharesSold++;
		notifyCompanies();
	}
	
	
	/* This method iterates through all the companies of the list to see if the companies have sold any share
	 * @see model.Observer#notifyCompanies()
	 */
	@Override
	public void notifyCompanies() {
		System.out.println("Shares sold ----------------------------" + numbOfSharesSold);
		if(numbOfSharesSold < 10) {
			return;
		}
		for(Company company : companies) {
			if(company.getSharesSold() == 03) {
				company.setSharePrice( company.getSharePrice() - (company.getSharePrice() * 0.02));
				System.out.println(company.getName() + " lost 2pc of value because hasn't sold any share!" );
			}
		}
		numbOfSharesSold = 0;
	}
	
	public static TradeObserver getInstance() {
		return instance;
	}
	
}
