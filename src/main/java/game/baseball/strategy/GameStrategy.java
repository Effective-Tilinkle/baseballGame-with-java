package game.baseball.strategy;

@FunctionalInterface
public interface GameStrategy<P, R> {
	R judge(P param);
}
