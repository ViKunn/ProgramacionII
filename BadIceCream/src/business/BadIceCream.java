package business;

import presentation.GameState;
import presentation.MenuState;
import presentation.Window;

public class BadIceCream {

	private final Window window;

	private MenuState menu;

	private static int gameUnitsX = 25;
	private static int unitSizeX  = 30;

	private static int gameUnitsY = 20;
	private static int unitSizeY  = 25;

	public BadIceCream() {

		this.menu = new MenuState();
		window = new Window(gameUnitsX * unitSizeX, gameUnitsY * unitSizeY);

	}

	public void start(){
		menu.start();
	}


	public static int getGameUnitsX() {
		return gameUnitsX;
	}
	public static int getGameUnitsY() {
		return gameUnitsY;
	}

	public static int getUnitSizeX() {
		return unitSizeX;
	}
	public static int getUnitSizeY() {
		return unitSizeY;
	}

}