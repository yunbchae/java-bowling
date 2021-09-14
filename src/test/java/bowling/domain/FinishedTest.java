package bowling.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class FinishedTest {

    @ParameterizedTest(name = "종료된 상태의 bowl 메서드 호출 시 예외가 발생한다.")
    @MethodSource("provideFinishedStates")
    public void cannotBowlOfFinishedState(Finished state) {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> state.bowl(PinCount.FIVE));
    }

    private static Stream<Arguments> provideFinishedStates() {
        return Stream.of(
                Arguments.arguments(Finished.strike()),
                Arguments.arguments(new Finished(PinCount.EIGHT, PinCount.TWO)),
                Arguments.arguments(new Finished(PinCount.EIGHT, PinCount.ZERO))
        );
    }
}