package Util;

import Actuators.Actuators;
import Actuators.DoorLock;
import Actuators.LightBulb;
import Actuators.Thermostat;
import Sensors.LightSensor;
import Sensors.MotionSensor;
import Sensors.Sensors;
import Sensors.TemperatureSensor;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

    private List<Actuators> actuators;
    private List<Sensors> sensors;

    private ControlPanel controlPanel;

    public Mediator() {
        this.sensors = new ArrayList<>();
        this.actuators = new ArrayList<>();
    }

    public void changeTemperature() {
        for (Sensors sensor : sensors) {
            if (sensor instanceof TemperatureSensor) {
                for (Actuators actuator : actuators) {
                    if (actuator instanceof Thermostat) {
                        if (sensor.readValue() > 25) {
                            System.out.println("Temperature Sensor Reading value: " + sensor.readValue());
                            actuator.doCommand("decrease");
                            System.out.println("Decreasing temperature");
                            System.out.println("Changed Room Temperature: " + controlPanel.getTemperature());
                        } else if (sensor.readValue() < 20) {
                            System.out.println("Temperature Sensor Reading value: " + sensor.readValue());
                            actuator.doCommand("increase");
                            System.out.println("Increasing temperature");
                            System.out.println("Changed Room Temperature: " + controlPanel.getTemperature());
                        }
                    }
                }
            }
        }
    }

    public void changeLight() {
        for (Sensors sensor : sensors) {
            if (sensor instanceof LightSensor){
                for (Actuators actuator:actuators) {
                    if (actuator instanceof LightBulb){
                        if (sensor.readValue() == 0) {
                            System.out.println("It's bright now. The light will be turned off.");
                            actuator.doCommand("turnOff");
                            System.out.println("Light On: " + ((LightBulb) actuator).isLightOn());
                        }
                        else if (sensor.readValue() == 1) {
                            System.out.println("It's dark now. The light will be turned on.");
                            actuator.doCommand("turnOn");
                            System.out.println("Light On: " + ((LightBulb) actuator).isLightOn());
                        }
                    }
                }
            }
        }
    }

    public void changeDoorLock() {
        for (Sensors sensor : sensors) {
            if (sensor instanceof MotionSensor) {
                for (Actuators actuator:actuators) {
                    if (actuator instanceof DoorLock) {
                        if (sensor.readValue() == 1) {
                            System.out.println("There is a motion. The door will be unlocked.");
                            actuator.doCommand("unLock");
                            System.out.println("Door Locked: " + ((DoorLock) actuator).isDoorLocked());
                        }
                        else if(sensor.readValue() == 0) {
                            System.out.println("There is no motion. The door will be locked.");
                            actuator.doCommand("lock");
                            System.out.println("Door Locked: " + ((DoorLock) actuator).isDoorLocked());
                        }
                    }
                }
            }
        }
    }

    public void changeDoorLockRequest(boolean isDoorLocked){
        for(Actuators actuators : actuators) {
            if (actuators instanceof DoorLock) {
                if(isDoorLocked){
                    actuators.doCommand("lock");
                    for(Sensors sensors: sensors) {
                        if(sensors instanceof MotionSensor) {
                            ((MotionSensor) sensors).setMotion(false);
                        }
                    }
                }
                else{
                    actuators.doCommand("unLock");
                    for(Sensors sensor: sensors) {
                        if(sensor instanceof MotionSensor) {
                            ((MotionSensor) sensor).setMotion(true);
                        }
                    }
                }

            }
        }
    }

    public void changeLightRequest(boolean isLightOn){
        for(Actuators actuators : actuators) {
            if (actuators instanceof LightBulb) {
                if(isLightOn){
                    actuators.doCommand("turnOn");
                    for(Sensors sensors: sensors) {
                        if(sensors instanceof LightSensor) {
                            ((LightSensor) sensors).setLightOn(true);
                        }
                    }
                }
                else{
                    actuators.doCommand("turnOff");
                    for(Sensors sensor: sensors) {
                        if(sensor instanceof LightSensor) {
                            ((LightSensor) sensor).setLightOn(false);
                        }
                    }
                }

            }
        }
    }
    
    //daha sonra thermostattaki commandlere yönlendirmeye bak
    public void changeThermostatTemperatureRequest(int temperature){
        for(Actuators actuators : actuators) {
            if (actuators instanceof Thermostat) {
                ((Thermostat) actuators).setTemperature(temperature);
                controlPanel.setTemperature(temperature);
            }
        }
    }

    public List<Actuators> getActuators() {
        return actuators;
    }

    public void setActuators(List<Actuators> actuators) {
        this.actuators = actuators;
    }

    public List<Sensors> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensors> sensors) {
        this.sensors = sensors;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }
}
