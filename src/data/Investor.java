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
    
    public String getName() {
    	return this.name;
    }
    
    public String getId() {
    	return this.id;
    }
    
    public double geBudgte() {
    	return this.budget;
    }
    
    public void buy(double price) {
    	this.budget = budget - price;
    	this.numbOfShares++;
    }
    
    public int getNumbOfShares() {
		return numbOfShares;
	}
   
    
    // This method will generate a well formatted print statement with information
 	// regarding the investor
 	@Override
 	public String toString() {
 		return "| Investor: " + getName() + " ID: " + getId() + " Budget: " + budget;
 	}
    
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
