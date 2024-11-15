package baseball.domain;

import baseball.model.Hint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HintTest {

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

}
