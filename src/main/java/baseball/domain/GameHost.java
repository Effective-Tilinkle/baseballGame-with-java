package baseball.domain;

public class GameHost {
    private final BallNumbers targetNumbers;

    private GameHost(BallNumbers targetNumbers) {
        this.targetNumbers = targetNumbers;
    }

    public static GameHost from(final BallNumbers targetNumbers) {
        return new GameHost(targetNumbers);
    }

    public BallNumbers getTargetNumbers() {
        return targetNumbers;
    }
}
