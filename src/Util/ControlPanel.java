package Util;

import java.util.Random;

public class ControlPanel {

    //oda sıcaklığı 25
    private int temperature;
    private boolean isDoorLocked;
    private boolean isLightOn;
    private Mediator mediator;

    public ControlPanel(Mediator mediator) {
        this.mediator = mediator;
        Random random = new Random();
        this.temperature = random.nextInt(10, 35);
    }

    public int getTemperature() {
        return temperature;
    }

    //burası oda sıcaklığını değiştiriyor
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    //burası termostat sıcaklığını değiştiriyor
    public void setThermostatTemperature(int temperature) {
        mediator.changeThermostatTemperatureRequest(temperature);
    }

    public boolean isDoorLocked() {
        return isDoorLocked;
    }

    public void setDoorLocked(boolean doorLocked) {
        isDoorLocked = doorLocked;
        mediator.changeDoorLockRequest(doorLocked);

    }

    public boolean isLightOn() {
        return isLightOn;
    }

    public void setLightOn(boolean lightOn) {
        isLightOn = lightOn;
        mediator.changeLightRequest(lightOn);
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
