package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumbers {
    private final int COMPUTER_NUMBER_SIZE = 3;
    private final int MAX_RANDOM_NUMBER_SIZE = 9;
    private List<Integer> computerNumber = new ArrayList<>();
    private Random random = new Random();

    public List<Integer> create() {
        while (computerNumber.size() < COMPUTER_NUMBER_SIZE) {
            int number = random.nextInt(MAX_RANDOM_NUMBER_SIZE) + 1;
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }

    public BaseballNumbers set(List<Integer> numbers) {
        return new BaseballNumbers(numbers);
    }
}