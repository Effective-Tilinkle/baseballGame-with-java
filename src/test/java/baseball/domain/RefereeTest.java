package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private Referee referee;

    @BeforeEach
    void setUp() {
        BallNumbers targetNumber = BallNumbers.from(Arrays.asList(1,5,7));
        referee = Referee.of(targetNumber);
    }

    @DisplayName("심판이 올바른 볼 카운트를 반환한다.")
    @ParameterizedTest
    @MethodSource("playerPickNumberAndBallCountProvider")
    void 볼_카운트_판정_테스트(BallNumbers playerPickNumbers, int expectStrikeCount, int expectBallCount) {
        BallCounter ballCounter = referee.call(playerPickNumbers);

        assertThat(ballCounter.getStrike()).isEqualTo(expectStrikeCount);
        assertThat(ballCounter.getBall()).isEqualTo(expectBallCount);
    }

    @DisplayName("심판은 볼카운트 판정 진행 후 새로운 BallCounter 객체를 할당한다.")
    @ParameterizedTest
    @MethodSource("playerPickNumberAndBallCountProvider")
    void 새로운_볼_카운터_객체_생성_테스트(BallNumbers playerPickNumbers) {
        BallCounter ballCounter1 = referee.call(playerPickNumbers);
        BallCounter ballCounter2 = referee.call(playerPickNumbers);

        assertThat(ballCounter1).doesNotHaveSameHashCodeAs(ballCounter2);
    }

    private static Stream<Arguments> playerPickNumberAndBallCountProvider() {
        return Stream.of(
                Arguments.of(
                        BallNumbers.from(Arrays.asList(1,2,3)),
                        1,
                        0
                ),
                Arguments.of(
                        BallNumbers.from(Arrays.asList(1,7,5)),
                        1,
                        2
                ),
                Arguments.of(
                        BallNumbers.from(Arrays.asList(5,7,1)),
                        0,
                        3
                ),
                Arguments.of(
                        BallNumbers.from(Arrays.asList(1,5,7)),
                        3,
                        0
                )
        );
    }

    @DisplayName("삼진 아웃이 아닌 경우 true를 반환한다.")
    @ParameterizedTest
    @MethodSource("playerPickNumbersProvider")
    void 삼진_아웃_테스트(BallNumbers playerPickNumbers, boolean isNotStrikeOut) {
        referee.call(playerPickNumbers);
        assertThat(referee.isNotStrikeOut()).isEqualTo(isNotStrikeOut);
    }

    private static Stream<Arguments> playerPickNumbersProvider() {
        return Stream.of(
                Arguments.of(
                        BallNumbers.from(Arrays.asList(1,5,7)),
                        false
                ),
                Arguments.of(
                        BallNumbers.from(Arrays.asList(1,7,5)),
                        true
                ),
                Arguments.of(
                        BallNumbers.from(Arrays.asList(5,7,1)),
                        true
                )
        );
    }
}