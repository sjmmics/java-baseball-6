package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public static final int MIN_BALL_NUMBER = 1;

    public final static int MAX_BALL_NUMBER = 9;

    public final static int BALL_COUNT = 3;

    private final static String BLANK = " ";

    private final List<Integer> balls;

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    public static Balls getOpponents() {
        Set<Integer> ballsNotDuplicate = new LinkedHashSet<>();
        while (ballsNotDuplicate.size() < 3) {
            int ball = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
            ballsNotDuplicate.add(ball);
        }
        List<Integer> balls = new ArrayList<>(ballsNotDuplicate);
        return new Balls(balls);
    }

    public static Balls getFromUserInput(String line) {
        validateFormat(line);
        validateContent(line);
        String[] lineSplit = line.split("");
        List<Integer> balls = Arrays.stream(lineSplit)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        return new Balls(balls);
    }

    private static void validateFormat(String line) throws IllegalArgumentException {
        if (line.isEmpty() || line.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
        if (line.length() != BALL_COUNT) {
            throw new IllegalArgumentException();
        }
        if (doesContainsNotDigit(line)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean doesContainsNotDigit(String line) {
        for (int i = 0; i < line.length(); i++) {
            char ball = line.charAt(i);
            if (!Character.isDigit(ball)) {
                return true;
            }
        }
        return false;
    }

    private static void validateContent(String line) throws IllegalArgumentException {
        if (doesOutOfBallNumberRange(line)) {
            throw new IllegalArgumentException();
        }
        if (doesContainsDuplicateNumber(line)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean doesOutOfBallNumberRange(String line) {
        String[] lineSplit = line.split("");
        for (int i = 0; i < line.length(); i++) {
            int ball = Integer.parseInt(lineSplit[i]);
            if (ball < MIN_BALL_NUMBER|| MAX_BALL_NUMBER < ball) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesContainsDuplicateNumber(String line) {
        String[] lineSplit = line.split("");
        List<Integer> ballsMayDuplicate = Arrays.stream(lineSplit)
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
        Set<Integer> ballsNotDuplicate = new HashSet<>(ballsMayDuplicate);
        return ballsMayDuplicate.size() != ballsNotDuplicate.size();
    }

    public int getFromIndex(int index) {
        return balls.get(index);
    }

    public boolean contains(int userBall) {
        return balls.contains(userBall);
    }

}
