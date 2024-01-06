package baseball.controller;

import baseball.model.Referee;
import baseball.model.baseballnumber.BaseballNumbers;
import baseball.model.baseballnumber.RandomNumbersFactory;
import baseball.model.baseballnumber.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private static final int THREE_STRIKE_CONDITION = 3;

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private RandomNumbersFactory randomNumbers = new RandomNumbersFactory();
    private UserNumbers userNumbers = new UserNumbers();
    private Referee referee = new Referee();

    public void start() {
        boolean setGame = true;
        outputView.printStartGameMessage();
        while (setGame) {
            BaseballNumbers computerNumbersList = new BaseballNumbers(randomNumbers.create());
            BaseballNumbers userNumbersList = new BaseballNumbers(userNumbers.convertToBaseballNumber(inputView.printInputNumbersMessage()));
            int countBall = referee.countBall(computerNumbersList, userNumbersList);
            int countStrike = referee.countStrike(computerNumbersList, userNumbersList);
            outputView.printRefereeMessage(countBall, countStrike);
            if (countStrike == THREE_STRIKE_CONDITION) {
                inputView.printInputGameRestartMessage();
                setGame = inputView.setGame();
                randomNumbers = new RandomNumbersFactory();
                randomNumbers.create();
            }
            userNumbers = new UserNumbers();
            referee = new Referee();
        }
    }
}