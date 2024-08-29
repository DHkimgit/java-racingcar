package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Vehicle{
    private final String name;
    private int distance;

    private static final int MOVE_CONSTRAINTS = 4;
    private static final int RAND_START_INT = 0;
    private static final int RAND_END_INT = 9;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
    @Override
    public int printCurrentMovingDistance() {
        return distance;
    }

    @Override
    public String printName() {
        return name;
    }

    @Override
    public int decideMovingDistance(){
        return Randoms.pickNumberInRange(RAND_START_INT, RAND_END_INT);
    }

    @Override
    public void move(){
        int i = decideMovingDistance();
        if(i >= MOVE_CONSTRAINTS) {
            distance += 1;
        }
    }

    @Override
    public String generateDistanceBar() {
        if (distance <= 0) {
            return ""; // 이동 거리가 0 이하인 경우 빈 문자열 반환
        }

        StringBuilder sb = new StringBuilder();

        sb.append("-".repeat(distance)); // 이동 거리만큼 '-' 출력
        return sb.toString();
    }

    // 출력 형식에 따라 현재 이동 거리 출력
    @Override
    public void printCurrentDistance(){
        System.out.println(name + " : " + generateDistanceBar());
    }
}
