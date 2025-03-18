package racingcar.model;

import java.util.List;

public class RacingGame{
    private final List<Car> participants;
    private final MovePolicy movePolicy;

    public RacingGame(List<Car> participants, MovePolicy movePolicy) {
        this.participants = participants;
        this.movePolicy = movePolicy;
    }

    public void play() {
        participants.forEach(movePolicy::move);
    }

    public List<Car> getParticipants() {
        return participants.stream()
            .map(car -> new Car(car.getName(), car.getPosition()))
            .toList();
    }

    public List<Car> getWinners(){
        int winnerDistance = participants.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return participants.stream()
            .filter(car -> car.getPosition() == winnerDistance)
            .map(car -> new Car(car.getName(), car.getPosition()))
            .toList();
    }
}
