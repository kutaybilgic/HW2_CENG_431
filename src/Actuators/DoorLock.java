package Actuators;

import Util.Mediator;

public class DoorLock extends Actuators{

    private boolean isDoorLocked;

    public DoorLock(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void doCommand(String command) {
        //eğer hareket varsa kapı kilidini aç
        if (command.equals("unLock")) {
            isDoorLocked = false;
        }
        //eğer hareket yoksa kapıyı kilitle
        else if (command.equals("lock")){
            isDoorLocked = true;
        }

    }

    public boolean isDoorLocked() {
        return isDoorLocked;
    }

    public void setDoorLocked(boolean doorLocked) {
        isDoorLocked = doorLocked;
    }
}
