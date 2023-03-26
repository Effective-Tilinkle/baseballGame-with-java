package baseball.domain;

import baseball.constant.GameRules;

public class Referee {
    private final BallNumbers targetNumbers;
    private BallCounter ballCounter;

    private Referee(final BallNumbers targetNumbers, BallCounter ballCounter) {
        this.targetNumbers = targetNumbers;
        this.ballCounter = ballCounter;
    }

    public static Referee of(final BallNumbers targetNumbers) {
        return new Referee(targetNumbers, BallCounter.newInstance());
    }

    public BallCounter call(BallNumbers playerPickNumbers) {
        ballCounter = BallCounter.newInstance();
        for (int index = 0; index < GameRules.THROW_COUNT.getValue(); index++) {
            getBallCount(playerPickNumbers, index);
        }

        return ballCounter;
    }

    private void getBallCount(BallNumbers playerPickNumbers, int index) {
        if (isStrike(playerPickNumbers, index)) {
            ballCounter.plusStrike();
        }

        if (isBall(playerPickNumbers, index)) {
            ballCounter.plusBall();
        }
    }

    private boolean isStrike(BallNumbers playerPickNumbers, int index) {
        return targetNumbers.containsExactly(playerPickNumbers, index);
    }

    private boolean isBall(BallNumbers playerPickNumbers, int index) {
        return !isStrike(playerPickNumbers, index) &&
                targetNumbers.contains(playerPickNumbers, index);
    }

    public boolean isNotStrikeOut() {
        return !ballCounter.isAllStrike();
    }
}
