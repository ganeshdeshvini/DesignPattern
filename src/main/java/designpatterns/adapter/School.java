package designpatterns.adapter;


public class School {
    interface Pen {
        void write(String s);
    }

    static class PilotPen {
        public void mark(String s) {
            System.out.println(s);
        }
    }

    static class PenAdapter implements Pen {
        PilotPen pilotPen = new PilotPen();

        @Override
        public void write(String s) {
            pilotPen.mark(s);
        }
    }

    static class AssignmentWork {
        private Pen p;

        public void writeAssignment(String s) {
        }

        public Pen getP() {
            return p;
        }

        public void setP(Pen p) {
            this.p = p;
        }
    }

    public static void main(String[] args) {
        PilotPen pilotPen = new PilotPen();
        AssignmentWork assignmentWork = new AssignmentWork();
        // error as not compatible
        // assignmentWork.setP(pilotPen);
        assignmentWork.writeAssignment("I m bit tired to write a Assignment");
        //
        Pen pilotPen2 = new PenAdapter();
        AssignmentWork assignmentWork2 = new AssignmentWork();
        // error as not compatible
        assignmentWork2.setP(pilotPen2);
        assignmentWork2.writeAssignment("I m bit tired to write a Assignment");
    }
}
