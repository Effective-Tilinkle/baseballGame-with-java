package game.baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Attacker {

	private Baseball attackBall;

	private Attacker() {
	}

	public static Attacker init() {
		return new Attacker();
	}

	public void shoot(String baseballNos) {

		List<Integer> list = Arrays.stream(baseballNos.split(""))
								   .map(no -> Integer.parseInt(no))
								   .collect(Collectors.toList());

		attackBall = Baseball.from(list);
	}

	public Baseball getAttackNos() {
		return this.attackBall;
	}

}
