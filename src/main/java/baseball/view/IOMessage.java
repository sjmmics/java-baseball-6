package baseball.view;

public enum IOMessage {

    GAME_START("숫자 야구 게임을 시작합니다."),

    ENTER_BALL("숫자를 입력해주세요 : "),

    CLEAR_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),

    PLAY_ANOTHER("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    IOMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
