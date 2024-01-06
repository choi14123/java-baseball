package baseball.model.baseballnumber;

import java.util.ArrayList;
import java.util.List;


public class UserNumbers {
    private final int userInputNumbersLength = 3;
    private List<Integer> userNumbersList = new ArrayList<>();

    public List<Integer> convertToBaseballNumber(String[] strArr) {
        validateSize(strArr);
        for (int i = 0; i < userInputNumbersLength; i++) {
            userNumbersList.add(Integer.valueOf(strArr[i]));
        }
        return userNumbersList;
    }

    private void validateSize(String[] strArr) {
        if (strArr.length != userInputNumbersLength) {
            throw new IllegalArgumentException("숫자 3자리를 입력해야 합니다.");
        }
    }
}