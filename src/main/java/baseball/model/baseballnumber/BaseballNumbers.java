package baseball.model.baseballnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbers {
    private static final String VALIDATE_NUMBER_LENGTH_EXCEPTION_MESSAGE = "3자리의 숫자를 입력해야합니다.";
    private static final String VALIDATE_DUPLICATION_EXCEPTION_MESSAGE = "중복된 숫자가 입력 되었습니다";

    private final int baseballNumberSize = 3;
    private List<BaseballNumber> numbers = new ArrayList<>();

    public BaseballNumbers(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        List<BaseballNumber> convertToBaseballNumbers = convertToBaseballNumber(numbers);
        this.numbers = convertToBaseballNumbers;
    }

    private List<BaseballNumber> convertToBaseballNumber(List<Integer> numbers) {
        List<BaseballNumber> convertToBaseballNumber = numbers.stream()
                .map(number -> new BaseballNumber(number))
                .collect(Collectors.toList());
        return convertToBaseballNumber;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != baseballNumberSize) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbers.size() != list.size()) {
            throw new IllegalArgumentException(VALIDATE_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    public List<BaseballNumber> getNumbers() {
        return numbers;
    }

    public int getBaseballNumberValue(int index) {
        return numbers.get(index).getNumber();
    }
}