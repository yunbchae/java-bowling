package bowling.game.frame;

import bowling.game.Score;

import java.util.List;
import java.util.Optional;

public class FinalFrame extends Frame {
    public static final int FINAL_FRAME_NUMBER = 10;

    public FinalFrame() {
        this.pitches = new FinalPitches();
    }

    @Override
    public void bowl(final int pinCount) {
        pitches.throwBall(pinCount);
    }

    @Override
    public Frame createNextFrame(int frameNumber) {
        throw new IllegalStateException("마지막 프레임은 다음 프레임을 만들 수 없습니다.");
    }

    @Override
    public boolean isLastFrame() {
        return true;
    }

    @Override
    public Optional<Score> calculateScore() {
        if (!hasRemainChance()) {
            return Optional.of(new Score(pitches.getBasicScore(), 0));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Score> calculateBonusScore(Score beforeScore) {
        List<Integer> pinCounts = pitches.getPitchesPinCounts();

        for (int pinCount : pinCounts) {
            beforeScore = addBonusScore(beforeScore, pinCount);
        }

        return beforeScore.canCalculateScore() ? Optional.of(beforeScore) : Optional.empty();
    }
}