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
            System.out.println("User changed the temperature to: " + temp);
            controlPanel.setThermostatTemperature(temp);
            controlPanel.setDoorLocked(random.nextBoolean());
            controlPanel.setLightOn(random.nextBoolean());

            System.out.println("Changed Room Temperature via Control Panel: " + controlPanel.getTemperature());

            mediator.changeTemperature();
            mediator.changeLight();
            mediator.changeDoorLock();

            System.out.println("Final Room Temperature: " + controlPanel.getTemperature());
            System.out.println("Door Locked: " + controlPanel.isDoorLocked());
            System.out.println("Light On: " + controlPanel.isLightOn());
            counter ++;
            Thread.sleep(1000);
            System.out.println("\n");
        }




    }



}
