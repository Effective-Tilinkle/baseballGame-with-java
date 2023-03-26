package baseball.domain;

import baseball.constant.GameRules;

import java.util.Objects;

public class BallNumber {
    private static final String OUT_OF_RANGE_NUMBER = "입력 범위에 벗어난 숫자입니다. 입력 가능한 숫자 범위: 1 ~ 9";

    private int ballNumber;

    private BallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public static BallNumber from(int ballNumber) {
        validateNumberRange(ballNumber);
        return new BallNumber(ballNumber);
    }

    private static void validateNumberRange(int ballNumber) {
        if (ballNumber < GameRules.START_RANGE.getValue() || ballNumber > GameRules.END_RANGE.getValue()) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return ballNumber == that.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
