package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Balls {

    public static final int MIN_BALL_NUMBER = 1;

    public final static int MAX_BALL_NUMBER = 9;

    public final static int BALL_COUNT = 3;

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

}
