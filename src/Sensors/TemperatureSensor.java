package Sensors;

import Util.Mediator;

public class TemperatureSensor extends Sensors {

    public TemperatureSensor(Mediator mediator) {
        super(mediator);
    }



    @Override
    public int readValue() {
        return getMediator().getControlPanel().getTemperature();
    }


}
