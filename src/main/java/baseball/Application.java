package baseball;

import baseball.appconfig.AppConfig;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        BaseballController controller = config.getBaseballController();
        controller.run();
    }
}
