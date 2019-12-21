package capturesim.core;

public interface Simulator {

    default void simulate() {
        start();
        processEvents();
        stop();
    }

    void start();
    void processEvents();
    void stop();
}
