package Sensors;



import Util.Mediator;

import java.util.Random;

public class MotionSensor extends Sensors {

    private boolean isMotion;
    public MotionSensor(Mediator mediator) {
        super(mediator);
        Random random = new Random();
        int randomNumber = random.nextInt(0, 1);
        this.isMotion = randomNumber == 1;
    }

    @Override
    public int readValue() {
        if (isMotion) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public void setMotion(boolean isMotion) {
        this.isMotion = isMotion;
    }
}
