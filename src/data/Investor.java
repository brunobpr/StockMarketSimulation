package data;

import java.util.ArrayList;

public class Investor {
	private String name;
	private String id;
	private double budget;
	private int numbOfShares;

	private Investor(InvestorBuilder investorBuilder) {
		this.name = investorBuilder.name;
		this.id = investorBuilder.id;
		this.budget = investorBuilder.budget;
		this.numbOfShares = 0;
	}

	//-------------------------GETTERS------------
	//Nothing new
	public String getName() {
		return this.name;
	}

	public String getId() {
		return this.id;
	}

	public double geBudgte() {
		return this.budget;
	}

	public int getNumbOfShares() {
		return numbOfShares;
	}
	//-------------------------GETTERS------------
	
	/**
	 * This method will be called only if the trade met all the conditions created
	 * as part of the simulation
	 * @param price
	 *            The price of the share the investor is buying
	 */
	public void buy(double price) {
		this.budget = budget - price;
		this.numbOfShares++;
	}

	// This method will generate a well formatted print statement with information
	// regarding the investor
	@Override
	public String toString() {
		return "| Investor: " + getName() + " ID: " + getId() + " Budget: " + budget;
	}

	// Investor Builder was implemented to facilate the creation of 100 fake
	// investors
	public static class InvestorBuilder {
		private String name;
		private String id;
		private double budget;

		public InvestorBuilder(String id) {
			this.id = id;
		}

		public InvestorBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public InvestorBuilder setId(String id) {
			this.id = id;
			return this;
		}

		public InvestorBuilder setBudget(double budget) {
			this.budget = budget;
			return this;
		}

		public Investor build() {
			return new Investor(this);
		}

	}

}
