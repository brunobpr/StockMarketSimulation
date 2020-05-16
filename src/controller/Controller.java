package controller;

import model.Generator;


public class Controller {

	private Generator generator = Generator.getInstance();
	
	public Controller() {
		generator.investors();
		
	}
	
}
