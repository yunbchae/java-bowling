package bowling.domain.state;

import bowling.domain.pin.DownedPins;
import bowling.domain.score.Score;

import java.util.Collections;
import java.util.List;

public class InProgress extends State {
    private final DownedPins downedPins;

    private InProgress(DownedPins downedPins) {
        this.downedPins = downedPins;
    }

    public static InProgress from(DownedPins downedPins) {
        return new InProgress(downedPins);
    }

    @Override
    protected State nextState(DownedPins additionalDownedPins) {
        DownedPins downedPinsTotal = downedPins.add(additionalDownedPins);

        if (downedPinsTotal.isAllDown()) {
            return Spare.from(downedPins);
        }

        return Miss.of(downedPins, additionalDownedPins);
    }

    @Override
    protected Score addBonusScore(Score score) {
        return score.add(downedPins.score());
    }

    @Override
    public List<Integer> getDownedPins() {
        return Collections.singletonList(downedPins.getNumOfDownedPins());
    }
}