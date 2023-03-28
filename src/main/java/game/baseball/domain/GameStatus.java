package game.baseball.domain;

public class GameStatus {

	private int strike;
	private int ball;

	public void plusStrike() {
		this.strike++;
	}

	public void plusBall() {
		this.ball++;
	}
}
