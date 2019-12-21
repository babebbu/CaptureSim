package capturesim.cwc2020.games;

import capturesim.cwc2020.scores.Flag;
import capturesim.cwc2020.scores.Hill;
import capturesim.cwc2020.scores.Item;
import capturesim.core.Game;
import capturesim.core.Player;
import capturesim.core.Score;
import capturesim.core.Transaction;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CyberWarfareContest2020Game implements Game {

    private String name;

    private List<Player> players = new ArrayList<>();

    private List<Score> scores = new ArrayList<>() {{
        // Hills
        add(new Hill("The Fools", 10, 10, 10, 500, 150, 10, 10));
        add(new Hill("GGEZ Hosting", 10, 10, 8, 350, 100, 10, 10));
        add(new Hill("MineKrub", 15, 15, 15, 250,  50, 10, 10));

        // Flags
        add(new Flag("Stupid Filter", 200));

        // Items
        add(new Item("Powerful Hint", -10));
    }};

    private List<Transaction> transactions = new ArrayList<>();
}
