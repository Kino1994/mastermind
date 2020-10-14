package es.mastermind.views;

import es.mastermind.utils.WithConsoleView;

class StartView extends WithConsoleView {

	void interact() {
		MessageView.TITLE.writeln();
		new SecretCombinationView().writeln();
	}

}
