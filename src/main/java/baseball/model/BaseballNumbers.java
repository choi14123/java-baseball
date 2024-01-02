package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumbers {
    private final int BASEBALL_NUMBER_SIZE = 3;
    private List<BaseballNumber> numbers = new ArrayList<>();

    public BaseballNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        List<BaseballNumber> inputtedNumbers = convertToBaseballNumber(numbers);
        this.numbers = inputtedNumbers;
    }

    public List<BaseballNumber> convertToBaseballNumber(List<Integer> numbers) {
        List<BaseballNumber> inputtedNumbers = new ArrayList<>();

        for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
            int num = numbers.get(i);
            BaseballNumber baseballNumber = new BaseballNumber(num);
            inputtedNumbers.add(baseballNumber);
        }
        return inputtedNumbers;
    }

    private void validateDuplication(List<Integer> numbers) {
        List<Integer> list = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        if (numbers.size() != list.size()) {
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 3자리를 입력해야 합니다.");
        }
    }

    public List<BaseballNumber> getNumbers() {
        return numbers;
    }
}