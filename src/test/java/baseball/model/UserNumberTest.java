package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserNumberTest {
    @Test
    @DisplayName("사용자가 입력한 숫자가 3자리인지 확인한다.")
    void validateSize() {
        //given
        UserNumbers userNumbers = new UserNumbers();

        String strUserNumbers = "123";
        String[] strArrUserNumber = strUserNumbers.split("");

        //when
        //then
        Assertions.assertThat(userNumbers.convertToBaseballNumber(strArrUserNumber).getNumbers().size()).isEqualTo(3);
    }
}