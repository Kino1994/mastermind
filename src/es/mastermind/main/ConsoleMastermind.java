package es.mastermind.main;

import es.mastermind.models.Game;
import es.mastermind.views.ConsoleView;
import es.mastermind.views.View;

public class ConsoleMastermind extends Mastermind {

	public static void main(String[] args) {
		new ConsoleMastermind().play();
	}	
	
	@Override
	protected View createView(Game game) {
		return new ConsoleView(game);
	}

}
