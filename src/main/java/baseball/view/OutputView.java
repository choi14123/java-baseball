package baseball.view;


public class OutputView {
    private static final String PRINT_START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String PRINT_INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printStartGameMessage() {
        System.out.println(PRINT_START_GAME_MESSAGE);
    }

    public void printInputGameRestartMessage() {
        System.out.print(PRINT_INPUT_GAME_RESTART_MESSAGE);
    }

    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printBall(int ballCount) {
        System.out.println(ballCount + "볼");
    }

    public void printStrike(int strikeCount) {
        System.out.println(strikeCount + "스트라이크");
    }

    public void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.println(ballCount + "볼" + " " + strikeCount + "스트라이크");
    }

    public void printThreeStrike() {
            System.out.println("3스트라이크" + "\n" +
                    "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}