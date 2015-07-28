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

        //
        /**
         * The difference between the strategy and command pattern: - subtle difference : both encapsulate what varies through an object in a class
         *
         * Command : the command pattern encapsulate the request it self. ( lightON, lightOFF). It also allows to combine several commands of several object requests
         * (example : partyMode - turns lightON, StereoON, PoolLightsON, etc) and finally it allows to undo operations and get a log on all operations done
         * The command pattern would be useful in a remote control system application (2 buttons making different things in the same object )
         *
         * Strategy : encapsulate the way (algorithm) the same request is being done ( lightOnBySwitch, lightOnByVoice, etc)
         * The strategy is useful when you want the same object makes completely different things (behaviours).
         */


        /**
         * Answering a very old question. (is anybody seeing lastest answers instead of most voted?)

         It is a valid confusion to have because of the similarities. Both Strategy and Command patterns utilize encapsulation. But that does not make them same.

         The key difference is to understand what is encapsulated. The OO principle, both patterns depend on, is Encapsulate what varies.

         In case of strategy, what varies is algorithm. For example, one strategy object knows how to output to XML file, while the other outputs to, say, JSON. Different algorithms are kept (encapsulated) in different classes. It is as simple as that.

         In case of command, what varies is the request itself. Request may come from File Menu > Delete or Right Click > Context Menu > Delete or Just Delete Button pressed. All three cases can generate 3 command objects of same type. These command objects only represent 3 requests for deletion; not deletion algorithm. Since requests are bunch of objects now, we could manage them easily. Suddenly it become trivial to provide functionality such as undo or redo.

         It doesn't matter how command implements the requested logic. On calling execute(), it may implement an algorithm to trigger deletion or it can even delegate it to other objects, may even delegate to a strategy. It is only implementation detail of the command pattern. This is why it is named as command though it is not a polite way to request :--)

         Contrast it with strategy; this pattern is only concerned with the actual logic that gets executed. If we do that, it helps to achieve different combinations of behaviors with minimal set of classes, thus preventing class explosion.

         I think, Command helps us to broaden our understanding of encapsulation while Strategy provides natural use of encapsulation and polymorphism.

         */


        System.out.println("Command Pattern : encapsulating requests (commands) for the same object (light)..");
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
