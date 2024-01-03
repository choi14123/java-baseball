package baseball.controller;

import baseball.model.baseballnumber.RandomNumbers;
import baseball.model.Referee;
import baseball.model.baseballnumber.UserNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final int THREE_STRIKE_CONDITION = 3;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomNumbers randomNumbers = new RandomNumbers();
    UserNumbers userNumbers = new UserNumbers();
    Referee referee = new Referee();

    public void start() {
        boolean setGame = true;

        outputView.printStartGameMessage();
        while (setGame) {
            referee.compare(randomNumbers.set(randomNumbers.create()), userNumbers.convertToBaseballNumber(inputView.printInputNumbersMessage()));
            outputView.printRefereeMessage(referee.getBall(), referee.getStrike());
            if (referee.getStrike() == THREE_STRIKE_CONDITION) {
                inputView.printInputGameRestartMessage();
                setGame = inputView.setGame();
                randomNumbers = new RandomNumbers();
                randomNumbers.create();
            }
            userNumbers = new UserNumbers();
            referee = new Referee();
        }
    }
}