package com.iesvirgendelcarmen.jdbc.teoria;

public class TestSingleton {

	public static void main(String[] args) {
		
		ClaseNoSingleton ns;
		for (int i = 0; i < 10; i++) {
			ns = new ClaseNoSingleton();
			System.out.println(ns);
		} 
		ClaseSingleton s;
		for (int i = 0; i < 10; i++) {
			s = ClaseSingleton.getInstance();
			System.out.println(s);
		} 
	}
}
