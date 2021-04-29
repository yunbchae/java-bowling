package bowling.domain.state;

import bowling.domain.FrameScore;
import bowling.domain.Pins;
import bowling.dto.StateDTO;

import java.util.ArrayList;
import java.util.Objects;

public class Ready implements State{
    private static final String STATE = "READY";
    private Ready(){}

    public static Ready create(){
        return new Ready();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public String state() {
        return STATE;
    }

    @Override
    public State stateAfterPitch(int pitch) {
        Pins pins = Pins.ofFirstPitch(pitch);
        if(pins.isStrike()){
            return Strike.of(pins);
        }
        return Continue.of(pins);
    }

    @Override
    public FrameScore frameScore() {
        return FrameScore.UNSCORED_SCORE;
    }

    @Override
    public FrameScore frameScoreWithBonus(FrameScore prevFrameScore) {
        return FrameScore.UNSCORED_SCORE;
    }

    @Override
    public StateDTO exportStateDTO() {
        return new StateDTO(state(), new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ready)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(STATE);
    }
}