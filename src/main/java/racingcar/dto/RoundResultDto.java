package racingcar.dto;

import java.util.List;

import racingcar.model.Car;

public record RoundResultDto(
    List<CarDetail> cars

) {
    public static RoundResultDto from(List<Car> participants) {
        return new RoundResultDto(
            participants.stream()
                .map(CarDetail::from)
                .toList()
        );
    }

    public record CarDetail(
        String name,
        int position
    ) {
        private static CarDetail from(Car car) {
            return new CarDetail(car.getName(), car.getPosition());
        }
    }
}
