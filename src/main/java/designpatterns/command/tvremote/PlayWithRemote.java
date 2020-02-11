package designpatterns.command.tvremote;

public class PlayWithRemote {
    //Every Single Command needs to implement
    interface Command {
        void execute();
    }

    //Interface for all Receiver
    interface ElectronicDevice {
        void on();

        void off();

        void volumeUp();

        void volumeDown();
    }

    //Receiver
    class Television implements ElectronicDevice {

        private int volume = 0;

        @Override
        public void on() {
            System.out.println("TV is ON");
        }

        @Override
        public void off() {
            System.out.println("TV is OFF");
        }

        @Override
        public void volumeUp() {
            volume++;
            System.out.println("TV volume is at " + volume);
        }

        @Override
        public void volumeDown() {
            volume--;
            System.out.println("TV volume is at " + volume);
        }

    }

    class TurnTVOff implements Command {
        ElectronicDevice electronicDevice;

        public TurnTVOff(ElectronicDevice electronicDevice) {
            this.electronicDevice = electronicDevice;
        }

        @Override
        public void execute() {
            this.electronicDevice.off();
        }

    }

    class TurnTVOn implements Command {

        ElectronicDevice electronicDevice;

        public TurnTVOn(ElectronicDevice electronicDevice) {
            this.electronicDevice = electronicDevice;
        }

        @Override
        public void execute() {
            this.electronicDevice.on();
        }

    }

    public static void main(String[] args) {

    }

}
