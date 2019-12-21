package capturesim.core.interfaces;

import java.util.List;

public interface Game {

    List<Player> getPlayers();
    List<Score> getScores();
    List<Transaction> getTransactions();

}
