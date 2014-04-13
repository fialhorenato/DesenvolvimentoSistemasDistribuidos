package org;

public class Main {

	public static void main(String[] args) {
		
		int size = 5;
		int numberOfCannibals = 10;
		int numberOfCookers = 1;
		
		Buffer Buffer = new Buffer();
		
		for (int i = 0; i < numberOfCookers; i++) {
			new Cooker(Buffer, size).start();;
		}
		
		for (int i = 0; i < numberOfCannibals; i++) {
			new Cannibal(Buffer).start();
		}
		


	}

}
