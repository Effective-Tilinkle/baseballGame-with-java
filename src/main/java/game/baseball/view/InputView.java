package game.baseball.view;

import java.util.Scanner;

import game.baseball.message.BaseballGameMessage;

public class InputView {

	private static Scanner scanner = new Scanner(System.in);

	public static int input() {
		System.out.print("숫자를 입력해주세요 : ");
		return Integer.parseInt(scanner.nextLine());
	}
}
