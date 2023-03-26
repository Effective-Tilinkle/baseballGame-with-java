package baseball.domain;

import java.util.List;

public class Player {
    private BallNumbers pickNumbers;

    private Player(BallNumbers pickNumbers) {
        this.pickNumbers = pickNumbers;
    }

    public static Player from(List<Integer> pickNumbers) {
        return new Player(BallNumbers.from(pickNumbers));
    }

    public BallNumbers getPickNumbers() {
        return pickNumbers;
    }
}
