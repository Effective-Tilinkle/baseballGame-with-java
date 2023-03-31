package game.baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attacker {

	private Baseball attackBall;

	private Attacker() {
	}

	public static Attacker init() {
		return new Attacker();
	}

	public void shoot(String baseballNos) {
		List<Integer> list = new ArrayList<>();

		Arrays.stream(baseballNos.split("")).forEach(no -> {
			list.add(Integer.parseInt(no));
		});
		attackBall = Baseball.from(list);
	}

	public Baseball getAttackNos() {
		return this.attackBall;
	}

}
