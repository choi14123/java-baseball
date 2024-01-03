package baseball.model;

import baseball.model.baseballnumber.BaseballNumbers;

public class Referee {
    private final int threeDigitNumber = 3;

    public int countBall(BaseballNumbers computer, BaseballNumbers user) {
        int ballCountNumber = 0;
        for (int i = 0; i < threeDigitNumber; i++) {
            for (int j = 0; j < threeDigitNumber; j++) {
                if (computer.getNumbers().get(i).getNumber() == user.getNumbers().get(j).getNumber()) {
                    if (i != j) {
                        ballCountNumber++;
                    }
                }
            }
        }
        return ballCountNumber;
    }

    public int countStrike(BaseballNumbers computer, BaseballNumbers user) {
        int strikeCountNumber = 0;
        for (int i = 0; i < threeDigitNumber; i++) {
            if (computer.getNumbers().get(i).getNumber() == user.getNumbers().get(i).getNumber()) {
                strikeCountNumber++;
            }
        }
        return strikeCountNumber;
    }
}