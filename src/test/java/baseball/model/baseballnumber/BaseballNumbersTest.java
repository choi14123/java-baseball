package baseball.model.baseballnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballNumbersTest {

    private static Stream<Arguments> notThreeSizeNumbersProvide() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4))
        );
    }

    private static Stream<Arguments> duplicationNumbersProvide() {
        return Stream.of(Arguments.of(List.of(1, 1, 1)),
                Arguments.of(List.of(1, 2, 1)),
                Arguments.of(List.of(1, 2, 2)));
    }

    @Test
    @DisplayName("convertToBaseballNumber를 실행하면 3개의 숫자가 저장되는지 확인한다.")
    void convertToBaseballNumberTest() {
        //given
        List<Integer> numbers = List.of(7, 8, 9);
        //when, then
        assertThat(new BaseballNumbers(numbers).getNumbers().size()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("notThreeSizeNumbersProvide")
    @DisplayName("객체를 생성할 때, 3자리 숫자가 아니면 IllegalArgumentException 예외 발생")
    void validateSizeTest(List<Integer> notThreeSizeNumbersProvide) {
        //when, then
        assertThatThrownBy(() -> new BaseballNumbers(notThreeSizeNumbersProvide))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 숫자를 입력해야합니다.");
    }

    @ParameterizedTest
    @MethodSource("duplicationNumbersProvide")
    @DisplayName("객체를 생성 할 때, 중복 값이 있으면 IllegalArgumentException 예외 발생")
    void validateDuplicationTest(List<Integer> duplicationNumbers) {
        //when, then
        assertThatThrownBy(() -> new BaseballNumbers(duplicationNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 입력 되었습니다");
    }
}