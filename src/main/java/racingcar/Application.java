package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        Integer raceCount = Integer.valueOf(Console.readLine());

        try{
            RacingGame racingGame = new RacingGame(carNames, raceCount);
            racingGame.race();
            racingGame.printWinner();
        } catch (NumberFormatException e){
            System.out.println("error message = 시도할 횟수에 올바른 숫자를 입력해 주세요");
        }
//        catch (IllegalArgumentException e){
//            System.out.println("error message = " + e.getMessage());
//        }
    }
}
