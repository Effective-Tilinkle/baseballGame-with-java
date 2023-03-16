package game.rule;

@FunctionalInterface
public interface GameRule<P> {
	boolean isComplyWith(P param);
}
