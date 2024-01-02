package baseball.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {
    @ParameterizedTest
    @MethodSource
    @DisplayName("중복 값이 있는지 확인 후 중복 값이 있으면 IllegalArgumentException 예외 발생")
    void validateSize(List<Integer> number) {
        //given
        //when
        List<Integer> numbers = new ArrayList<>(number);

        //then
        assertThatThrownBy(() -> new BaseballNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validateSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 2)),
                Arguments.of(Arrays.asList(1, 2, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("3자리 숫자가 아니면 IllegalArgumentException 예외 발생")
    void validateDuplication(List<Integer> number) {
        //given
        //when
        List<Integer> numbers = new ArrayList<>(number);

        //then
        assertThatThrownBy(() -> new BaseballNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> validateDuplication() {
        return Stream.of(
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3, 4))
        );
    }
}