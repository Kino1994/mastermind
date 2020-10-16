package es.mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class BreakerCodePlayer {
	
	private TryCode tryCode;

	public void putCode(List<Color> colors) {
		List<Position> positions = new ArrayList<Position>(Position.NUMBER_POSITIONS);
		
		for (int i = 0; i< Position.NUMBER_POSITIONS; i++) {
			positions.add(new Position(colors.get(i)));
		}
		this.tryCode =  new TryCode(positions);
	}

	public TryCode getTryCode() {
		return tryCode;
	}

}
