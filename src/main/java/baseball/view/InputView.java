package baseball.view;

import java.util.Scanner;

public class InputView {
    private final String PRINT_INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private final String PRINT_INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    Scanner scanner = new Scanner(System.in);

    public String[] printInputNumbersMessage() {
        System.out.print(PRINT_INPUT_NUMBERS_MESSAGE);
        String[] strArrUserNumbers = scanner.next().split("");
        return strArrUserNumbers;
    }

    public boolean setGame() {
        int number = scanner.nextInt();
        if (number != 1){
            return false;
        }
        return true;
    }

    public void printInputGameRestartMessage() {
        System.out.print(PRINT_INPUT_GAME_RESTART_MESSAGE);
    }
}