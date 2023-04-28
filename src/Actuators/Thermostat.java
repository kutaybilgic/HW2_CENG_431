package Actuators;


import Util.Mediator;

import java.util.Random;

public class Thermostat extends Actuators{

    private int temperature;

    public Thermostat(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void doCommand(String command) {
        Random random = new Random();
        if (command.equals("increase")) {
            int randomTemp = random.nextInt(20, 25);
            while (temperature != randomTemp) {
                temperature++;
            }
            getMediator().getControlPanel().setTemperature(temperature);
        }
        else if (command.equals("decrease")){
            int randomTemp = random.nextInt(20, 25);
            while (temperature != randomTemp) {
                temperature--;
            }
            getMediator().getControlPanel().setTemperature(temperature);
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
