package org;

public class Main {

	public static void main(String[] args) {
		
		int size = 10;
		int numberOfCannibals = 20;
		int numberOfCookers = 10;
		
		Buffer Buffer = new Buffer();
		
		for (int i = 0; i < numberOfCookers; i++) {
			new Cooker(Buffer, size).start();;
		}
		
		for (int i = 0; i < numberOfCannibals; i++) {
			new Cannibal(Buffer).start();
		}
		


	}

}
