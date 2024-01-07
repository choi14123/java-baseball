package baseball.model;

import baseball.model.baseballnumber.BaseballNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
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
        List<Integer> computerList = Arrays.asList(computers.getBaseballNumberValue(0), computers.getBaseballNumberValue(1), computers.getBaseballNumberValue(2));
        List<Integer> uesrList = Arrays.asList(users.getBaseballNumberValue(0), users.getBaseballNumberValue(1), users.getBaseballNumberValue(2));

        return (int) (computerList.stream()
                .filter(randomNumber -> uesrList.stream().anyMatch(Predicate.isEqual(randomNumber)))
                .count()
                - strikeCount(users, computers));
    }
}