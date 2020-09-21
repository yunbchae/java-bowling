package bowling.domain.bowl.identity;

import bowling.domain.bowl.BowlResult;
import bowling.domain.frame.NormalFrame;
import bowling.domain.score.Score;

public interface BowlIdentity {

    boolean identity(BowlResult bowlResult);
    boolean isCompleted();
    boolean isBonus();
    boolean isStrike();
    Score getScore(NormalFrame normalFrame);
    String format(BowlResult bowlResult);

}