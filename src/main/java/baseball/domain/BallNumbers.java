package baseball.domain;

import baseball.constant.GameRules;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BallNumbers {
    private static final String BALL_NUMBER_CANNOT_DUPLICATE = "입력 숫자는 중복될 수 없습니다.";
    private static final String OUT_OF_RANGE_NUMBER = "입력한 숫자가 입력 범위를 만족하지 못했습니다. 숫자 3개를 입력해주세요.";

    private List<BallNumber> ballNumbers;

    private BallNumbers(List<BallNumber> ballNumbers) {
        this.ballNumbers = ballNumbers;
    }

    public static BallNumbers from(List<Integer> inputNumbers) {
        validateBallNumberSize(inputNumbers);
        validateDuplicateNumber(inputNumbers);
        return new BallNumbers(toBallNumbers(inputNumbers));
    }

    private static List<BallNumber> toBallNumbers(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .map(number -> BallNumber.from(number))
                .collect(toList());
    }

    private static void validateBallNumberSize(List<Integer> inputNumbers) {
        if (inputNumbers.size() != GameRules.THROW_COUNT.getValue()) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER);
        }
    }

    private static void validateDuplicateNumber(List<Integer> inputNumbers) {
        if (hasDuplicatedNumber(inputNumbers)) {
            throw new IllegalArgumentException(BALL_NUMBER_CANNOT_DUPLICATE);
        }
    }

    private static boolean hasDuplicatedNumber(List<Integer> inputNumbers) {
        return inputNumbers.stream()
                .distinct()
                .count() != inputNumbers.size();
    }

    public boolean containsExactly(BallNumbers pickNumbers, int index) {
        return valueOf(index).equals(pickNumbers.valueOf(index));
    }

    public boolean contains(BallNumbers pickNumbers, int index) {
        return ballNumbers.contains(pickNumbers.valueOf(index));
    }

    private BallNumber valueOf(int index) {
        return ballNumbers.get(index);
    }
}
