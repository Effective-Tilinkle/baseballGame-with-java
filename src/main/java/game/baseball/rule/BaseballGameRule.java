package game.baseball.rule;

import java.util.HashMap;
import java.util.regex.Pattern;

public enum BaseballGameRule {

    BASIC("^[1-9]*$", 3);

    String regex;
    int range;

    BaseballGameRule(String regex, int range) {
        this.regex = regex;
        this.range = range;
    }

    public boolean isComplyWith(String param) {
        return Pattern.matches(regex, param) && param.length() == range && !existDuplicateCharacter(param);
    }

    private boolean existDuplicateCharacter(String param) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char ch : param.toCharArray()) {
            hashMap.put(ch, 1);
        }

        return hashMap.size() < param.length();
    }

    public int getRange() {
        return this.range;
    }
}
