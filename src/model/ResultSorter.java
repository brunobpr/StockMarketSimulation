package model;

import java.util.ArrayList;

import data.Company;
import data.Investor;

public class ResultSorter {

	// All the method on this class has the only porpuse of sorting the lists
	// according to what the users wants
	// The methos receives an unsorted list and sends back a sorted one, without
	// changing the real list

	// Investor with the highest number of shares
	// If there is more than one investor in any of the positions, they all should
	// be displayed in the result.
	/**
	 * @param investors
	 *            the list unsorted investors, it won't be modified
	 * @return the sorted list of investors with the ---- HIGHEST NUMBER OF SHARES
	 */
	public static ArrayList<Investor> bestInvestor(ArrayList<Investor> investors) {
		ArrayList<Investor> best = new ArrayList<Investor>();
		best.add(investors.get(99));
		for (Investor i : investors) {
			if (i.getNumbOfShares() > best.get(0).getNumbOfShares()) {
				// If the investor has more number of shares than the ones from the list
				// Clean the list and add the investor
				best.clear();
				best.add(i);
			} else if (i.getNumbOfShares() == best.get(0).getNumbOfShares()) {
				// If the investor has the same number of shares than the ones from the list
				// Add the investor to the list, without changing the list
				best.add(i);
			}
		}
		return best;
	}

	// Investor with the lowest number of shares
	// If there is more than one investor in any of the positions, they all should
	// be displayed in the result.
	/**
	 * @param investors
	 *            the list unsorted investors, it won't be modified
	 * @return the sorted list of investors with the ---- LOWEST NUMBER OF SHARES
	 */
	public static ArrayList<Investor> worstInvestor(ArrayList<Investor> investors) {
		ArrayList<Investor> best = new ArrayList<Investor>();
		best.add(investors.get(99));
		for (Investor i : investors) {
			if (i.getNumbOfShares() < best.get(0).getNumbOfShares()) {
				// If the investor has less number of shares than the ones from the list
				// Clean the list and add the investor
				best.clear();
				best.add(i);
			} else if (i.getNumbOfShares() == best.get(0).getNumbOfShares()) {
				// If the investor has the same number of shares as the ones from the list
				// Add the investor to the list, without changing the list
				best.add(i);
			}
		}
		return best;
	}

	// Company with the lowest capital (number of shares times latest share price)
	// If there are more than one company at the top or bottom position, they all
	// should be displayed in the result.
	/**
	 * @param companies
	 *            unsorted list of companies, it wont be modified
	 * @return the sorted list of companies with the ---- LOWEST CAPITAL ------
	 */
	public static ArrayList<Company> worstCompanies(ArrayList<Company> companies) {
		ArrayList<Company> worst = new ArrayList<Company>();
		worst.add(companies.get(99));
		for (Company c : companies) {
			if (c.getCapital() < worst.get(0).getCapital()) {
				// If the company has less capital than the ones from the list
				// Clean the list and add the company
				worst.clear();
				worst.add(c);
			} else if (c.getCapital() == worst.get(0).getCapital()) {
				// If the company has the same amount of capital than as ones from the list
				// Add the company to the list, without changing the list
				worst.add(c);
			}
		}
		return worst;
	}

	// Company with the highest capital (number of shares times latest share price)
	// If there are more than one company at the top or bottom position, they all
	// should be displayed in the result.
	/**
	 * @param companies
	 *            unsorted list of companies, it wont be modified
	 * @return the sorted list of companies with the ---- HIGHEST CAPITAL ------
	 */
	public static ArrayList<Company> bestCompanies(ArrayList<Company> companies) {
		ArrayList<Company> best = new ArrayList<Company>();
		best.add(companies.get(99));
		for (Company c : companies) {
			if (c.getCapital() > best.get(0).getCapital()) {
				// If the company has more capital than the ones from the list
				// Clean the list and add the company
				best.clear();
				best.add(c);
			} else if (c.getCapital() == best.get(0).getCapital()) {
				// If the company has the same amount of capital than as ones from the list
				// Add the company to the list, without changing the list
				best.add(c);
			}
		}
		return best;
	}

}
