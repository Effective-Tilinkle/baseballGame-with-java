package game.baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballTest {

	@DisplayName("야구공 번호의 정상적인 위치번호를 가져오는지 테스트 한다")
	@Test
	void getPositionTest() {
		Baseball baseball = Baseball.from(Arrays.asList(2, 3, 4));
		assertEquals(0, baseball.getPosition(2));
		assertEquals(1, baseball.getPosition(3));
		assertEquals(2, baseball.getPosition(4));
		assertEquals(-1, baseball.getPosition(5));
	}

	@DisplayName("중복된 값이 입력되면 예외를 발생 시킨다")
	@Test
	void addNoDuplicateTest() {

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Baseball.from(Arrays.asList(2, 2, 4));
		});

		assertEquals("Duplicate number detected", exception.getMessage());
	}

	@DisplayName("초과된 갯수의 값이 입력되면 예외를 발생 시킨다")
	@Test
	void addNoExceedTest() {

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Baseball.from(Arrays.asList(2, 3, 4, 5));
		});

		assertEquals("Too many baseball no exist", exception.getMessage());
	}
}