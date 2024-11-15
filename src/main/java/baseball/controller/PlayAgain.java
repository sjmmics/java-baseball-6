package baseball.controller;

public class PlayAgain {

    public static final String YES = "1";

    public static final String NO = "2";

    private final boolean decision;

    public PlayAgain(String line) {
        if (!line.equals(YES) && !line.equals(NO)) {
            throw new IllegalArgumentException();
        }
        this.decision = getDecision(line);
    }

    private boolean getDecision(String line) {
        return line.equals(YES);
    }

    public boolean isTrue() {
        return this.decision;
    }

}
