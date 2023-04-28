package Sensors;

import Util.Mediator;

public abstract class Sensors {

    private Mediator mediator;

    public Sensors(Mediator mediator) {
        this.mediator = mediator;
    }

    public int readValue(){
        return 0;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
