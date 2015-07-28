package myapp.model;

/**
 * Created by bruno.devesa on 28-07-2015.
 */
public class RemoteControl {

    Command command;

    public RemoteControl() {
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed(){
        command.execute();
    }
}
