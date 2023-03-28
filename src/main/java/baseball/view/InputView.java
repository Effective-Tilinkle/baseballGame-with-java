package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요.";
    private static final String TRY_AGAIN = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String DELIMITER = "";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() { }

    public static List<Integer> enterNumber() {
        System.out.println(ENTER_NUMBER_MESSAGE);
        return toList(scanner.nextLine());
    }

    public static int enterTryAgain() {
        System.out.println(TRY_AGAIN);
        return Integer.parseInt(scanner.nextLine());
    }

    private static List<Integer> toList(String inputNumber) {
        return Arrays.stream(inputNumber.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
