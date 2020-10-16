package es.mastermind.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import es.mastermind.model.BreakerCodePlayer;
import es.mastermind.model.Color;
import es.mastermind.model.Feedback;
import es.mastermind.model.Position;

public class Console {
	
	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	private static final char AFFIRMATIVE_ANSWER = 'Y';
	private static final String INTRO_MENU = "Welcome to MasterMind. Please, put your trycode following to the format:\n";
	private static final String FORMATO_MENU = "RED = 0, BLUE = 1, PURPLE = 2, YELLOW = 3, GREEN = 4, ORANGE = 5\n";
	private static final String EXAMPLE_MENU = "Example: 1532\n";
	private static final String RESUME_MENU = "Insert Y or N to repeat the game or leave\n";	
	private static final String RETRY_MENU = "Please, put again your trycode following to the format:\n";
	private static final String WIN = "You win!\n";
	private static final String LOSE = "You lose!\n";
	private static final String EXIT_MENU = "Goodbye!\n";
	public static final String FAIL = "You fail the following codes:\n";
	public static final String ERROR = "ERROR, invalid code";
	
	public void putCode(String input, BreakerCodePlayer breakerCodePlayer) {
		List<Color> colors = new ArrayList<>();
		String [] inputParts = input.split("");
		for (int i = 0; i < Position.NUMBER_POSITIONS; i++) {
			Integer index = Integer.parseInt(inputParts[i]);
			colors.add(Color.values()[index]);
		}
		breakerCodePlayer.putCode(colors);
	}
	
	public boolean isResume() throws IOException {
		String input = readLine();
		return (input.length() == 1 && input.toUpperCase().charAt(0) == AFFIRMATIVE_ANSWER);
	}
	
	public void showMainMenu () {
		System.out.println(INTRO_MENU + FORMATO_MENU + EXAMPLE_MENU);
	}
	
	public void showResumeMenu () {
		System.out.println(RESUME_MENU);
	}
	
	public void showRetryMenu (List<Feedback> feedback) {
		System.out.println(FAIL +  printMenuFeedbacks(feedback) + RETRY_MENU + FORMATO_MENU + EXAMPLE_MENU);
	}
		
	public void showWin() {
		System.out.println(WIN);
	}
	
	public void showLose() {
		System.out.println(LOSE);
	}
	
	public void showExit() {
		System.out.println(EXIT_MENU);
	}
	
	private String printMenuFeedbacks (List<Feedback> feedback) {
		String output = "";
		for (int i = 0; i<feedback.size(); i++) {
			if (feedback.get(i).equals(Feedback.FAILURE)) {
				output += (i+1) + "º,";
			}
		}
		if (output.length()>0) {
			return output.substring(0,output.length());
		}
		else return output;
	}
	
	private String readLine() throws IOException {
		return this.bufferedReader.readLine();
	}
		
	public String readCode() throws IOException{
		String code = readLine();
		if (isInputValid(code)) {
			return code;
		}
		return ERROR;
	}
	
	public boolean isInputValid(String input) {

		boolean match = true;
		int index = 0;
		
		String [] inputParts = input.split("");		
		while (index < inputParts.length || !match) {
			match = Integer.valueOf(inputParts[index]) < Color.values().length; 
			index ++;			
		}
		
		return match;
	}	

}
