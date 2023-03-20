package game.baseball.contants;

import java.util.Arrays;

public enum BaseballConstants {
    CONTINUE("1"),
    EXIT("2");

    String value;

    BaseballConstants(String value) {
        this.value = value;
    }

    public boolean is(String value) {
        return this.value.equals(value);
    }

    public static BaseballConstants getFromValue(String value) {

        return Arrays.stream(values())
                .filter(baseballConstants -> baseballConstants.is(value))
                .findFirst()
                .orElseThrow(() -> {
                    return new RuntimeException("존재 하지 않는 값");
                });
    }
}
