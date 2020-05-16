package data;

import model.TradeSimulation;

public class Company {
	private TradeSimulation simulation;
	private String name;
	private String id;
	private double sharePrice;
	private int numOfShares;
	private int sharesSold;

	

	private Company(CompanyBuilder companyBuilder) {
		this.id = companyBuilder.id;
		this.name = companyBuilder.name;
		this.sharePrice = companyBuilder.sharePrice;
		this.numOfShares = companyBuilder.numOfShares;
		this.sharesSold = -1;
	}

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
	
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public void shareSold() {
		this.numOfShares--;
		this.sharesSold++;
		if (sharesSold < 10) {
			sharePrice = sharePrice * 2;
			System.out.println(name + " doubled price!");
			sharesSold = 0;
		}
	}

	@Override
	public String toString() {
		return "| Company: " + getName() + " ID: " + getId() + " " + numOfShares + " of shares at " + sharePrice
				+ " USD";
	}

	public static class CompanyBuilder{
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
