package cwc2020.core.scores;

import capturesim.interfaces.Player;
import capturesim.interfaces.Score;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Hill implements Score {

    private final double FIRST_BLOOD_FACTOR = 0.2;

    private String name;

    private int interval;
    private int firstClockTick;

    private int increasingPoints;
    private int uniqueCapturePoints;
    private int uniqueCaptureIncreasingPoints;
    private int holdStreakIncreasingPoints;

    @Getter(AccessLevel.PRIVATE)
    private int firstBloodPoints;
    private Player firstBloodClaimer;

    private Player currentHolder;
    private Player nextHolder;
    private List<Player> uniqueCaptures;

    private int holdStreak;

    public Hill(String name, int firstClockTick, int interval, int increasingPoints, int firstBloodPoints, int uniqueCapturePoints, int uniqueCaptureIncreasingPoints, int holdStreakIncreasingPoints) {
        setName(name);
        setFirstClockTick(firstClockTick);
        setInterval(interval);
        setIncreasingPoints(increasingPoints);
        setFirstBloodPoints(firstBloodPoints);
        setUniqueCapturePoints(uniqueCapturePoints);
        setUniqueCaptureIncreasingPoints(uniqueCaptureIncreasingPoints);
        setHoldStreakIncreasingPoints(holdStreakIncreasingPoints);
        setCurrentHolder(null);
        setFirstBloodClaimer(null);
        setUniqueCaptures(new ArrayList<>());
        setHoldStreak(0);
    }

    public Optional<Player> getCurrentHolder() {
        return Optional.ofNullable(currentHolder);
    }

    public Optional<Player> getNextHolder() {
        return Optional.ofNullable(nextHolder);
    }

    public Optional<Player> getFirstBloodClaimer() {
        return Optional.ofNullable(firstBloodClaimer);
    }

    public void increaseHoldStreak() {
        holdStreak++;
    }

    public void increaseUniqueCapturePoints() {
        uniqueCapturePoints += uniqueCaptureIncreasingPoints;
    }

    public int getPoints(int clock) {
        return increasingPoints * (clock / interval);
    }

    public int getCalculatedFirstBloodPoints(int clockTick, int currentTime) {
        if(clockTick < currentTime) {
            firstBloodPoints += getPoints(clockTick);
            clockTick += interval;
            return getCalculatedFirstBloodPoints(clockTick, currentTime);
        }
        return Double.valueOf(firstBloodPoints * FIRST_BLOOD_FACTOR).intValue();
    }

    public int getHoldStreakPoints() {
        return holdStreak * holdStreakIncreasingPoints;
    }

    @Override
    public int getPoints() {
        return 0;
    }

}
