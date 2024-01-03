package baseball.model.baseballnumber;

import baseball.model.baseballnumber.BaseballNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    @DisplayName("숫자 야구 넘버는 1 ~ 9 까지의 숫자만 허용한다. 이외의 숫자가 들어오면 IllegalArgumentException 예외 발생")
    void validateNumber(int input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new BaseballNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }
}