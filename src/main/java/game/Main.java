package game;

import game.baseball.Baseball;
import game.baseball.BaseballGameStrategy;
import game.baseball.message.BaseballGameMessage;
import game.baseball.rule.BaseballGameRule;
import game.baseball.view.InputView;
import game.baseball.view.ResultView;

public class Main {

	public static void main(String[] args) throws Exception {

		Baseball baseball = Baseball.of("345", BaseballGameRule.BASIC);

		while (true) {
			baseball.start(InputView.input(BaseballGameMessage.INPUT_THE_NUMBER), new BaseballGameStrategy());
			ResultView.print(baseball);

			if (baseball.isOut()) {
				if (!baseball.toBeContinue(InputView.input(BaseballGameMessage.CONTINUE))) {
					break;
				}
			}
		}
	}
}
