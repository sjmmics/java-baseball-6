package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void printStart() {
        System.out.println(IOMessage.GAME_START);
    }

    public String getUserBall() {
        System.out.print(IOMessage.ENTER_BALL);
        return Console.readLine();
    }

    public String getPlayAgain() {
        System.out.println(IOMessage.CLEAR_GAME);
        System.out.println(IOMessage.PLAY_ANOTHER);
        return Console.readLine();
    }

}
