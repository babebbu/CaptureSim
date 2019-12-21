package capturesim.cwc2020.scores;

import capturesim.core.interfaces.Player;
import capturesim.core.interfaces.Score;
import lombok.Data;

import java.util.Optional;

@Data
public class Flag implements Score {

    private String name;
    private int points;
    private int firstBloodPoints;

    private Player firstBloodClaimer;

    public Flag(String name, int points) {
        setName(name);
        setPoints(points);
        setFirstBloodPoints(points / 10);
    }

    @Override
    public int getPoints() {
        return points;
    }

    public Optional<Player> getFirstBloodClaimer() {
        return Optional.ofNullable(firstBloodClaimer);
    }

}
