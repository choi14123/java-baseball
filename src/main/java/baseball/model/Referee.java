package baseball.model;

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
        int ballCountNumber = 0;
        for (int i = 0; i < 3; i++) {
            if (computers.getBaseballNumberValue(0) == users.getBaseballNumberValue(i)) {
                ballCountNumber++;
            }
            if (computers.getBaseballNumberValue(1) == users.getBaseballNumberValue(i)) {
                ballCountNumber++;
            }
            if (computers.getBaseballNumberValue(2) == users.getBaseballNumberValue(i)) {
                ballCountNumber++;
            }
        }
        return ballCountNumber - strikeCount(computers, users);
    }
}