package capturesim.core;

public interface Transaction {
    Player getPlayer();
    int process();
    int getTimestamp();
}
