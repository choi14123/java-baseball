package baseball.model;

import baseball.model.baseballnumber.BaseballNumber;
import baseball.model.baseballnumber.BaseballNumbers;
import java.util.stream.IntStream;

public class Referee {
    private static final int START = 0;
    private static final int NUMBER_LENGTH = 3;

    public int strikeCount(BaseballNumbers computers, BaseballNumbers users) {
        return (int) IntStream.range(START, NUMBER_LENGTH)
                .filter(index -> computers.getBaseballNumberValue(index) == users.getBaseballNumberValue(index))
                .count();
    }

    public int ballCount(BaseballNumbers computers, BaseballNumbers users) {
        int ballCount = (int) computers.getNumbers()
                .stream()
                .filter(computerNumber -> compare(computerNumber, users))
                .count();
        return ballCount - strikeCount(computers, users);
    }

    private boolean compare(BaseballNumber computerNumber, BaseballNumbers userNumbers) {
        return userNumbers.
                getNumbers().
                contains(computerNumber);
    }
}