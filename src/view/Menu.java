package view;

public class Menu {

	public Menu() {
		showMenu();
	}

	
	//Show the menu options
	public void showMenu() {
		System.out.println("Please, choose one option!");
		System.out.println("[ 1 ] - Highest Company Capital");
		System.out.println("[ 2 ] - Lowest Company Capital");
		System.out.println("[ 3 ] - Best Investor of the Day");
		System.out.println("[ 4 ] - Worst Investor of the Day");
		System.out.println("[ 0 ] - Exit");
	}
	
	//Clean the screen a bit
	public void clean() {
		for(int i = 0; i <= 20; i++) {
			System.out.println(" ");
		}
	}
}
