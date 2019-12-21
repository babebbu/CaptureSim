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
        add(new Hill("The Fools", 10, 10, 15, 500, 150, 10, 10));
        add(new Hill("GGEZ Hosting", 10, 10, 10, 350, 100, 10, 10));
        add(new Hill("MineKrub", 15, 15, 10, 250,  50, 10, 10));

        // Flags
        add(new Flag("Linux for Dummies Lv. 1", 280));
        add(new Flag("Linux for Dummies Lv. 2", 194));
        add(new Flag("Linux for Dummies Lv. 3", 112));

        add(new Flag("Web for Dummies Lv. 1", 60));
        add(new Flag("Web for Dummies Lv. 2", 160));
        add(new Flag("Web for Dummies Lv. 3", 160));
        add(new Flag("Web for Dummies Lv. 4", 200));

        add(new Flag("Network for Dummies Lv. 1", 70));
        add(new Flag("Network for Dummies Lv. 2", 210));
        add(new Flag("Network for Dummies Lv. 3", 150));

        add(new Flag("Misc.", 170));

        // Items
        add(new Item("Powerful Hint", -10));
    }};

    private List<Transaction> transactions = new ArrayList<>();

}
