package designpatterns.command.wiki_example;

import java.util.ArrayList;
import java.util.List;

/* Client */
public class PressSwitch {
    //COMMAND
    interface Command {
        void execute();
    }

    // The Command for turning on the light - ConcreteCommand #1 */
    static class FlipUpCommand implements Command {
        Light light;

        FlipUpCommand(Light light) {
            this.light = light;
        }

        @Override // Command
        public void execute() {
            light.turnOn();
        }
    }

    /* The Command for turning off the light - ConcreteCommand #2 */
    static class FlipDownCommand implements Command {
        Light light;

        public FlipDownCommand(Light light) {
            this.light = light;
        }

        @Override // Command
        public void execute() {
            this.light.turnOff();
        }
    }

    /* The INVOKER class */
    static class Switch {
        private List<Command> history = new ArrayList<Command>();

        void storeAndExecute(Command command) {
            this.history.add(command);
            command.execute();
        }
    }

    /* The Receiver class */
    static class Light {
        void turnOff() {
            System.out.println("The light is off");
        }

        void turnOn() {
            System.out.println("The light is on");
        }
    }

    public static void main(String[] args) {
        Light light = new Light();

        Command switchUp = new FlipUpCommand(light);
        Command switchDown = new FlipDownCommand(light);

        Switch mySwitch = new Switch();
        mySwitch.storeAndExecute(switchDown);
        mySwitch.storeAndExecute(switchUp);
    }
}