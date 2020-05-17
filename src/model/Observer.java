package model;

import data.Company;

public interface Observer {

	/**
	 * @param the
	 *            company to be added to the list
	 */
	public void addCompany(Company company);

	/**
	 * @param the
	 *            company to be removed from the list
	 */
	public void removeCompany(Company company);

	/**
	 * The method called by the companies if there is any change
	 */
	public void update();

	/**
	 * The method resposible to notify all the companies of any change
	 */
	public void notifyCompanies();

}