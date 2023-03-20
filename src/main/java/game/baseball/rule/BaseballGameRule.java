package game.baseball.rule;

import java.util.regex.Pattern;

public enum BaseballGameRule {

	BASIC("^[1-9]*$", 3);

	String regex;
	int range;

	BaseballGameRule(String regex, int range) {
		this.regex = regex;
		this.range = range;
	}

	public boolean isComplyWith(String param) {
		return Pattern.matches(regex, param) && param.length() == range;
	}

	public int getRange() {
		return this.range;
	}
}
