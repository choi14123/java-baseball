package baseball.controller;

import baseball.model.Referee;
import baseball.model.baseballnumber.BaseballNumbers;
import baseball.model.baseballnumber.RandomNumbersFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private static final int THREE_STRIKE_CONDITION = 3;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private RandomNumbersFactory randomNumbers = new RandomNumbersFactory();
    private Referee referee = new Referee();

    public void start() {
        boolean isPlaying = true;
        outputView.printStartGameMessage();
        while (isPlaying) {
            BaseballNumbers computerNumbersList = new BaseballNumbers(randomNumbers.create());
            BaseballNumbers userNumbersList = new BaseballNumbers(inputView.printInputNumbersMessage());
            int countBall = referee.countBall(computerNumbersList, userNumbersList);
            int countStrike = referee.countStrike(computerNumbersList, userNumbersList);
            printResult(countBall, countStrike);
            if (countStrike == THREE_STRIKE_CONDITION) {
                inputView.printInputGameRestartMessage();
                isPlaying = inputView.isPlaying();
                randomNumbers = new RandomNumbersFactory();
                randomNumbers.create();
            }
            inputView = new InputView();
            referee = new Referee();
        }
    }

    private void printResult(int countBall, int countStrike) {
        isNothing(countBall, countStrike);
        hasBallOrStrike(countBall, countStrike);
        isThreeStrike(countStrike);
    }

    private void isNothing(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            outputView.printNothing();
        }
    }

    private void hasBallOrStrike(int ballCount, int strikeCount) {
        if (ballCount > 0 && strikeCount == 0) {
            outputView.printBall(ballCount);
        }
        if (strikeCount > 0 && ballCount == 0) {
            outputView.printStrike(strikeCount);
        }
        if (ballCount > 0 && strikeCount > 0) {
            outputView.printBallAndStrike(ballCount, strikeCount);
        }
    }

    private void isThreeStrike(int strikeCount) {
        if (strikeCount == 3) {
            outputView.printThreeStrike();
        }
    }
}