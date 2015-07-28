package myapp;

import myapp.bootstrapper.Bootstraper;
import myapp.model.Light;
import myapp.model.LightOffCommand;
import myapp.model.LightOnCommand;
import myapp.model.RemoteControl;

/**
 * Created by bruno.devesa on 26-07-2015.
 */
public class MainUI {

    public void run() {
     //   Bootstraper bootstraper = new Bootstraper();
     //   bootstraper.execute();

        System.out.println("Command Pattern : encapsulating behaviours (commands) for the same object (light)..");
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        System.out.println("i want to turn on the light...");
        remoteControl.setCommand(lightOnCommand);
        remoteControl.buttonWasPressed();

        System.out.println("i want to turn off the light...");
        remoteControl.setCommand(lightOffCommand);
        remoteControl.buttonWasPressed();

    }
}
