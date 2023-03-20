package game;

import game.baseball.domain.Baseball;
import game.baseball.message.BaseballGameMessage;
import game.baseball.rule.BaseballGameRule;
import game.baseball.strategy.BaseballGameStrategy;
import game.baseball.view.InputView;
import game.baseball.view.ResultView;

public class Main {

	public static void main(String[] args){

		Baseball baseball = Baseball.of(BaseballGameRule.BASIC);

		while (baseball.isContinue()) {
			baseball.start(InputView.input(BaseballGameMessage.INPUT_THE_NUMBER), BaseballGameStrategy.from(baseball));
			ResultView.print(baseball);
			baseball.checkStrike();
		}
	}
}
