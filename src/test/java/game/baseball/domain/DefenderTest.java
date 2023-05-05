package game.baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefenderTest {

	@DisplayName("생성된 숫자가 리스트에 순서대로 잘 들어갔는지 확인한다.")
	@Test
	void defenceNoTest() {
		Defender defender = Defender.from(() -> Arrays.asList(1, 2, 3));
		assertEquals(0, defender.getDefenceNos().getPosition(1));
		assertEquals(1, defender.getDefenceNos().getPosition(2));
		assertEquals(2, defender.getDefenceNos().getPosition(3));
	}

}