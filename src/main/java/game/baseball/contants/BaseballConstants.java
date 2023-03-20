package game.baseball.contants;

public enum BaseballConstants {
	CONTINUE("1"),
	EXIT("2");

	String value;

	BaseballConstants(String value) {
		this.value = value;
	}

	public boolean is(String value) {
		return this.value.equals(value);
	}
}
