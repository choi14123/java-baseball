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
            BaseballNumbers userNumbersList = new BaseballNumbers(inputView.printNumbersMessage());
            int ballCountNumber = referee.ballCount(computerNumbersList, userNumbersList);
            int strikeCountNumber = referee.strikeCount(computerNumbersList, userNumbersList);
            printResult(ballCountNumber, strikeCountNumber);
            if (strikeCountNumber == THREE_STRIKE_CONDITION) {
                outputView.printInputGameRestartMessage();
                isPlaying = inputView.isPlaying();
                randomNumbers = new RandomNumbersFactory();
                randomNumbers.create();
            }
            inputView = new InputView();
            referee = new Referee();
        }
    }

    private void printResult(int countBall, int countStrike) {
        ballAndStrikeNothing(countBall, countStrike);
        ballOrStrike(countBall, countStrike);
        threeStrike(countStrike);
    }

    private void ballAndStrikeNothing(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            outputView.printNothing();
        }
    }

    private void ballOrStrike(int ballCount, int strikeCount) {
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

    private void threeStrike(int strikeCount) {
        if (strikeCount == THREE_STRIKE_CONDITION) {
            outputView.printThreeStrike();
        }
    }
}