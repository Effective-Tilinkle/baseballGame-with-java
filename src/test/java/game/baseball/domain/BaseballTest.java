package game.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballTest {

	@DisplayName("야구공 번호의 정상적인 위치번호를 가져오는지 테스트 한다")
	@ParameterizedTest
	@MethodSource("positionTestArgumentsProvider")
	void getPositionTest(List<Integer> input, List<Integer> searchNos, List<Integer> expectedPos) {

		Baseball baseball = Baseball.from(input);

		List<Integer> actualPos = searchNos.stream()
										   .map(no -> baseball.getPosition(no))
										   .collect(Collectors.toList());

		assertThat(actualPos).isEqualTo(expectedPos);
	}

	@DisplayName("중복된 값이 입력되면 예외를 발생 시킨다")
	@Test
	void addNoDuplicateTest() {

		assertThatIllegalArgumentException()
				.isThrownBy(() -> Baseball.from(Arrays.asList(2, 2, 4)))
				.withMessage("Duplicate number detected");

	}

	@DisplayName("초과된 갯수의 값이 입력되면 예외를 발생 시킨다")
	@Test
	void addNoExceedTest() {

		assertThatIllegalArgumentException()
				.isThrownBy(() -> Baseball.from(Arrays.asList(2, 3, 4, 5)))
				.withMessage("Invalid length no");
	}

	@DisplayName("초과된 갯수의 값이 입력되면 예외를 발생 시킨다")
	@Test
	void shotLengthNoTest() {

		assertThatIllegalArgumentException()
				.isThrownBy(() -> Baseball.from(Arrays.asList(2, 3)))
				.withMessage("Invalid length no");
	}


	@DisplayName("잘못된 값이 입력되면 예외를 발생 시킨다")
	@Test
	void invalidNoContainTest() {

		assertThatIllegalArgumentException()
				.isThrownBy(() -> Baseball.from(Arrays.asList(3, 0, 5)))
				.withMessage("Invalid number contained");

	}


	private static Stream<Arguments> positionTestArgumentsProvider() {

		return Stream.of(
				Arguments.of(Arrays.asList(2, 3, 4), Arrays.asList(2, 3, 4), Arrays.asList(0, 1, 2)),
				Arguments.of(Arrays.asList(2, 3, 4), Arrays.asList(3, 4, 5), Arrays.asList(1, 2, -1)));

	}

}