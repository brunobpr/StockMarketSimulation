package model;

import data.Company;

public interface Observer {

	void addCompany(Company company);

	void removeCompany(Company company);

	void update();

	void notifyCompanies();

}