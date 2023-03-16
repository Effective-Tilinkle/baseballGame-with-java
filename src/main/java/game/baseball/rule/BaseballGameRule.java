package game.baseball.rule;

import java.util.regex.Pattern;

import game.rule.GameRule;

public enum BaseballGameRule implements GameRule<String> {

	BASIC("^[1-9]*$", 3);

	String regex;
	int range;

	BaseballGameRule(String regex, int range) {
		this.regex = regex;
		this.range = range;
	}


	@Override
	public boolean isComplyWith(String param) {
		return Pattern.matches(regex, param) && param.length() == range;
	}
}
