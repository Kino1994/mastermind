package es.mastermind.views;

import es.mastermind.models.Result;
import es.mastermind.utils.WithConsoleView;

class ResultView extends WithConsoleView {
	
	private Result result;

	ResultView(Result result) {
		this.result = result;
	}

	void writeln() {
		MessageView.RESULT.writeln(this.result.getBlacks(), this.result.getWhites());
	}

}
