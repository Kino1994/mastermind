package es.mastermind.model;

import java.util.ArrayList;
import java.util.List;

public class SecretCode extends Code {
	
	public SecretCode(List<Position> positions) {
		super(positions);
	}
	
	public boolean matchCode(TryCode trycode) {
		
		List<Position> positions = trycode.getPositions();
		
		boolean match = true;
		int index = 0;
		
		List<Position> codePositions = super.getPositions();		
		do {
			match = positions.get(index).match(codePositions.get(index));
			index ++;			
		}
		while (index < codePositions.size() && match);
		
		return match;
	}
	
	public List<Feedback> getFeedbacks(TryCode tryCode) {
		List<Feedback> feedBacks = new ArrayList<>();
		
		List<Position> positionsSecretCode = super.getPositions();
		
		List<Position> positionsTryCode = tryCode.getPositions();
		
		for (int i = 0; i<positionsTryCode.size(); i++) {
			feedBacks.add(positionsSecretCode.get(i).getFeedBack(positionsTryCode.get(i)));				
		}
		
		return feedBacks;
	}

}
