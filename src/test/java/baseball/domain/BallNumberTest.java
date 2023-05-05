package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallNumberTest {

    @DisplayName("범위를 벗어난 수를 입력해 생성하는 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 11, 12})
    void 객체_생성_예외_테스트(int inputNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BallNumber.from(inputNumber))
                .withMessage("입력 범위에 벗어난 숫자입니다. 입력 가능한 숫자 범위: 1 ~ 9");
    }

    @DisplayName("입력된 숫자가 같은 경우 동일한 BallNumber 객체로 판단된다.")
    @Test
    void 객체_동치_테스트() {
        BallNumber ballNumber1 = BallNumber.from(1);
        BallNumber ballNumber2 = BallNumber.from(1);

        assertThat(ballNumber1)
                .isEqualTo(ballNumber2)
                .hasSameHashCodeAs(ballNumber2);
    }

}