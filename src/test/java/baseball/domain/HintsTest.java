package baseball.domain;

import baseball.model.Hint;
import baseball.model.Hints;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HintsTest {

    @ParameterizedTest
    @MethodSource("userBallAndOpponentBallAndKindOfHint")
    @DisplayName("힌트 불러오기 테스트")
    void getHintTest(int userBall, int opponentBall, boolean containsBall, Hint expectdHint) {
        Hint hint = Hint.getOfUserOpponentContainsBall(userBall, opponentBall, containsBall);

        assertEquals(hint, expectdHint);
    }

    static Stream<Arguments> userBallAndOpponentBallAndKindOfHint() {
        return Stream.of(
                Arguments.arguments(1, 1, true, Hint.STRIKE),
                Arguments.arguments(1, 1, true, Hint.STRIKE),
                Arguments.arguments(1, 2, true, Hint.BALL),
                Arguments.arguments(1, 2, false, Hint.NOTHING)
        );
    }

    @ParameterizedTest
    @MethodSource("hintsAndClear")
    @DisplayName("게임 종료 테스트")
    void doesClearTest(Map<Hint, Integer> hintsMap, boolean clear) {
        Hints hints = new Hints(hintsMap);
        assertEquals(hints.doesClear(), clear);
    }

    static Stream<Arguments> hintsAndClear() {
        return Stream.of(
                Arguments.arguments(Map.of(Hint.STRIKE, 3), true),

                Arguments.arguments(Map.of(Hint.STRIKE, 2, Hint.BALL, 1), false),
                Arguments.arguments(Map.of(Hint.STRIKE, 2, Hint.NOTHING, 1), false),
                Arguments.arguments(Map.of(Hint.STRIKE, 1, Hint.BALL, 2), false),
                Arguments.arguments(Map.of(Hint.STRIKE, 1, Hint.NOTHING, 2), false),
                Arguments.arguments(Map.of(Hint.STRIKE, 1, Hint.BALL, 1,
                        Hint.NOTHING, 2), false),

                Arguments.arguments(Map.of(Hint.BALL, 3), false),
                Arguments.arguments(Map.of(Hint.BALL, 2, Hint.NOTHING, 1), false),
                Arguments.arguments(Map.of(Hint.BALL, 1, Hint.NOTHING, 2), false),

                Arguments.arguments(Map.of(Hint.NOTHING, 3), false)
        );
    }

}
