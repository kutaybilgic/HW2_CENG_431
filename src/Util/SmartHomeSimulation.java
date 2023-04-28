package Util;

import Actuators.Actuators;
import Actuators.DoorLock;
import Actuators.LightBulb;
import Actuators.Thermostat;
import Sensors.LightSensor;
import Sensors.Sensors;
import Sensors.TemperatureSensor;
import Sensors.MotionSensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SmartHomeSimulation {


    public void runSimulation() throws InterruptedException {
        Mediator mediator = new Mediator();

        ControlPanel controlPanel = new ControlPanel(mediator);
        mediator.setControlPanel(controlPanel);

        Actuators lightBulb = new LightBulb(mediator);
        Actuators doorLock = new DoorLock(mediator);
        Actuators thermostat = new Thermostat(mediator);

        List<Actuators> actuatorsList = new ArrayList<>();
        actuatorsList.add(lightBulb);
        actuatorsList.add(doorLock);
        actuatorsList.add(thermostat);
        mediator.setActuators(actuatorsList);

        Sensors lightSensor = new LightSensor(mediator);
        Sensors temperatureSensor = new TemperatureSensor(mediator);
        Sensors motionSensor = new MotionSensor(mediator);

        List<Sensors> sensorsList = new ArrayList<>();
        sensorsList.add(lightSensor);
        sensorsList.add(temperatureSensor);
        sensorsList.add(motionSensor);
        mediator.setSensors(sensorsList);

        int counter = 0;

        while(counter != 20) {
            System.out.println("Room Temperature: " + controlPanel.getTemperature());
            mediator.changeTemperature();
            mediator.changeLight();
            mediator.changeDoorLock();

            Random random = new Random();
            int temp = random.nextInt(10, 40);
            System.out.println("Temperature has been changed: " + temp);
            controlPanel.setThermostatTemperature(temp);
            mediator.changeTemperature();
            boolean isDoorLocked = random.nextBoolean();
            boolean isLightOn = random.nextBoolean();
            if (isDoorLocked) {
                System.out.println("Door has been locked by user.");
            }
            else {
                System.out.println("Door has been unlocked by user.");
            }

            if (isLightOn) {
                System.out.println("Light has been turned on by user.");
            }
            else {
                System.out.println("Light has been turned off by user.");
            }
            controlPanel.setDoorLocked(isDoorLocked);
            controlPanel.setLightOn(isLightOn);

            System.out.println("Final Room Temperature: " + controlPanel.getTemperature());
            System.out.println("Final Door Locked: " + controlPanel.isDoorLocked());
            System.out.println("Final Light On: " + controlPanel.isLightOn());

            counter ++;
            Thread.sleep(1000);
            System.out.println("\n");
        }




    }



}
