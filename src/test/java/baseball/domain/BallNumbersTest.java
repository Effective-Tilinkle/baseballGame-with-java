package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallNumbersTest {

    @DisplayName("중복된 숫자를 입력하는 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @MethodSource("duplicateNumberProvider")
    void 중복된_숫자_예외_테스트(List<Integer> inputNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BallNumbers.from(inputNumbers))
                .withMessage("입력 숫자는 중복될 수 없습니다.");
    }

    private static Stream<Arguments> duplicateNumberProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,1,2)),
                Arguments.of(Arrays.asList(9,2,2)),
                Arguments.of(Arrays.asList(5,2,5)),
                Arguments.of(Arrays.asList(7,7,7))
        );
    }

    @DisplayName("입력 범위를 만족하지 못하고 객체를 생성하려 하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @MethodSource("outOfRangeNumberProvider")
    void 입력_범위_생성_예외_테스트(List<Integer> inputNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BallNumbers.from(inputNumbers))
                .withMessage("입력한 숫자가 입력 범위를 만족하지 못했습니다. 숫자 3개를 입력해주세요.");
    }

    private static Stream<Arguments> outOfRangeNumberProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4)),
                Arguments.of(Arrays.asList(9,2,3,1)),
                Arguments.of(Arrays.asList(7,5)),
                Arguments.of(Arrays.asList(7))
        );
    }

    @DisplayName("객체의 요소가 같은 위치와 같은 값을 가지고 있으면 true를 반환한다.")
    @ParameterizedTest
    @MethodSource("ballNumbersProvider")
    void 요소_일치_테스트(BallNumbers targetNumbers, BallNumbers inputNumbers, int index) {
        assertThat(targetNumbers.containsExactly(inputNumbers, index)).isTrue();
    }

    @DisplayName("객체의 요소를 포함하고 있으면 true를 반환한다.")
    @ParameterizedTest
    @MethodSource("ballNumbersProvider")
    void 요소_포함_테스트(BallNumbers targetNumbers, BallNumbers inputNumbers, int index) {
        assertThat(targetNumbers.contains(inputNumbers, index)).isTrue();
    }

    private static Stream<Arguments> ballNumbersProvider() {
        return Stream.of(
                Arguments.of(
                        BallNumbers.from(Arrays.asList(1,2,3)),
                        BallNumbers.from(Arrays.asList(1,2,3)),
                        0
                ),
                Arguments.of(
                        BallNumbers.from(Arrays.asList(9,2,3)),
                        BallNumbers.from(Arrays.asList(1,2,7)),
                        1
                ),
                Arguments.of(
                        BallNumbers.from(Arrays.asList(6,8,7)),
                        BallNumbers.from(Arrays.asList(1,2,7)),
                        2
                )
        );
    }
}