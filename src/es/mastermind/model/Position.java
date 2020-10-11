package es.mastermind.model;

public class Position {
	
	public static final int NUMBER_POSITIONS = 4;

	private Color color;

	public Position(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public Feedback getFeedBack (Position position ) {
		if (this.color.equals(position.getColor())) {
			return Feedback.SUCCESS;
		}
		return Feedback.FAILURE;
	}
	
	
	public boolean match (Position position) {
		return this.color.equals(position.getColor());
	}
}
