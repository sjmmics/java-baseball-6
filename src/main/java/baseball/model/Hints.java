package baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static baseball.model.Balls.BALL_COUNT;

public class Hints {

    private final Map<Hint, Integer> hints;

    public Hints(Map<Hint, Integer> hints) {
        this.hints = hints;
    }

    public static Hints getOfUserAndOpponentBalls(Balls userBalls, Balls opponentBalls) {
        Map<Hint, Integer> hints = new TreeMap<>();
        for (int i = 0; i < BALL_COUNT; i++) {
            int userBall = userBalls.getFromIndex(i);
            int opponentBall = opponentBalls.getFromIndex(i);
            boolean containsBall = opponentBalls.contains(userBall);
            Hint hint = Hint.getOfUserOpponentContainsBall(userBall, opponentBall, containsBall);
            hints.put(hint, hints.getOrDefault(hint, 0) + 1);
        }
        return new Hints(hints);
    }

    public boolean doesClear() {
        int strikeCount = hints.getOrDefault(Hint.STRIKE, 0);
        return strikeCount == BALL_COUNT;
    }

    @Override
    public String toString() {
        List<String> strings = new ArrayList<>();
        int ballCount = hints.getOrDefault(Hint.BALL, 0);
        int strikeCount = hints.getOrDefault(Hint.STRIKE, 0);
        if (ballCount != 0) {
            strings.add(ballCount + Hint.BALL.toString());
        }
        if (strikeCount != 0) {
            strings.add(strikeCount + Hint.STRIKE.toString());
        }
        if (strings.isEmpty()) {
            strings.add(Hint.NOTHING.toString());
        }
        return String.join(" ", strings);
    }

}
