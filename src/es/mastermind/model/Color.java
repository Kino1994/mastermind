package es.mastermind.model;

public enum Color {
	
	RED("RED"),
	BLUE("BLUE"),
	PURPLE("PURPLE"),
	YELLOW("YELLOW"),
	GREEN("GREEN"),
	ORANGE("ORANGE");
		
	private String value;

	private Color(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
