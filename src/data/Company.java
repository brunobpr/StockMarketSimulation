package data;

public class Company {
	private String name;
	private String id; 
	private double sharePrice;
	private int numOfShares;
	
	private Company(CompanyBuilder companyBuilder){
		this.id = companyBuilder.id;
		this.name = companyBuilder.name;
		this.sharePrice = companyBuilder.sharePrice;
		this.numOfShares = companyBuilder.numOfShares;
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

	@Override
 	public String toString() {
 		return "| Company: " + getName() + " ID: " + getId() + " " + numOfShares +" of shares at " + sharePrice + " USD";
 	}
	
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
