package game.baseball.domain;

public class DefencePlayer {

	private BaseballNos defenceNos;

	private DefencePlayer() {
		createDefenceNos();
	}

	public static DefencePlayer init() {
		return new DefencePlayer();
	}

	private void createDefenceNos() {
		while (this.defenceNos.size() <= 3) {
			int value = (int) (Math.random() * 9) + 1;
			selectNo(value);
		}
	}

	private void selectNo(int no) {
		if (!this.defenceNos.contains(no)) {
			this.defenceNos.addNo(no);
		}
	}

	public BaseballNos getDefenceNos() {
		return this.defenceNos;
	}
}
