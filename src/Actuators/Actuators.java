package Actuators;

import Util.Mediator;

public abstract class Actuators {

    private Mediator mediator;

    public Actuators(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void doCommand(String command){
        System.out.println("Doing command: " + command);
    }
}
