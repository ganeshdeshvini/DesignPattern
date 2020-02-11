package designpatterns.singleton;


public class MySingletonUsingEnum {
    enum SingletonUsingEnum {
        INSTANCE;

        private SingletonUsingEnum() {
            System.out.println("Here");
        }

        public void retrieveSomething() {
            System.out.println("I am here");
        }
    }

    public static void main(String[] args) {
        SingletonUsingEnum.INSTANCE.retrieveSomething();
        SingletonUsingEnum.INSTANCE.retrieveSomething();
        SingletonUsingEnum.INSTANCE.retrieveSomething();
    }
}