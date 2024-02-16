package presentation;

import business.gameObjects.characters.players.Player;
import business.levels.Level;

import javax.swing.*;
import java.awt.*;

public class GameState extends JPanel implements Runnable {

	private Player player;
	private Level[] levels;

	// TODO change
	int runningLevel = 1;

	private boolean running = true;

	public GameState(){

		player = new Player();
		levels = new Level[5];

	}

	public void start(){
		run();
	}

	@Override
	public void run() {

		int count = 0;

		while (count < 5){
			update(1);
			repaint();
			System.out.println("Corriendo juego");
			count ++;
		}

	}

	public void update(int runningLevel){
		// level.update();
		// player.update();
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// levels[runningLevel].draw(g2);
		// player.draw(g2);

		g2.dispose(); // To save memory
	}


}