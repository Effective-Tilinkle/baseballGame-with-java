package game.baseball.vo;

public class Baseball {

	private int strike;
	private int ball;

	private Baseball() {
	}

	public static Baseball init() {
		return new Baseball();
	}

	public void plusStrike() {
		this.strike++;
	}

	public void plusBall() {
		this.ball++;
	}

	public int getStrikeCount() {
		return this.strike;
	}

	public int getBallCount() {
		return this.ball;
	}
}
