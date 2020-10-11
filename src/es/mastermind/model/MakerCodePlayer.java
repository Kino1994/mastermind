package es.mastermind.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakerCodePlayer {
	
	private SecretCode secretCode;

	public void generateSecretCode() {
		List<Position> positions = new ArrayList<Position>(Position.NUMBER_POSITIONS);
		Color [] colors = Color.values(); 
		
		Random random = new Random(System.currentTimeMillis());
		
		for (int i = 0; i< Position.NUMBER_POSITIONS; i++) {
			positions.add(new Position(colors[random.nextInt(colors.length)]));
		}
		this.secretCode =  new SecretCode(positions);
	}		
	
	public SecretCode getSecretCode() {
		return this.secretCode;
	}

	public List<Feedback> getFeedBacks(BreakerCodePlayer breakerCodePlayer) {
		
		TryCode trycode = breakerCodePlayer.getTryCode();
		
		return this.secretCode.getFeedbacks(trycode);
	}
	
	public boolean matchCode(BreakerCodePlayer breakerCodePlayer) {
		
		TryCode tryCode = breakerCodePlayer.getTryCode();				
		return this.secretCode.matchCode(tryCode);
	}
	
	

}
