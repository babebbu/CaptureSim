package capturesim.interfaces;

public interface Transaction {

    Player getPlayer();
    Point process();
    int getTimestamp();

}
