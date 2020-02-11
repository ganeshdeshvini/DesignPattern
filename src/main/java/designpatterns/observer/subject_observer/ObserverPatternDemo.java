package designpatterns.observer.subject_observer;

import java.util.ArrayList;
import java.util.List;


public class ObserverPatternDemo {
    interface Subject {
        void addObserver(Observer o);

        void removeObserver(Observer o);

        void notifyObserver();
    }

    interface Observer {
        void update(String color);
    }

    static class ColorfulSubject implements Subject {
        private List<Observer> observers;
        private String colorMonitored;

        public ColorfulSubject() {
            observers = new ArrayList<Observer>();
        }

        @Override
        public void addObserver(Observer o) {
            observers.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObserver() {
            for (Observer o : observers) {
                o.update(colorMonitored);
            }
        }

        public String getColorMonitored() {
            return colorMonitored;
        }

        public void setColorMonitored(String colorMonitored) {
            this.colorMonitored = colorMonitored;
            notifyObserver();
        }
    }

    static class ObserverOne implements Observer {
        @Override
        public void update(String color) {
            System.out.println("ObserverOne notified and updated for color " + color);
        }
    }

    static class ObserverTwo implements Observer {
        @Override
        public void update(String color) {
            System.out.println("ObserverTwo notified and updated for color " + color);
        }
    }

    public static void main(String[] args) {
        ColorfulSubject colorfulSubject = new ColorfulSubject();

        Observer observer1 = new ObserverOne();
        Observer observer2 = new ObserverTwo();

        colorfulSubject.addObserver(observer1);
        colorfulSubject.addObserver(observer2);

        colorfulSubject.setColorMonitored("REd");
    }
}