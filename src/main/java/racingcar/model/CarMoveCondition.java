package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class CarMoveCondition {

    private static final int RAND_MIN = 0;
    private static final int RAND_MAX = 9;
    private static final int MOVE_CONDITION = 4;

    private int decision() {
        return Randoms.pickNumberInRange(RAND_MIN, RAND_MAX);
    }

    public boolean isMovable() {
        return decision() >= MOVE_CONDITION;
    }
}
