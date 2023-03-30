package game.baseball.view;

import java.util.Scanner;

import game.baseball.message.BaseballGameMessage;

public class InputView {

	private static final int CONTINUE = 1;
	private static final int EXIT = 2;

	private static Scanner scanner = new Scanner(System.in);

	public static int inputNo() {
		System.out.print(BaseballGameMessage.INPUT_THE_baseballNo.getSentence());
		return Integer.parseInt(scanner.nextLine());
	}

	public static boolean inputWhetherToContinue() {
		System.out.println(BaseballGameMessage.CONTINUE.getSentence());
		int result = Integer.parseInt(scanner.nextLine());

		if (CONTINUE == result) {
			return true;
		}
		return false;
	}
}
