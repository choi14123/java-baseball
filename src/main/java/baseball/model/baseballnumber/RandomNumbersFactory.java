package baseball.model.baseballnumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumbersFactory {
    private static final int COMPUTER_NUMBER_SIZE = 3;
    private static final int MAX_RANDOM_NUMBER_SIZE = 9;

    private Random random = new Random();
    private List<Integer> computerNumberList = new ArrayList<>();

    public List<Integer> create() {
        while (computerNumberList.size() < COMPUTER_NUMBER_SIZE) {
            int number = random.nextInt(MAX_RANDOM_NUMBER_SIZE) + 1;
            if (!computerNumberList.contains(number)) {
                computerNumberList.add(number);
            }
        }
        return computerNumberList;
    }
}