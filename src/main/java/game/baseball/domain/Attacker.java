package game.baseball.domain;

public class Attacker {

	private Baseball attackBall;

	private Attacker() {
		this.attackBall = Baseball.init();
	}

	public static Attacker init() {
		return new Attacker();
	}

	public void shoot(int baseballNos) {
		attackBall.clear();

		while (baseballNos > 0) {
			int no = baseballNos % 10;
			this.attackBall.addNo(no);
			baseballNos /= 10;
		}
	}

	public Baseball getAttackNos() {
		return this.attackBall;
	}

}
