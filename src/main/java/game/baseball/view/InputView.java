package game.baseball.view;

import java.util.Scanner;

import game.baseball.message.BaseballGameMessage;

public class InputView {

	private static Scanner scanner = new Scanner(System.in);

	public static String input(BaseballGameMessage baseballGameMessage) {
		System.out.print(baseballGameMessage.getSentence());
		return scanner.nextLine();
	}
}
