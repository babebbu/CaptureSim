package cwc2020.core.scores;

import capturesim.interfaces.Score;
import lombok.Data;

@Data
public class Item implements Score {

    private String name;
    private int points;

    public Item(String name, int points) {
        setName(name);
        setPoints(points);
    }

    @Override
    public int getPoints() {
        return 0;
    }

}
