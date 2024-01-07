package baseball.model.baseballnumber;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNumberTest {
    @Test
    @DisplayName("사용자가 입력한 숫자가 3자리인지 확인한다.")
    void validateLength() {
        //given
        UserNumbers userNumbers = new UserNumbers();

        String strUserNumbers = "123";
        String[] strArrUserNumber = strUserNumbers.split("");

        //when
        //then
        Assertions.assertThat(userNumbers.convertToBaseballNumber(strArrUserNumber).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자가 입력한 숫자가 3자리가 아닐시 IllegalArgumentException 예외 발생.")
    void validateLengthThrowException() {
        //given
        UserNumbers userNumbers = new UserNumbers();

        String strUserNumbers = "12";
        String[] strArrUserNumber = strUserNumbers.split("");

        //when
        //then
        assertThatThrownBy(() -> userNumbers.convertToBaseballNumber(strArrUserNumber)).isInstanceOf(IllegalArgumentException.class).hasMessage("숫자 3자리를 입력해야 합니다.");
    }
}