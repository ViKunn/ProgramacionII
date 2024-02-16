package presentation;

public class MenuState implements Runnable{

	private GameState game;

	private int option;
	private boolean running;

	public MenuState() {

		game = new GameState();
		running = true;

	}

	public void start(){
		run();
	}

	@Override
	public void run() {

		// TODO cambiar inicialización option
		option = 1;

		do {

			System.out.println("Corriendo menu");

			switch (option){

				case 1:     game.start();     break;

				case 5:     running = false;
			}

			System.out.println("Ingresado a la opcion 1");

		} while (true);

	}
}