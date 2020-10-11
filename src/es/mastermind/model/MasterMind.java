package es.mastermind.model;

import java.io.IOException;
import java.util.List;

import es.mastermind.utils.Console;

public class MasterMind {
	
	private static final int MAX_ATTEMPS = 10;
	private MakerCodePlayer makerCodePlayer;
	private BreakerCodePlayer breakerCodePlayer;
	private int attempts;
	private Console console;
	
	public MasterMind() {
		this.makerCodePlayer = new MakerCodePlayer();
		this.makerCodePlayer.generateSecretCode();
		this.breakerCodePlayer = new BreakerCodePlayer();
		this.console = new Console();
	}
	
	public MasterMind clear() {
		this.attempts = 0;
		this.makerCodePlayer = new MakerCodePlayer();
		this.makerCodePlayer.generateSecretCode();
		this.breakerCodePlayer = new BreakerCodePlayer();
		this.console = new Console();
		return this;
	}
	
	public void play() throws IOException {
		console.showMainMenu();
		boolean matchCode = false;
		do {
			String input = console.readCode();
			if (!input.equals(Console.ERROR)) {
				console.putCode(input, breakerCodePlayer);
			}
			matchCode = this.makerCodePlayer.matchCode(breakerCodePlayer);
			attempts++;
			if (!matchCode) {
				List<Feedback> feedbacks = makerCodePlayer.getFeedBacks(breakerCodePlayer);
				console.showRetryMenu(feedbacks);
				if (attempts == MAX_ATTEMPS) {
					console.showLose();
					attempts = 0;
				}
			}
			else {
				console.showWin();
				console.showResumeMenu();
				matchCode = !console.isResume();
				if (!matchCode) {
					this.clear();
					console.showMainMenu();
				}
			}
		}
		while (!isfinish() && !matchCode);
	}
	
	public boolean isfinish() {
		return this.attempts == MAX_ATTEMPS ;
	}

}
