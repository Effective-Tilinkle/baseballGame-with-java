package game.baseball.domain;

public class BaseballGame {

	private boolean keepGoing = true;

	private BaseballGame() {
	}

	public static BaseballGame init() {
		return new BaseballGame();
	}

	public void keepGoing(boolean isKeepGoing) {
		this.keepGoing = isKeepGoing;
	}

	public boolean isKeepGoing() {
		return this.keepGoing;
	}
}
