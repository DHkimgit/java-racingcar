package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;

import racingcar.dto.RoundResultDto;
import racingcar.model.Attempts;
import racingcar.model.Car;
import racingcar.model.CarMoveCondition;
import racingcar.model.CarMovePolicy;
import racingcar.model.CarRegister;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        CarRegister carRegister = new CarRegister();
        addCar(carRegister);
        Attempts attempts = addAttempts();
        RacingGame racingGame = init(carRegister);
        play(racingGame, attempts);
        winner(racingGame);
    }

    private void addCar(CarRegister carRegister) {
        carRegister.addCars(inputView.inputCarName());
    }

    private Attempts addAttempts() {
        return Attempts.from(inputView.inputAttempts());
    }

    private RacingGame init(CarRegister carRegister) {
        List<Car> participants = carRegister.check()
            .stream()
            .map(carDetailDto -> new Car(carDetailDto.name(), carDetailDto.distance()))
            .toList();

        return new RacingGame(participants, new CarMovePolicy(new CarMoveCondition()));
    }

    public void play(RacingGame game, Attempts attempts) {
        IntStream.range(0, attempts.attempt()).forEach(i -> {
            game.play();
            List<Car> cars = game.getParticipants();
            outputView.printMovingDistance(RoundResultDto.from(cars));
        });
    }

    public void winner(RacingGame game) {
        List<String> winners = game.getWinners().stream()
            .map(Car::getName)
            .toList();
        outputView.printWinners(winners);
    }
}
