package game.baseball.strategy;

import game.baseball.domain.Baseball;

public class BaseballGameStrategy implements GameStrategy {

	private Baseball baseball;
	private BaseballGameStrategy(Baseball baseball) {
		this.baseball = baseball;
	}

	public static BaseballGameStrategy from(Baseball baseball) {
		return new BaseballGameStrategy(baseball);
	}

	@Override
	public void judge() {

		String input = baseball.getInput();
		String target = baseball.getTarget();

		if (input.equals(target)) {
			baseball.threeStrikeOut();
			return;
		}

		for (char ch : input.toCharArray()) {
			int inputCharPosition = input.indexOf(ch);
			int targetCharPosition = target.indexOf(ch);
			compare(inputCharPosition, targetCharPosition, baseball);
		}
	}

	private void compare(int inputCharPosition, int targetCharPosition, Baseball baseball) {

		if (targetCharPosition < 0) {
			return;
		}

		int comp = Integer.compare(inputCharPosition, targetCharPosition);

		if (comp == 0) {
			baseball.plusStrike();
			return;
		}

		baseball.plusBall();
		return;
	}
}
