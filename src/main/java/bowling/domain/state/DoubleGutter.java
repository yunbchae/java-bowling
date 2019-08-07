package bowling.domain.state;

import bowling.domain.Point;
import bowling.exception.IllegalBowlCountException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-bowling
 * create date  : 2019-07-19 13:41
 */
public class DoubleGutter extends DoubleBaseState {
    public static final String DELIMITER = "|";
    private static final String DISPLAT_STATE = "-";

    public DoubleGutter(State state, Point secondBowl) {
        this.firstBowl = state;
        this.secondBowl = secondBowl;
    }

    @Override
    public State update(Point fallCount, boolean isFinalFrame) {
        throw new IllegalBowlCountException();
    }

    @Override
    public String printState() {
        return firstBowl.printState() + DELIMITER + DISPLAT_STATE;
    }

    @Override
    public String toString() {
        return "DoubleGutter{" +
                "firstBowl=" + firstBowl +
                ", secondBowl=" + secondBowl +
                '}';
    }
}