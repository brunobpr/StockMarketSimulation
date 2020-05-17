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
	private Generator generator = Generator.getInstance();
	private Menu menu = new Menu();
	private TradeSimulation tradeSimulation;
	
	
	public Controller() {
		tradeSimulation = new TradeSimulation();
		reader = new BufferedReader(new InputStreamReader(System.in));
		int numbOfTrades = tradeSimulation.start(generator.investors(),  generator.companies());
		menu.clean();
		System.out.println("Simulation completed, " + numbOfTrades + " trades were executed!");
		getMenuOption();
	}
	
	private void getMenuOption() {
		menu.showMenu();
		String optionSelected = getInput();;
		switch(optionSelected) {
			case "1":
						
			case "2":
				
			case "3":
				ResultFacade.getResult(ResultFacade.Trader.INVESTOR, ResultFacade.Performance.BEST, tradeSimulation);
				getMenuOption();	
			case "4":
			
			case "0":
			
				System.exit(0);;
			default:
				System.out.println("Option not available! 0-5");
				getMenuOption();
		};
			
	}
	
	
	
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
