package designpatterns.state;


public class FanWallControl {
    interface SpeedLevel {
        void rotate(FanWallControl fanWallControl);
    }

    class Off implements SpeedLevel {
        public void rotate(FanWallControl fanWallControl) {
            fanWallControl.set_state(new SpeedLevel1());
        }
    }

    class SpeedLevel1 implements SpeedLevel {
        public void rotate(FanWallControl fanWallControl) {
            fanWallControl.set_state(new SpeedLevel2());
        }
    }

    class SpeedLevel2 implements SpeedLevel {
        public void rotate(FanWallControl fanWallControl) {
            fanWallControl.set_state(new SpeedLevel3());
        }
    }

    class SpeedLevel3 implements SpeedLevel {
        public void rotate(FanWallControl fanWallControl) {
            fanWallControl.set_state(new Off());
        }
    }

    private SpeedLevel current;

    public FanWallControl() {
        current = new Off();
    }

    public void set_state(SpeedLevel state) {
        current = state;
    }

    public void rotate() {
        current.rotate(this);
    }

    @Override
    public String toString() {
        return String.format("FanWallControl [current=%s]", current);
    }

    public static void main(String[] args) {
        FanWallControl fanControl = new FanWallControl();
        System.out.println(fanControl);
        fanControl.rotate();
        System.out.println(fanControl);
        fanControl.rotate();
        System.out.println(fanControl);
        fanControl.rotate();
        System.out.println(fanControl);
        fanControl.rotate();
    }
}