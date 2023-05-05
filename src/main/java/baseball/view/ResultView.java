package baseball.view;

import baseball.domain.BallCounter;

public class ResultView {
    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String BALL_FORMAT = "%d볼";
    private static final String BALL_COUNT_FORMAT = "%d스트라이크 %d볼";
    private static final String NOTHING = "낫싱";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";

    private ResultView() { }

    public static void printResult(BallCounter ballCounter) {
        System.out.println(getMessage(ballCounter));
    }

    private static String getMessage(BallCounter ballCounter) {
        if (ballCounter.isAllStrike()) {
            System.out.println(printStrikeCount(ballCounter));
            return WINNING_MESSAGE;
        }

        if (ballCounter.hasOnlyStrike()) {
            return printStrikeCount(ballCounter);
        }

        if (ballCounter.hasOnlyBall()) {
            return printBallCount(ballCounter);
        }

        if (ballCounter.hasStrikeAndBall()) {
            return printStrikeAndBallCount(ballCounter);
        }

        return NOTHING;
    }

    private static String printStrikeCount(BallCounter ballCounter) {
        return String.format(STRIKE_FORMAT, ballCounter.getStrike());
    }

    private static String printBallCount(BallCounter ballCounter) {
        return String.format(BALL_FORMAT, ballCounter.getBall());
    }

    private static String printStrikeAndBallCount(BallCounter ballCounter) {
        return String.format(BALL_COUNT_FORMAT, ballCounter.getStrike(), ballCounter.getBall());
    }
}
