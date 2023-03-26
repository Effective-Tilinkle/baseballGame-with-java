package baseball.constant;

public enum GameRules {
    START_RANGE(1),
    END_RANGE(9),
    THROW_COUNT(3);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
