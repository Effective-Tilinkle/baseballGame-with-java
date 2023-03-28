package game.baseball.domain;

import game.baseball.view.InputView;

public class AttackerPlayer {

	private BaseballNos attackNos;

	private AttackerPlayer() {
		this.attackNos = BaseballNos.init();
	}

	public static AttackerPlayer init() {
		return new AttackerPlayer();
	}

	public void shoot() {
		attackNos.clear();
		int numbers = InputView.input();
		attackNos.addNos(numbers);
	}

	public BaseballNos getAttackNos() {
		return this.attackNos;
	}

}
