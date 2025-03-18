package racingcar.dto;

import java.util.List;

public record CarDto(
    List<CarDetailDto> cars
) {

    public record CarDetailDto(
        String name,
        Integer distance
    ) {
        public static CarDetailDto from(String name, Integer distance) {
            return new CarDetailDto(name, distance);
        }

        public static CarDetailDto fromRegister(String name) {
            return from(name, 0);
        }
    }
}
