package Actuators;


import Util.Mediator;

public class Thermostat extends Actuators{

    private int temperature;

    public Thermostat(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void doCommand(String command) {
        //sıcaklık düşükse command increase, arttır sıcaklığı
        if (command.equals("increase")) {
            while (temperature != 20) {
                temperature++;
            }
            getMediator().getControlPanel().setTemperature(temperature);
        }
        //sıcaklık yüksekse command decrease, düşür sıcaklığı
        //oda sicakligini 20-25 derece arasina random b'r sayi ver
        else if (command.equals("decrease")){
            while (temperature != 25) {
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
