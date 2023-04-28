package Sensors;



import Util.Mediator;

import java.util.Random;

public class LightSensor extends Sensors {

    private boolean isLight;

    public LightSensor(Mediator mediator) {
        super(mediator);
        Random random = new Random();
        int randomNumber = random.nextInt(0, 1);
        this.isLight = randomNumber == 1;
    }

    @Override
    public int readValue() {
        if (isLight) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public void setLightOn(boolean isLight) {
        this.isLight = isLight;
    }
}
