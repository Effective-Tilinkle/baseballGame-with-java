package game.baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AttackerTest {


	@DisplayName("입력된 숫자가 리스트에 순서대로 잘 들어갔는지 확인한다.")
	@Test
	void shootTest() {
		Attacker attacker = Attacker.init();
		attacker.shoot(123);

		assertEquals(0, attacker.getAttackNos().getPosition(1));
		assertEquals(1, attacker.getAttackNos().getPosition(2));
		assertEquals(2, attacker.getAttackNos().getPosition(3));
		
	}

}