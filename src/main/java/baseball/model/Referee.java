package baseball.model;

import baseball.validate.BaseballNumbers;

public class Referee {
    private final int THREE_DIGIT_NUMBER = 3;
    private int strikeCountNumber = 0;
    private int ballCountNumber = 0;

    public void compare(BaseballNumbers computer, BaseballNumbers user) {
        countBall(computer, user);
        countStrike(computer, user);
    }

    public int getBall() {
        return ballCountNumber;
    }

    public int getStrike() {
        return strikeCountNumber;
    }

    private int countBall(BaseballNumbers computer, BaseballNumbers user) {
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

    private int countStrike(BaseballNumbers computer, BaseballNumbers user) {
        for (int i = 0; i < THREE_DIGIT_NUMBER; i++) {
            if (computer.getNumbers().get(i).getNumber() == user.getNumbers().get(i).getNumber()) {
                strikeCountNumber++;
            }
        }
        return strikeCountNumber;
    }
}