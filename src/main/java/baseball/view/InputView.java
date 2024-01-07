package baseball.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PRINT_INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    Scanner scanner = new Scanner(System.in);

    public List<Integer> printNumbersMessage() {
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
}