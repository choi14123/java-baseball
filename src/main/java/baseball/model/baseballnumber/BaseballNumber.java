package baseball.model.baseballnumber;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}