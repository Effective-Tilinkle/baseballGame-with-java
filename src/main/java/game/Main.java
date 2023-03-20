package game;

import game.baseball.domain.Baseball;
import game.baseball.message.BaseballGameMessage;
import game.baseball.rule.BaseballGameRule;
import game.baseball.strategy.BaseballGameStrategy;
import game.baseball.view.InputView;
import game.baseball.view.ResultView;

public class Main {

	public static void main(String[] args) throws Exception {

		Baseball baseball = Baseball.of(BaseballGameRule.BASIC);

		while (true) {
			baseball.start(InputView.input(BaseballGameMessage.INPUT_THE_NUMBER), new BaseballGameStrategy());
			ResultView.print(baseball);

			if (baseball.isEnd() && !baseball.toBeContinue(InputView.input(BaseballGameMessage.CONTINUE))) {
				break;
			}
		}
	}
}
