package es.mastermind.app;

import java.io.IOException;

import es.mastermind.model.MasterMind;

public class Main {

	public static void main(String[] args) throws IOException {
		
		MasterMind masterMind = new MasterMind();
		masterMind.play();		
	}

}
