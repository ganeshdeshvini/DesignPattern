package designpatterns.command.dzone;

// Client
public class Client {
    //Command
    interface Command {
        void execute();
    }

    // Concreate Command1
    static class LightOnCommand implements Command {
        LightReceiver lightReceiver;

        public LightOnCommand(LightReceiver light) {
            this.lightReceiver = light;
        }

        @Override
        public void execute() {
            this.lightReceiver.switchOn();
        }
    }

    // Concreate Command1
    static class LightOffCommand implements Command {
        LightReceiver lightReceiver;

        public LightOffCommand(LightReceiver lightReceiver) {
            this.lightReceiver = lightReceiver;
        }

        @Override
        public void execute() {
            this.lightReceiver.switchOff();
        }

    }

    // Receiever
    static class LightReceiver {
        private boolean on = false;

        void switchOff() {
            System.out.println("SwitchOff");
            on = false;
        }

        void switchOn() {
            System.out.println("SwitchOn");
            on = true;
        }
    }

    // Invoker Class
    static class RemoteControl {
        Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        void pressButton() {
            this.command.execute();
        }
    }

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        LightReceiver lightReceiver = new LightReceiver();
        Command lightOn = new LightOnCommand(lightReceiver);
        Command lightOff = new LightOffCommand(lightReceiver);

        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
    }
}
