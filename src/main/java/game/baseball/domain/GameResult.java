package game.baseball.domain;

public class GameResult {

	private int strike;
	private int ball;

	private GameResult() {
	}

	public static GameResult init() {
		return new GameResult();
	}

	public void plusStrike() {
		this.strike++;
	}

	public void plusBall() {
		this.ball++;
	}

	public int getStrike() {
		return this.strike;
	}

	public int getBall() {
		return this.ball;
	}

	public boolean isOut(int baseballNoCount) {
		return this.strike == baseballNoCount;
	}
}
