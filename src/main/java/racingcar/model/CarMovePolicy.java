package racingcar.model;

public class CarMovePolicy implements MovePolicy {

    private final CarMoveCondition carMoveCondition;

    public CarMovePolicy(CarMoveCondition carMoveCondition) {
        this.carMoveCondition = carMoveCondition;
    }

    @Override
    public void move(Car car) {
        if(carMoveCondition.isMovable()) {
            car.move(1);
        }
    }
}
