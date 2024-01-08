package baseball.model.baseballnumber;

public class BaseballNumber {
    private static final int MIN_BASEBALL_NUMBER_SIZE = 1;
    private static final int MAX_BASEBALL_NUMBER_SIZE = 9;
    private static final String VALIDATE_NUMBER_SIZE_EXCEPTION_MESSAGE = "1부터 9까지의 숫자만 입력해야 합니다.";

    private final int number;

    public BaseballNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_BASEBALL_NUMBER_SIZE || MAX_BASEBALL_NUMBER_SIZE < number) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_SIZE_EXCEPTION_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}