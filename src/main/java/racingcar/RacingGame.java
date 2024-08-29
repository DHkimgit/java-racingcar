package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingGame{
    private final List<Car> carList;
    private final int raceCount;

    public RacingGame(String carNames, Integer raceCount) {
        this.carList = initializeCars(carNames);
        this.raceCount = raceCount;
    }

    public void race(){
        System.out.println("\n실행 결과");
        for(int i = 0; i < raceCount; i++){
            for(Car car : carList){
                car.move();
                car.printCurrentDistance();
            }
            System.out.println(" ");
        }
    }

    public void printWinner(){
        // 이동 거리가 큰 순서대로 정렬
        carList.sort(new CarDistanceComparator().reversed());

        int winnerDistance = carList.get(0).printCurrentMovingDistance();

        StringBuilder sb = new StringBuilder();
        sb.append(carList.get(0).printName());

        // 참가자가 1명인 경우 결과 출력
        if(carList.size() == 1) System.out.println("최종 우승자 : " + carList.get(0).printName());

        // 참가자가 여러명인 경우 결과 출력
        else {
            int i = 1;

            while (carList.get(i).printCurrentMovingDistance() == winnerDistance) {
                sb.append(", ");
                sb.append(carList.get(i).printName());
                i += 1;
            }

            System.out.println("최종 우승자 : " + sb);
        }
    }

    // 자동차 객체의 정렬을 위한 Comparator
    public static class CarDistanceComparator implements Comparator<Car> {
        @Override
        public int compare(Car c1, Car c2){
            if (c1.printCurrentMovingDistance() > c2.printCurrentMovingDistance()) {
                return 1;
            }
            else if (c1.printCurrentMovingDistance() < c2.printCurrentMovingDistance()) {
                return -1;
            }
            return 0;
        }
    }

    private static List<Car> initializeCars(String carNames) throws IllegalArgumentException{
        String[] cars = carNames.split(",");
        List<Car> carList = new ArrayList<>();

        for (String name : cars) {
            if (name.length() >= 6) throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다");
            carList.add(new Car(name, 0));
        }

        return carList;
    }
}
