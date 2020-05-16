package model;

import java.util.ArrayList;

import data.FakeData;
import data.Investor;

public class Generator {
	
	
		//This is the Lazy Singleton class intended to generate a list of investors and companies
		private static Generator instance = null;
		FakeData fakeData = new FakeData();
		// Constructor
		private Generator() {
		}

		public ArrayList investors() {
			ArrayList<Investor> listOfInvestor = new ArrayList<Investor>();
			System.out.println("Generating fake investors...");
			for (int i = 0; i < 100; i++) {
				Investor.InvestorBuilder builder = new Investor.InvestorBuilder(fakeData.uniqueID());
				builder.setName(fakeData.firstName() + " " + fakeData.lastName());
				builder.setBudget(fakeData.budget());
				listOfInvestor.add(builder.build());
				System.out.println(builder.build());
			}
			return listOfInvestor;
		}




		public static Generator getInstance() {
			if (instance == null) {
				instance = new Generator();
			}
			return instance;
		}

	}