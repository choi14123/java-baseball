package baseball.model;

import baseball.model.validate.BaseballNumbers;

import java.util.ArrayList;
import java.util.List;

public class UserNumbers {
    private final int USER_INPUT_NUMBERS_LENGTH = 3;
    private List<Integer> userNumbersList = new ArrayList<>();

    public BaseballNumbers convertToBaseballNumber(String[] strArr) {
        validateSize(strArr);
        for (int i = 0; i < USER_INPUT_NUMBERS_LENGTH; i++) {
            userNumbersList.add(Integer.valueOf(strArr[i]));
        }
        BaseballNumbers userNumbers = new BaseballNumbers(userNumbersList);
        return userNumbers;
    }

    private void validateSize(String[] strArr) {
        if (strArr.length != USER_INPUT_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("숫자 3자리를 입력해야 합니다.");
        }
    }
}