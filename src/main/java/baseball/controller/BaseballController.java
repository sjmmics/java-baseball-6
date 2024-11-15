package baseball.controller;

import baseball.model.Balls;
import baseball.model.Hints;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;

    private final OutputView outputView;

    private final BaseballService service;

    public BaseballController(InputView inputView, OutputView outputView,
                              BaseballService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        inputView.printStart();
        do {
            Balls opponentsBalls = Balls.getOpponents();
            boolean clear = false;
            while (!clear) {
                clear = playGame(opponentsBalls);
            }
        } while (doesContinue());
    }

    private boolean playGame(Balls opponentsBalls) {
        String line = inputView.getUserBall();
        Balls userBalls = Balls.getFromUserInput(line);
        Hints hints = service.getHints(userBalls, opponentsBalls);
        outputView.printHints(hints);
        return hints.doesClear();
    }

    private boolean doesContinue() {
        String playAgainInput = inputView.getPlayAgain();
        PlayAgain playAgain = new PlayAgain(playAgainInput);
        return playAgain.isTrue();
    }

}
