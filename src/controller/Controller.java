package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Generator;
import model.ResultFacade;
import model.TradeSimulation;
import view.Menu;

public class Controller {
	private BufferedReader reader;
	// Generator is a Singletonton class responsible for generating fake investors
	// and companies
	private Generator generator = Generator.getInstance();
	// Menu is a View class only for print statemants
	private Menu menu = new Menu();
	// TradeSimulations is where the magic happens
	private TradeSimulation tradeSimulation;

	public Controller() {
		tradeSimulation = new TradeSimulation(); // Intantianting a new simulation
		reader = new BufferedReader(new InputStreamReader(System.in)); // Intantianting a new BufferedReader
		// The start() method receives the fake investors and companies as parameters
		// and sends back how many trades were made
		int numbOfTrades = tradeSimulation.start(generator.investors(), generator.companies());
		menu.clean(); // Print a few empity lines
		System.out.println("Simulation completed, " + numbOfTrades + " trades were executed!"); // Just a message with
																								// the number of trades
		getMenuOption();// Show Menu and ask for input
	}

	/**
	 * THis method displays the menu and ask for an input It uses a switch and
	 * facade pattern to generate the results asked by the user
	 */
	private void getMenuOption() {
		menu.showMenu();
		String optionSelected = getInput();
		;
		switch (optionSelected) {
		case "1":
			// THE BEST COMPANY OF THE DAY
			ResultFacade.getResult(ResultFacade.Trader.COMPANY, ResultFacade.Performance.BEST, tradeSimulation);
			getMenuOption();
		case "2":
			// THE WORST COMPANY OF THE DAY
			ResultFacade.getResult(ResultFacade.Trader.COMPANY, ResultFacade.Performance.WORST, tradeSimulation);
			getMenuOption();
		case "3":
			// THE BEST INVESTOR OF THE DAY
			ResultFacade.getResult(ResultFacade.Trader.INVESTOR, ResultFacade.Performance.BEST, tradeSimulation);
			getMenuOption();
		case "4":
			// THE WORST INVESTOR OF THE DAY
			ResultFacade.getResult(ResultFacade.Trader.INVESTOR, ResultFacade.Performance.WORST, tradeSimulation);
			getMenuOption();
		case "0":
			// EXIT THE SYSTEM
			System.exit(0);
			;
		default:
			// INPUT NOT VALID
			menu.clean();
			System.out.println("Option not available! 0-4");
			getMenuOption();

		}
		;

	}

	/**
	 * @return The input from the user
	 */
	private String getInput() {
		String input;
		try {
			input = reader.readLine();
			return input;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Try again: ");
			return getInput();
		}

	}

}
