package Trash.CommandExample.Command;

import Trash.CommandExample.Interface.Command;
import Trash.CommandExample.Interface.ElectronicDevice;

public class TurnTVUp implements Command {

    ElectronicDevice theDevice;

    public TurnTVUp(ElectronicDevice theDevice) {
        this.theDevice = theDevice;
    }

    @Override
    public void execute() {
        theDevice.volumeUp();
    }

    @Override
    public void undo() {
        theDevice.volumeDown();
    }
}