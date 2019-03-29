package com.iesvirgendelcarmen.jdbc.teoria;

public class ClaseSingleton {
	private static ClaseSingleton claseSingleton;
	private ClaseSingleton () {
		System.out.println("Creado objeto singleton");
	}
	public static ClaseSingleton getInstance() {
		if (claseSingleton == null)
			claseSingleton = new ClaseSingleton();
		return claseSingleton;
	}
}
