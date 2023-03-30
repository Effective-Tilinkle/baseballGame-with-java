package game.baseball.view;

import game.baseball.domain.GameResult;
import game.baseball.message.BaseballGameMessage;

public class ResultView {

	public static void print(GameResult gameResult) {

		StringBuilder message = new StringBuilder();
		if (gameResult.getStrike() > 0) {
			message.append(BaseballGameMessage.STRIKE.getSentence(gameResult.getStrike()));
		}
		if (gameResult.getStrike() == 3) {
			message.append(System.lineSeparator()).append(BaseballGameMessage.FIN.getSentence(gameResult.getStrike()));
		}
		if (gameResult.getBall() > 0) {
			message.append(BaseballGameMessage.BALL.getSentence(gameResult.getBall()));
		}
		if (gameResult.getStrike() == 0 && gameResult.getBall() == 0) {
			message.append(BaseballGameMessage.NOTHING.getSentence());
		}
		System.out.println(message);
	}
}
