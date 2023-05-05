package baseball;

import baseball.application.BaseballGame;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        int credit = 1;
        while(credit == 1) {
            new BaseballGame().play();
            credit = InputView.enterTryAgain();
        }
    }
}
