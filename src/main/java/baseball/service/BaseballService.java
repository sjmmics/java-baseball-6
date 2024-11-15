package baseball.service;

import baseball.model.Balls;
import baseball.model.Hints;

public class BaseballService {

    public Hints getHints(Balls userBalls, Balls opponentsBalls) {
        return Hints.getOfUserAndOpponentBalls(userBalls, opponentsBalls);
    }
}
