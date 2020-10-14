package es.mastermind.main;

import es.mastermind.models.Game;
import es.mastermind.views.ConsoleView;
import es.mastermind.views.View;

public class Mastermind {

	private Game game;
	
	private ConsoleView view;

	private Mastermind() {
		this.game = new Game();
		this.view = new ConsoleView(this.game);
	}

	private void play() {
		this.view.interact();
	}
	
	public static void main(String[] args) {
		new Mastermind().play();
	}	

}
