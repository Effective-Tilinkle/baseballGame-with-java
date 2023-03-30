package game.baseball.domain;


import java.util.List;

import game.baseball.data.BaseballNoGenerator;

public class Defender {

	private Baseball defenceBall;

	private Defender(List<Integer> baseballNos) {
		this.defenceBall = Baseball.from(baseballNos);
	}

	public static Defender from(BaseballNoGenerator baseballNoGenerator) {
		return new Defender(baseballNoGenerator.generate());
	}

	public Baseball getDefenceNos() {
		return defenceBall;
	}
}
