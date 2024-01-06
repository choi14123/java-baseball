package baseball.model;

import baseball.model.baseballnumber.BaseballNumbers;

import java.util.stream.IntStream;


public class Referee {

    private static final int START = 0;
    private static final int NUMBER_LENGTH = 3;
    private static final int THREE_DIGIT_NUMBER = 3;

    public int countStrike(BaseballNumbers computer, BaseballNumbers user) {
        return (int) IntStream.range(START, NUMBER_LENGTH)
                .filter(num -> computer.getNumbers().get(num).getNumber() == user.getNumbers().get(num).getNumber())
                .count();
    }

    public int countBall(BaseballNumbers computer, BaseballNumbers user) {
        int ballCountNumber = 0;
        for (int i = 0; i < THREE_DIGIT_NUMBER; i++) {
            for (int j = 0; j < THREE_DIGIT_NUMBER; j++) {
                if (computer.getNumbers().get(i).getNumber() == user.getNumbers().get(j).getNumber()) {
                    if (i != j) {
                        ballCountNumber++;
                    }
                }
            }
        }
        return ballCountNumber;
    }
}