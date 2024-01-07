package baseball.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PRINT_INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String PRINT_INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    Scanner scanner = new Scanner(System.in);

    public List<Integer> printInputNumbersMessage() {
        System.out.print(PRINT_INPUT_NUMBERS_MESSAGE);
        String[] strArrUserNumbers = scanner.next().split("");
        return Arrays.stream(strArrUserNumbers).map(value -> Integer.parseInt(value)).collect(Collectors.toList());
    }

    public boolean isPlaying() {
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