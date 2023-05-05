package baseball.utils;

import baseball.domain.BallNumbers;
import baseball.constant.GameRules;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class BallNumberGenerator {
    private static final List<Integer> BALL_NUMBERS =
            IntStream.rangeClosed(GameRules.START_RANGE.getValue(), GameRules.END_RANGE.getValue())
                    .boxed()
                    .collect(toList());

    private BallNumberGenerator() { }

    public static BallNumbers generate() {
        Collections.shuffle(BALL_NUMBERS);
        return BALL_NUMBERS.stream()
                .limit(GameRules.THROW_COUNT.getValue())
                .collect(collectingAndThen(toList(), BallNumbers::from));
    }
}
