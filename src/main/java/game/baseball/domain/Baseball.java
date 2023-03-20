package game.baseball.domain;

import game.baseball.contants.BaseballConstants;
import game.baseball.message.BaseballGameMessage;
import game.baseball.rule.BaseballGameRule;
import game.baseball.strategy.GameStrategy;
import game.baseball.view.InputView;

public class Baseball {

	private int strike;
	private int ball;

	private BaseballGameRule baseballGameRule;
	private BaseballConstants baseballConstants;
	private String input;
	private String target;

	private Baseball(BaseballGameRule baseballGameRule) {
		this.baseballGameRule = baseballGameRule;
		this.baseballConstants = BaseballConstants.CONTINUE;
		this.target = createTarget();
	}

	public static Baseball of(BaseballGameRule baseballGameRule) {
		return new Baseball(baseballGameRule);
	}

	private String createTarget() {
		StringBuilder targetBuffer = new StringBuilder();
		while (targetBuffer.length() < baseballGameRule.getRange()) {
			randomNumberAppend(targetBuffer);
		}
		System.out.println("hidden string : " + targetBuffer.toString());
		return targetBuffer.toString();
	}

	private void randomNumberAppend(StringBuilder targetBuffer) {
		int value = (int) (Math.random() * 9) + 1;
		if (targetBuffer.indexOf(String.valueOf(value)) < 0) {
			targetBuffer.append(value);
		}
	}

	public void start(String input, GameStrategy gameStrategy) {
		validate(input, baseballGameRule);
		reset(input);
		gameStrategy.judge();
	}

	private void validate(String input, BaseballGameRule gameRule) {
		boolean isComplyWith = gameRule.isComplyWith(input);
		if (!isComplyWith) {
			throw new IllegalArgumentException("입력 값이 적절하지 않습니다.");
		}
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

	public void checkStrike() {
		if(isStrikeOut()) {
			changeStatusAs(InputView.input(BaseballGameMessage.CONTINUE));
		}
	}
	private boolean isStrikeOut() {
		return this.strike == baseballGameRule.getRange();
	}

	private void changeStatusAs(String input){
		this.baseballConstants = BaseballConstants.getFromValue(input);
		this.target = createTarget();
	}

	public boolean isContinue() {
		return this.baseballConstants == BaseballConstants.CONTINUE;
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
