package designpatterns.singleton;

public class SimpleSingleton {
	private static SimpleSingleton instance = new SimpleSingleton();

	private SimpleSingleton() {
	}

	public static SimpleSingleton getSingleInstance() {
		return instance;
	}
	void display(){
		System.out.println("Hey I am here");
	}
	public static void main(String[] args) {
		SimpleSingleton simpleSingleton = SimpleSingleton.getSingleInstance();
		simpleSingleton.display();
	}
}
