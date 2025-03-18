package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarDto.CarDetailDto;

public final class CarRegister {

    private final List<CarDetailDto> register = new ArrayList<>();

    public void addCars(String carNames) {
        parseName(carNames).stream()
            .map(CarDetailDto::fromRegister)
            .forEach(register::add);
    }

    public List<CarDetailDto> check() {
        return register;
    }

    private List<String> parseName(String carNames) {
        return Arrays.stream(carNames.split(","))
            .peek(this::validateName)
            .collect(Collectors.toList());
    }

    private void validateName(String carName) {
        if (carName.length() >= 6)
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다");
    }
}
