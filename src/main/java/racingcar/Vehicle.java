package racingcar;

public interface Vehicle {
    // 이동할 거리 결정
    int decideMovingDistance();

    // 이동
    void move();

    // 이름 반환
    String printName();

    // 현재 위치 반환
    void printCurrentDistance();

    // 이동 거리 출력하는 문자열 생성 & 반환
    String generateDistanceBar();

    // 현재 이동거리 출력
    int printCurrentMovingDistance();
}
