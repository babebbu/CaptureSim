package capturesim.core.abstracts;

import capturesim.core.interfaces.Simulator;

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
