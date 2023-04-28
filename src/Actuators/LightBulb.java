package Actuators;

import Util.Mediator;

public class LightBulb extends Actuators{

    private boolean isLightOn;
    public LightBulb(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void doCommand(String command) {
        //eğer ışık değeri düşükse ışığı aç
        if (command.equals("turnOn")) {
            isLightOn = true;
        }
        //eğer ışık değeri yüksekse ışığı kapat
        else if (command.equals("turnOff")){
            isLightOn = false;
        }
    }

    public boolean isLightOn() {
        return isLightOn;
    }

    public void setLightOn(boolean lightOn) {
        isLightOn = lightOn;
    }
}
