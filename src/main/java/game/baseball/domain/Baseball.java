package game.baseball.domain;

import game.baseball.contants.BaseballConstants;
import game.baseball.message.BaseballGameMessage;
import game.baseball.rule.BaseballGameRule;
import game.baseball.strategy.GameStrategy;

public class Baseball {

	private int strike;
	private int ball;

	private String input;
	private String target;
	private BaseballGameRule baseballGameRule;

	private Baseball(BaseballGameRule baseballGameRule) {
		this.target = createTarget();
		this.baseballGameRule = baseballGameRule;
	}

	public static Baseball of(BaseballGameRule baseballGameRule) {
		return new Baseball(baseballGameRule);
	}

	private String createTarget() {
		StringBuilder targetBuffer = new StringBuilder();
		while (targetBuffer.length() < 3) {
			randomNumberAppend(targetBuffer);
		}
		return targetBuffer.toString();
	}

	private static void randomNumberAppend(StringBuilder targetBuffer) {
		int value = (int) (Math.random() * 9) + 1;
		if (targetBuffer.indexOf(String.valueOf(value)) < 0) {
			targetBuffer.append(value);
		}
	}

	public void start(String input, GameStrategy gameStrategy) {
		validate(input, baseballGameRule);
		reset(input);
		gameStrategy.judge(this);
	}

	private static void validate(String input, BaseballGameRule gameRule) {
		boolean isComplyWith = gameRule.isComplyWith(input);
		if (!isComplyWith) {
			throw new IllegalArgumentException("입력 값이 적절하지 않습니다.");
		}
	}

	public boolean toBeContinue(String input) {
		if (BaseballConstants.CONTINUE.is(input)) {
			return true;
		}
		return false;
	}

	private void reset(String input) {
		this.strike = 0;
		this.ball = 0;
		this.input = input;
	}

	public void plusStrike() {
		this.strike++;
	}

	public void plusBall() {
		this.ball++;
	}

	public String getInput() {
		return this.input;
	}

	public String getTarget() {
		return this.target;
	}

	public void threeStrikeOut() {
		this.strike = baseballGameRule.getRange();
	}

	public boolean isEnd() {
		return this.strike == baseballGameRule.getRange();
	}

	@Override
	public String toString() {

		StringBuilder message = new StringBuilder();
		if (strike > 0) {
			message.append(BaseballGameMessage.STRIKE.getSentence(strike));
		}
		if (strike == baseballGameRule.getRange()) {
			message.append(System.lineSeparator()).append(BaseballGameMessage.FIN.getSentence(strike));
		}
		if (ball > 0) {
			message.append(BaseballGameMessage.BALL.getSentence(ball));
		}
		if (strike == 0 && ball == 0) {
			message.append(BaseballGameMessage.NOTHING.getSentence());
		}
		return message.toString();
	}
}
