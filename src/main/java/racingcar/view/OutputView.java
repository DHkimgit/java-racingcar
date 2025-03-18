package racingcar.view;

import java.util.List;

import racingcar.dto.CarDto;
import racingcar.dto.RoundResultDto;

public class OutputView {

    public void printMovingDistance(RoundResultDto resultDto) {
        resultDto.cars()
            .forEach(carDetail -> {
                String distanceBar = generateDistanceBar(carDetail.position());
                System.out.println(carDetail.name() + " : " + distanceBar);
            });
        System.out.println(" ");
    }

    public void printWinners(List<String> winners) {
        System.out.printf("최종 우승자 : %s%n", String.join(", ", winners));
    }

    private String generateDistanceBar(int distance) {
        return "-".repeat(Math.max(0, distance));
    }

    public void printError(String message) {
        System.out.println(String.format("[ERROR] : %s", message));
    }
}
