package baseball.model.baseballnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballNumbersTest {

    @Test
    @DisplayName("convertToBaseballNumber를 실행하면 3개의 숫자가 저장된다.")
    void convertToBaseballNumberTest() {
        //given
        List<Integer> numbers = Arrays.asList(7, 8, 9);

        //when
        //then
        assertThat(new BaseballNumbers(numbers).getNumbers().size()).isEqualTo(3);
    }

    private static Stream<Arguments> validateSizeTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3, 4))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("3자리 숫자가 아니면 IllegalArgumentException 예외 발생")
    void validateSizeTest(List<Integer> number) {
        //given
        //when
        List<Integer> numbers = new ArrayList<>(number);

        //then
        assertThatThrownBy(
                () -> new BaseballNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리의 숫자를 입력해야합니다.");
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("중복 값이 있는지 확인 후 중복 값이 있으면 IllegalArgumentException 예외 발생")
    void validateDuplicationTest(List<Integer> number) {
        //given
        //when
        List<Integer> numbers = new ArrayList<>(number);

        //then
        assertThatThrownBy(
                () -> new BaseballNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 입력 되었습니다");
    }

    private static Stream<Arguments> validateDuplicationTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 1, 1)),
                Arguments.of(Arrays.asList(1, 1, 2)),
                Arguments.of(Arrays.asList(1, 2, 2)),
                Arguments.of(Arrays.asList(2, 2, 2))
        );
    }
}