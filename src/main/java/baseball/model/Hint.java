package baseball.model;

public enum Hint {

    BALL("볼" ),

    STRIKE("스트라이크" ),

    NOTHING("낫싱");

    private final String name;

    Hint(String name) {
        this.name = name;
    }

    public static Hint getOfUserOpponentContainsBall(int userBall, int opponentBall, boolean containsBall) {
        if (userBall == opponentBall) {
            return STRIKE;
        }
        if (containsBall) {
            return BALL;
        }
        return NOTHING;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
