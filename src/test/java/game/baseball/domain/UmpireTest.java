package game.baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UmpireTest {

	@DisplayName("입력된 값에 따라 예상된 경기 결과가 나오는지 확인한다")
	@ParameterizedTest
	@CsvSource({
			"123, 123, 3, 0",
			"123, 132, 1, 2",
			"124, 123, 2, 0",
			"789, 123, 0, 0"
	})
	void judgeTest(int attackNo, int ballNo, int strike, int ball) {

		Baseball attackBall = Baseball.from(listFromNumber(attackNo));
		Baseball defenceBall = Baseball.from(listFromNumber(ballNo));

		Umpire umpire = Umpire.init();
		GameResult gameResult = umpire.judge(attackBall, defenceBall);

		assertEquals(strike, gameResult.getStrike());
		assertEquals(ball, gameResult.getBall());

	}

	private List<Integer> listFromNumber(int nums) {

		List<Integer> intList = new ArrayList<>();

		while (nums > 0) {
			intList.add(0, nums % 10);
			nums /= 10;
		}
		return intList;
	}
}