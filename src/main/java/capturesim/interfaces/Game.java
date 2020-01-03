package capturesim.interfaces;

import java.util.Collection;

public interface Game {

    Collection<Player> getPlayers();
    Collection<Point> getPoints();
    Collection<Transaction> getTransactions();

}
