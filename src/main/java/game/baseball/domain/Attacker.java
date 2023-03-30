package game.baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Attacker {

	private Baseball attackBall;

	private Attacker() {
	}

	public static Attacker init() {
		return new Attacker();
	}

	public void shoot(int baseballNos) {
		List<Integer> list = new ArrayList<>();
		while (baseballNos > 0) {
			int no = baseballNos % 10;
			list.add(0, no);
			baseballNos /= 10;
		}
		attackBall = Baseball.from(list);
	}

	public Baseball getAttackNos() {
		return this.attackBall;
	}

}
