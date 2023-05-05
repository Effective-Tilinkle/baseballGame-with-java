package baseball.domain;

import baseball.constant.GameRules;

public class BallCounter {
    private int strike;
    private int ball;

    private BallCounter(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static BallCounter newInstance() {
        return new BallCounter(0, 0);
    }

    public boolean isAllStrike() {
        return strike == GameRules.THROW_COUNT.getValue();
    }

    public boolean hasOnlyStrike() {
        return hasStrikeCount() && !hasBallCount();
    }

    public boolean hasOnlyBall() {
        return !hasStrikeCount() && hasBallCount();
    }

    public boolean hasStrikeAndBall() {
        return hasStrikeCount() && hasBallCount();
    }

    private boolean hasStrikeCount() {
        return strike > 0;
    }

    private boolean hasBallCount() {
        return ball > 0;
    }

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
