package game.baseball.domain;

public class Umpire {

	private GameResult gameResult;

	private Umpire() {
	}

	public static Umpire init() {
		return new Umpire();
	}

	public GameResult judge(Baseball attackNos, Baseball defenceNos) {

		gameResult = GameResult.init();

		compareNos(attackNos, defenceNos);

		return gameResult;
	}

	private void compareNos(Baseball attackNos, Baseball defenceNos) {

		defenceNos.getNos()
				  .filter(no -> attackNos.contains(no))
				  .forEach(no -> {
					  boolean compareResult = comparePosition(defenceNos.getPosition(no), attackNos.getPosition(no));
					  updateGameStatus(compareResult);
				  });
	}

	private boolean comparePosition(int defenceNoPosition, int attackNoPosition) {
		if (defenceNoPosition == attackNoPosition) {
			return true;
		}
		return false;
	}

	private void updateGameStatus(boolean compareResult) {
		if (compareResult) {
			gameResult.plusStrike();
			return;
		}
		gameResult.plusBall();
	}

}
