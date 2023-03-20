package game.baseball;

import game.baseball.strategy.GameStrategy;

public class BaseballGameStrategy implements GameStrategy<Baseball, Baseball> {

	@Override
	public Baseball judge(Baseball baseball) {

		String input = baseball.getInput();
		String target = baseball.getTarget();

		if (input.equals(target)) {
			baseball.threeStrikeOut();
			return baseball;
		}

		for (char ch : input.toCharArray()) {
			int inputCharPosition = input.indexOf(ch);
			int targetCharPosition = target.indexOf(ch);
			compare(inputCharPosition, targetCharPosition, baseball);
		}

		return baseball;
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
