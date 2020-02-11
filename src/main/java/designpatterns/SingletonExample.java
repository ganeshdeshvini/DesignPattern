package designpatterns;

import java.util.Arrays;

public enum SingletonExample {
	INSTANCE;
	private final String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

	public void printFavorites() {
		System.out.println(Arrays.toString(favoriteSongs));
	}
}