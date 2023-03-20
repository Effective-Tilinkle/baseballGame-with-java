package game.baseball.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameRuleTest {

    @DisplayName("게임 룰 준수 여부 테스트")
    @ParameterizedTest
    @CsvSource({
            "123, true",
            "a23, false",
            "112, false"
    })
    void isComplyWithTest(String input, boolean expected){
       boolean actual = BaseballGameRule.BASIC.isComplyWith(input);
        assertEquals(expected, actual);
    }

}