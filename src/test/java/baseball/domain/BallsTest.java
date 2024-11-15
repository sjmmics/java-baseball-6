package baseball.domain;

import baseball.model.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallsTest {

    @ParameterizedTest
    @ValueSource(strings = {"111", "1234", "012", "1,2,3", "1 2 3", "", "\n", "-123"})
    @DisplayName("잘못된 입력값 예외 호출 테스트")
    void invalidInputExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> Balls.getFromUserInput(input));
    }

    @Test
    @DisplayName("특정 숫자 포함 여부 테스트")
    void containsBallTest() {
        Balls balls = new Balls(List.of(1, 2, 3));
        assertTrue(balls.contains(1));
        assertFalse(balls.contains(9));
    }

    @Test
    @DisplayName("인덱스로 공 숫자 가져오기 테스트")
    void getBallAtIndex() {
        Balls balls = new Balls(List.of(1, 2, 3));
        for (int i = 0; i < 3; i++) {
            assertEquals(balls.getFromIndex(i), i + 1);
        }
    }

}
