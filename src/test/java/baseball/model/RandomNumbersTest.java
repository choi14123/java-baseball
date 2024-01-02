package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RandomNumbersTest {
    @Test
    @DisplayName("랜덤한 숫자 3개 생성한다.")
    void createRandomNumbersSize() {
        //given
        RandomNumbers randomNumbers = new RandomNumbers();

        //when
        int randomNumberSize = randomNumbers.set(randomNumbers.create()).getNumbers().size();

        //then
        Assertions.assertThat(randomNumberSize).isEqualTo(3);
    }
}