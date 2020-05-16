package controller;

import java.util.ArrayList;
import java.util.Random;

import data.Company;
import data.Investor;
import model.Generator;
import model.TradeSimulation;


public class Controller {

	private Generator generator = Generator.getInstance();

	
	public Controller() {
		new TradeSimulation(generator.investors(),  generator.companies());
	}
	
	
}
