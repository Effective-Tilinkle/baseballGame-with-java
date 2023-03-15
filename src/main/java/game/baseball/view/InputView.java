package game.baseball.view;

import java.util.Scanner;

public class InputView {

	private static Scanner scanner = new Scanner(System.in);

	public static String input() {
		System.out.print("숫자를 입력해주세요 : ");
		return scanner.nextLine();
	}
}
