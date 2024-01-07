package baseball.model;

import baseball.model.baseballnumber.BaseballNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;


public class Referee {
    private static final int START = 0;
    private static final int NUMBER_LENGTH = 3;

    public int countStrike(BaseballNumbers computer, BaseballNumbers user) {
        return (int) IntStream.range(START, NUMBER_LENGTH)
                .filter(num -> computer.getNumbers().get(num).getNumber() == user.getNumbers().get(num).getNumber())
                .count();
    }

    public int countBall(BaseballNumbers computer, BaseballNumbers user) {
        List<Integer> computerList = Arrays.asList(computer.getNumbers().get(0).getNumber(), computer.getNumbers().get(1).getNumber(), computer.getNumbers().get(2).getNumber());
        List<Integer> userList = Arrays.asList(user.getNumbers().get(0).getNumber(), user.getNumbers().get(1).getNumber(), user.getNumbers().get(2).getNumber());

        return (int) (computerList.stream()
                .filter(com -> userList.stream().anyMatch(Predicate.isEqual(com)))
                .count()
                - countStrike(user, computer));
    }
}