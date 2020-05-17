package data;

import model.TradeObserver;
import model.TradeSimulation;

public class Company {

	private String name;
	private String id;
	private double sharePrice;
	private double capital;
	private int numOfShares;
	private int sharesSold;
	// Each Company is hocked up with the same observer

	private TradeObserver observer = TradeObserver.getInstance();

	private Company(CompanyBuilder companyBuilder) {
		this.id = companyBuilder.id;
		this.name = companyBuilder.name;
		this.sharePrice = companyBuilder.sharePrice;
		this.numOfShares = companyBuilder.numOfShares;
		this.sharesSold = -1;
		this.capital = numOfShares;
		// Once a company is created, it will add itself to the observer list
		observer.addCompany(this);
	}

	// -------------------------GETTERS------------
	// Nothing new
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public double getSharePrice() {
		return sharePrice;
	}

	public int getNumOfShares() {
		return numOfShares;
	}

	public int getSharesSold() {
		return sharesSold;
	}
	// -------------------------GETTERS------------

	/**
	 * The value of the variable capital is the equivalent of the initial number of
	 * shares of the company
	 * 
	 * @return The initial numbers of shares times the price
	 */
	public double getCapital() {
		return capital * sharePrice;
	}

	// This method will be called only if the trade met all the conditions created
	// as part of the simulation
	public void sell() {
		// The company MUST notifty the observer if any share is sold
		// The reason for that is the obeserver must be aware of how many shares are
		// sold among all companies
		observer.update();
		this.numOfShares--; // Reduce the number of shares available
		this.sharesSold++; // Increment the number of shares sold
		// If 10 shares are sold, the price will be doubled up
		if (sharesSold == 10) {
			sharePrice = sharePrice * 2; // Set the new share price
			System.out.println(name + " doubled price!"); // Print a message
			sharesSold = 0; // Reset the counter
		}
		// If the company has 0 shares available, it must be removed from the observer
		// list
		if (numOfShares == 0) {
			observer.removeCompany(this);
		}
	}

	// This method is called from the observer if this company hasn't sold any chare
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	// Returns a formated message
	@Override
	public String toString() {
		return "| Company: " + getName() + " ID: " + getId() + " " + numOfShares + " of shares at " + sharePrice
				+ " USD";
	}

	// Company Builder was implemented to facilate the creation of 100 fake
	// companies
	public static class CompanyBuilder {
		private String name;
		private String id;
		private double sharePrice;
		private int numOfShares;

		public CompanyBuilder(String id) {
			this.id = id;
		}

		public CompanyBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public CompanyBuilder setId(String id) {
			this.id = id;
			return this;
		}

		public CompanyBuilder setSharePrice(double sharePrice) {
			this.sharePrice = sharePrice;
			return this;
		}

		public CompanyBuilder setNumOfShares(int numOfShares) {
			this.numOfShares = numOfShares;
			return this;
		}

		public Company build() {
			return new Company(this);
		}

	}

}
