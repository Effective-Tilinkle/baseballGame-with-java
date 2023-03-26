package baseball;

import baseball.application.BaseballGame;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        int coin = 1;
        while(coin == 1) {
            new BaseballGame().play();
            coin = InputView.enterTryAgain();
        }
    }
}
