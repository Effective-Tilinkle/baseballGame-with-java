package game.baseball.validator;

import game.rule.GameRule;
import game.validator.GameValidator;

public class BaseballGameInputValidator implements GameValidator {

	private String param;
	private GameRule gameRule;

	private BaseballGameInputValidator(String param, GameRule gameRule) {
		this.param = param;
		this.gameRule = gameRule;
	}

	public static BaseballGameInputValidator of(String param, GameRule gameRule) {
		return new BaseballGameInputValidator(param, gameRule);
	}

	@Override
	public void validate() throws Exception {
		boolean isComplyWith = gameRule.isComplyWith(param);
		if (!isComplyWith) {
			throw new IllegalArgumentException("입력 값이 적절하지 않습니다.");
		}
	}
}
