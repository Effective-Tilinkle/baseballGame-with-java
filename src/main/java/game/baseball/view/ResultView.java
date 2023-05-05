package game.baseball.view;

import game.baseball.constant.BaseballConstants;
import game.baseball.domain.GameResult;
import game.baseball.message.BaseballGameMessage;

public class ResultView {

	public static void print(GameResult gameResult) {

		StringBuilder message = new StringBuilder();
		if (gameResult.hasStrike()) {
			message.append(BaseballGameMessage.STRIKE.getSentence(gameResult.getStrike()));
		}
		if (gameResult.isOut(BaseballConstants.NO_LENGTH_LIMIT)) {
			message.append(System.lineSeparator()).append(BaseballGameMessage.FIN.getSentence(gameResult.getStrike()));
		}
		if (gameResult.hasBall()) {
			message.append(BaseballGameMessage.BALL.getSentence(gameResult.getBall()));
		}
		if (gameResult.hasNothing()) {
			message.append(BaseballGameMessage.NOTHING.getSentence());
		}
		System.out.println(message);
	}
}
