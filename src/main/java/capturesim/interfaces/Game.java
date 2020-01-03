package capturesim.interfaces;

import java.util.Collection;

public interface Game {

    Collection<Player> getPlayers();
    Collection<Scorable> getScorables();
    Collection<Transaction> getTransactions();

}
