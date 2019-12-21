package capturesim.core.interfaces;

public interface Transaction {
    Player getPlayer();
    int process();
    int getTimestamp();
}
