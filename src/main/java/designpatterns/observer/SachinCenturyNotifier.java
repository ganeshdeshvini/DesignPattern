package designpatterns.observer;

import java.util.ArrayList;
import java.util.List;


public class SachinCenturyNotifier {
    interface Subject {
        void register(Observer observer);

        void unregister(Observer observer);

        void notifyObservers();
    }

    interface Observer {
        void update(String message);
    }

    static class SachinFanSubject implements Subject {
        List<Observer> listObservers;
        String message;

        public SachinFanSubject() {
            listObservers = new ArrayList<Observer>();
        }

        @Override
        public void register(Observer observer) {
            if (!listObservers.contains(observer)) {
                listObservers.add(observer);
            }
        }

        @Override
        public void unregister(Observer observer) {
            if (!listObservers.contains(observer)) {
                listObservers.remove(observer);
            }
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : listObservers) {
                observer.update(message);
            }
        }

        public void setMessage(String message) {
            this.message = message;
            notifyObservers();
        }
    }

    static class Ganesh implements Observer {
        @Override
        public void update(String message) {
            System.out.println("Ganesh notified with " + message);
        }
    }

    static class Leroy implements Observer {
        @Override
        public void update(String message) {
            System.out.println("Leroy notified with " + message);
        }
    }

    public static void main(String[] args) {
        Observer ganesh = new Ganesh();
        Observer leroy = new Leroy();

        SachinFanSubject sachinFanSubject = new SachinFanSubject();
        sachinFanSubject.register(ganesh);
        sachinFanSubject.register(leroy);

        sachinFanSubject.setMessage("Sachin scored a century");
    }
}
