package game.baseball.domain;


import java.util.List;

import game.baseball.data.NumberGenerator;

public class Defender {

	private Baseball defenceBall;

	private Defender(List<Integer> baseballNos) {
		this.defenceBall = Baseball.from(baseballNos);
	}

	public static Defender from(NumberGenerator numberGenerator) {
		return new Defender(numberGenerator.generate());
	}

	public Baseball getDefenceNos() {
		return defenceBall;
	}
}
