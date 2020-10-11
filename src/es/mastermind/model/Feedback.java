package es.mastermind.model;

public enum Feedback {
	
	SUCCESS("SUCCESS"),
	FAILURE("FAILURE");
		
	private String value;

	private Feedback(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
