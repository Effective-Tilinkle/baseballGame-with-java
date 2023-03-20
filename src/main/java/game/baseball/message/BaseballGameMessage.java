package game.baseball.message;

public enum BaseballGameMessage {

	INPUT_THE_NUMBER("숫자를 입력해주세요 : "),
	STRIKE("%d스트라이크"),
	BALL("%d볼"),
	NOTHING("맞는 숫자가 없습니다."),
	FIN("%d개의 숫자를 모두 맞히셨습니다.! 게임 끝"),
	CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

	String message;

	BaseballGameMessage(String message) {
		this.message = message;
	}

	private String getMessage() {
		return this.message;
	}

	public String getSentence(int count) {
		return String.format(getMessage(), count);
	}

	public String getSentence() {
		return this.message;
	}
}
