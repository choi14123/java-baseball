package baseball.model;

public class BaseballNumber {
    private final int MIN_BASEBALL_NUMBER_SIZE = 1;
    private final int MAX_BASEBALL_NUMBER_SIZE = 9;
    private int number;

    public BaseballNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < MIN_BASEBALL_NUMBER_SIZE || MAX_BASEBALL_NUMBER_SIZE < number) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해야 합니다.");
        }
    }
}