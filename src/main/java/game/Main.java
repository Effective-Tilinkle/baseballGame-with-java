package game;

import game.baseball.domain.BaseballGame;
import game.baseball.service.GameService;

public class Main {

	public static void main(String[] args) {

		GameService gameService = GameService.of(BaseballGame.init());
		gameService.gameStart();
	}
}
