package model;

import controller.Controller;

/*
 * @Author Bruno Pereira Ribeiro  - 2017138
 * Github link: https://github.com/brunobpr/StockMarketSimulation
*/

// If a company sells 10 shares, the share price should double up. Company.java line 73
// If any 10 shares are sold (from any company), and a company hasn’t sold any, the price must reduce in 2%. TradeObserver.java line 76
// Investors can do as many transactions as they like, but must buy only one share per transaction. TradeSimulation.java line 83
// Investors must try to buy shares in as many companies as possible to guarantee the safety of their investment. TradeSimulation.java line 101
// The simulator should stop when all shares have been sold, or all investors have spent all their money. TradeSimulation.java line 35

// At least three design patterns must be implemented in your project, and at least two of them must be structural or behavioural patterns.
// 1. Builder = Company & Investor
// 2. Facade = Menu Interaction -> Company/Investor with High/Low performances
// 3. Observer = TradeObserver watching the sales from all the companies
// 4. Singleton = The company using the same observer

public class Main {
	public static void main(String[] args) {
		new Controller();
	}

}
