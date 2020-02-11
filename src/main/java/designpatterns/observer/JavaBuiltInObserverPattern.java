package designpatterns.observer;

import java.util.Observable;
import java.util.Observer;


public class JavaBuiltInObserverPattern {
    static class DataStore extends Observable {
        String data;

        String getData() {
            return data;
        }

        void setData(String data) {
            this.data = data;
            // mark the observable as changed
            setChanged();
        }
    }

    static class Screen implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            System.out.println(o + " " + arg);
        }
    }

    public static void main(String[] args) {
        Screen screen = new Screen();
        DataStore dataStore = new DataStore();
        dataStore.addObserver(screen);

        dataStore.setData("Set done");
        dataStore.notifyObservers();
    }
}
