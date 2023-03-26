package baseball.application;

import baseball.domain.BallCounter;
import baseball.domain.GameHost;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.utils.BallNumberGenerator;
import baseball.view.InputView;
import baseball.view.ResultView;

public class BaseballGame {
    public void play() {
        GameHost computer = GameHost.from(BallNumberGenerator.generate());
        Referee referee = Referee.of(computer.getTargetNumbers());

        while(referee.isNotStrikeOut()) {
            Player player = Player.from(InputView.enterNumber());
            BallCounter ballCounter = referee.call(player.getPickNumbers());
            ResultView.printResult(ballCounter);
        }
    }
}
