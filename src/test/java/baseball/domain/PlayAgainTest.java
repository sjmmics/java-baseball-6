package baseball.domain;

import baseball.controller.PlayAgain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayAgainTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "", "y", "n", "예", "아니오"})
    @DisplayName("잘못된 입력 값 예외 호출 테스트")
    void illegalArgumentExceptionTest(String input) {
        assertThrows(IllegalArgumentException.class,
                () -> new PlayAgain(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    @DisplayName("올바른 입력 값 예외 호출 테스트")
    void legalArgumentExceptionTest(String input) {
        assertDoesNotThrow(() -> new PlayAgain(input));
    }

    @Test
    @DisplayName("입력값 1일 때 true 반환")
    void doesContinueGame() {
        PlayAgain playAgain = new PlayAgain("1");
        assertTrue(playAgain.isTrue());
    }

    @Test
    @DisplayName("입력값 2일 때 false 반환")
    void doesNotContinueGame() {
        PlayAgain playAgain = new PlayAgain("2");
        assertFalse(playAgain.isTrue());
    }

}
