package baseball.appconfig;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig {

    private BaseballService service() {
        return new BaseballService();
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }

    public BaseballController getBaseballController() {
        return new BaseballController(inputView(), outputView(), service());
    }

}
