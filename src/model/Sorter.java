package model;

import java.util.ArrayList;

import data.Investor;

public class Sorter {

	public static ArrayList<Investor> bestInvestor(ArrayList<Investor> investors) {
		ArrayList<Investor> best = new ArrayList<Investor>();
		best.add(investors.get(0));
		for (Investor i : investors) {
			if (i.getNumbOfShares() > best.get(0).getNumbOfShares()) {
				best.clear();
				best.add(i);
			} else if(i.getNumbOfShares() == best.get(0).getNumbOfShares()) {
				best.add(i);
			}
		}
		return best;
	}
	
	
	
	
	
   
}
