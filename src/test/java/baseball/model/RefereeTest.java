package baseball.model;

import baseball.model.baseballnumber.BaseballNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @Test
    @DisplayName("컴퓨터의 숫자와 사용자가 입력한 숫자를 비교하여 볼 갯수를 반환한다.")
    void ballCountTest() {
        //given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> userNumbers = Arrays.asList(1, 3, 2);

        //when
        BaseballNumbers computerBaseballNumbers = new BaseballNumbers(computerNumbers);
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(userNumbers);

        Referee referee = new Referee();

        //then
        Assertions.assertThat(referee.ballCount(computerBaseballNumbers, userBaseballNumbers)).isEqualTo(2);
    }

    @Test
    @DisplayName("컴퓨터의 숫자와 사용자가 입력한 숫자를 비교하여 스트라이크 갯수를 반환한다.")
    void strikeCountTest() {
        //given
        List<Integer> computerNumbers = Arrays.asList(1, 2, 3);
        List<Integer> userNumbers = Arrays.asList(1, 3, 2);

        //when
        BaseballNumbers computerBaseballNumbers = new BaseballNumbers(computerNumbers);
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(userNumbers);

        Referee referee = new Referee();

        //then
        Assertions.assertThat(referee.strikeCount(computerBaseballNumbers, userBaseballNumbers)).isEqualTo(1);
    }
}