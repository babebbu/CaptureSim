package capturesim.core;

import java.util.List;

public interface Game {

    List<Player> getPlayers();
    List<Score> getScores();
    List<Transaction> getTransactions();

}
