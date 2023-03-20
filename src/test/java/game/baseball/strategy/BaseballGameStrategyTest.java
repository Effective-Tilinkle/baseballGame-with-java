package game.baseball.strategy;

import game.baseball.domain.Baseball;
import game.baseball.message.BaseballGameMessage;
import game.baseball.rule.BaseballGameRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BaseballGameStrategyTest {

    @DisplayName("값이 모두 맞는 경우 테스트")
    @Test
    void judgeTest1(){

        Baseball baseball = spy(Baseball.from(BaseballGameRule.BASIC));

        when(baseball.getInput()).thenReturn("123");
        when(baseball.getTarget()).thenReturn("123");

        BaseballGameStrategy baseballGameStrategy = BaseballGameStrategy.from(baseball);
        baseballGameStrategy.judge();

        StringBuilder message = new StringBuilder();
        message.append(BaseballGameMessage.STRIKE.getSentence(3));
        message.append(System.lineSeparator()).append(BaseballGameMessage.FIN.getSentence(3));

        assertEquals(baseball.toString(), message.toString());
    }

    @DisplayName("값이 1개만 맞고, 나머지는 순서가 다른 경우 테스트")
    @Test
    void judgeTest2(){

        Baseball baseball = spy(Baseball.from(BaseballGameRule.BASIC));

        when(baseball.getInput()).thenReturn("123");
        when(baseball.getTarget()).thenReturn("132");

        BaseballGameStrategy baseballGameStrategy = BaseballGameStrategy.from(baseball);
        baseballGameStrategy.judge();

        StringBuilder message = new StringBuilder();
        message.append(BaseballGameMessage.STRIKE.getSentence(1));
        message.append(BaseballGameMessage.BALL.getSentence(2));

        assertEquals(baseball.toString(), message.toString());
    }
}