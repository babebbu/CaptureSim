package capturesim.abstracts;

import capturesim.interfaces.Simulator;

public abstract class DefaultSimulator implements Simulator {

    @Override
    public void simulate() {
        start();
        processEvents();
        stop();
    }

    abstract protected void start();
    abstract protected void processEvents();
    abstract protected void stop();

}
